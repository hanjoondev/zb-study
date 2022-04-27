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
        data_full_paths = [p + '/data/' + f for f in ldir(join(p, 'data/'))]
        for folder in 'acmicpc kickstart'.split():
            path = join(p, f'{folder}/')
            for m in sorted([basename(f)[:-3]
                            for f in glob(join(path, "*.py")) if isfile(f)]):
                d = sorted([f for f in data_full_paths if m in f])
                with open(f'{p}/{folder}/{m}.py', 'r') as f:
                    pt = ('sys.stdin.readline'
                        if 'from sys import stdin' in f.read()
                        else 'builtins.input')
                self.test(imodule(f'{folder}.{m}'), self.get_data(d), pt)

    def get_data(self, data):
        mock_inputs, expected = [], []
        for i in range(length := len(data) // 2):
            with open(data[i], 'r') as f:
                mock_inputs.append([l.strip('\n') for l in f.readlines()])
            with open(data[i + length], 'r') as f:
                expected.append([l.strip('\n') for l in f.readlines()])
        return mock_inputs, expected

    def test(self, module, data, patch_target):
        print(f'Module {module.__name__} test result:')
        for i, (mock_inputs, expected) in enumerate(zip(data[0], data[1])):
            mock, start = MagicMock(), ns()
            with redirect_stdout(sio := StringIO()):
                with patch(patch_target, side_effect=mock_inputs):
                    module.reader()
                    for _ in range(len(mock_inputs)):
                        mock()
            for actual, exp in zip(sio.getvalue().split('\n'), expected):
                self.assertEqual(actual, exp)
            print(f'test set {i + 1}: '
                  f'{(l := len(expected))} test{"s" if l > 1 else ""} passed '
                  f'in {(ns() - start) // int(1e3):,}μs')


if __name__ == '__main__':
    Tester().prep()
