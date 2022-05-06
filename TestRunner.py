from contextlib import redirect_stdout
from glob import glob
from importlib import import_module as imodule
from io import StringIO
from os import listdir as ldir
from os.path import dirname, basename, isfile, join
from time import perf_counter_ns as ns
from unittest import TestCase
from unittest.mock import MagicMock, patch


class Tester(TestCase):
    def prep(self):
        p = dirname(__file__)
        data_full_paths = [f'{p}/data/{f}' for f in ldir(join(p, 'data'))]
        for folder in 'acmicpc kickstart'.split():
            path = join(p, f'{folder}/')
            for m in sorted([basename(f)[:-3]
                            for f in glob(join(path, "*.py")) if isfile(f)]):
                d = sorted([f for f in data_full_paths if m in f])
                self.test(imodule(f'{folder}.{m}'), self.get_data(d))

    def get_data(self, data: list[str]) -> tuple[list[str], list[str]]:
        mock_inputs, expected = [], []
        for i in range(length := len(data) // 2):
            with open(data[i], 'r') as f:
                mock_inputs.append([l.strip('\n') for l in f.readlines()])
            with open(data[i + length], 'r') as f:
                expected.append([l.strip('\n') for l in f.readlines()])
        return mock_inputs, expected

    def test(self, module, data: tuple[list[str], list[str]]) -> None:
        print(f'Module {module.__name__} test result:')
        for i, (mock_inputs, expected) in enumerate(zip(data[0], data[1])):
            mock, start = MagicMock(), ns()
            with redirect_stdout(sio := StringIO()):
                with patch('sys.stdin.readline', side_effect=mock_inputs):
                    module.reader()
                    for _ in range(len(mock_inputs)):
                        mock()
            for actual, exp in zip(sio.getvalue().split('\n'), expected):
                self.assertEqual(actual, exp)
            print(f'test set {i + 1}: '
                  f'{(l := len(expected))} test{"s" if l > 1 else ""}'
                  f' passed in {(ns() - start) // int(1e3):,}μs')
    
    def benchmark(self, target: str="", iters: int=100, 
                        verbose=True, big_data=False) -> None:
        dt = 'data' if not big_data else 'data_big'
        iters = 3 if big_data and iters == 100 else iters
        p = dirname(__file__)
        files = lambda folder: ldir(join(p, folder))
        bases = sorted([f.strip('.py') for f in files('acmicpc')
                        if f.endswith('.py') 
                        and f.startswith(target if target else 'A')])
        if big_data:
            bases = sorted({f[:6] for f in files(f'{dt}')})
        d = {b: {'module': imodule(f'acmicpc.{b}')} for b in bases}
        for k, v in d.items():
            inputs, outputs = self.get_data(sorted([f'{p}/{dt}/{f}'
                        for f in files(dt) if f.startswith(k)]))
            v['inputs'] = inputs
            v['outputs'] = outputs
        for k, v in d.items():
            module, inputs, outputs = v['module'], v['inputs'], v['outputs']
            v['results'] = []
            print(f'Benchmarking {module.__name__} with ', end='')
            print(f'{"large random" if big_data else "sample"} data sets')
            for (ins, outs) in zip(inputs, outputs):
                results = []
                overall_s = ns()
                for _ in range(iters):
                    mock, start = MagicMock(), ns()
                    with redirect_stdout(sio := StringIO()):
                        with patch('sys.stdin.readline', side_effect=ins):
                            module.reader()
                            for _ in range(len(ins)):
                                mock()
                    for actual, exp in zip(sio.getvalue().split('\n'), outs):
                        self.assertEqual(actual, exp)
                    end = ns()
                    results.append(end - start)
                overall_e = ns()
                v['results'].append((overall_e - overall_s, 
                    sum(results) // len(results), min(results), max(results)))
            if verbose:
                for i, (overall, avg, min_, max_) in enumerate(v['results']):
                    print(f'{k} test set {i + 1} took '
                        f'{overall // int(1e6):,}ms for {iters:,} iterations '
                        f'(avg. {avg // int(1e3):,}μs |'
                        f' min. {min_ // int(1e3):,}μs |'
                        f' max. {max_ // int(1e3):,}μs)')


if __name__ == '__main__':
    Tester().prep()
    Tester().benchmark()
    Tester().benchmark(big_data=True)
