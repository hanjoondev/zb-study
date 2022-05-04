from os.path import dirname, join
from pathlib import Path as P
from random import randint as ri, choice as rc, sample as rs


class TestDataGenerator:
    def __init__(self, n=5):
        self.td = join(dirname(__file__), 'data_big')

    def generate(self, name='', n=5) -> None:
        generators = [m for m in dir(self) if m.startswith('gen_')]
        target = {f'{n.upper()[4:]}': getattr(self, n) for n in generators}
        if name:
            if name.upper() not in target:
                raise ValueError(f'There is no generator for {name.upper()}')
            target = {k: v for k, v in target.items() if k == name.upper()}
        self.mkdir()
        for k, func in target.items():
            self.save(k, func(n))

    def mkdir(self) -> None:
        """ make directory if not exists """
        try:
            P(self.td).mkdir(exist_ok=False)
        except FileExistsError:
            pass
    
    def save(self, name: str, data: tuple[str]) -> None:
        """ save test data to the following path:
            inputs: ./data_big/{name}in{i}.txt
            outputs: ./data_big/{name}out{i}.txt
            * i: 1, 2, ..., n
            * name: the basename of the module
                    (A01935 for acmicpc.A01935) 
        """
        inputs, outputs = data
        for i, (inp, out) in enumerate(zip(inputs, outputs)):
            with open(join(self.td, f'{name}in{i+1}.txt'), 'w') as f:
                f.write(inp)
            with open(join(self.td, f'{name}out{i+1}.txt'), 'w') as f:
                f.write(out)

    def gen_a01935(self, n=5) -> tuple[list[str], list[str]]:
        """ generate test data for acmicpc.A01935 """
        inputs, outputs = [], []
        idx = 0
        while idx < n:
            base = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'[:(len_b := ri(15, 25))]
            nums = [str(ri(1, 100)) for _ in range(len_b)]
            rep = sorted(rs(range(48), len_b + 1))
            actual = ''.join(base[i] * (r - rep[i])
                             for i, r in enumerate(rep[1:]))
            len_a = len(actual)

            base_ops = [rc('++++++++++++++--*****/') 
                        if i > 5 else rc('+*/') for i in range(len_a - 1)]
            rep = sorted(rs(range(len_a - 1), ri(1, len_a - 1)))
            ops = ([base_ops[:rep[0]]] 
                   + [base_ops[rep[j]:r] for j, r in enumerate(rep[1:])] 
                   + [base_ops[rep[-1]:]])
            
            final = actual[0]
            for i, op in enumerate(ops):
                final += actual[i + 1:i + 1 + len(op)] + ''.join(op)
            check = self.check_a01935(final, nums)
            i, o = [], []
            if type(check) == str:
                nums = '\n'.join(nums)
                i.append(f'{len_b}\n{final}\n{nums}\n')
                o.append(f'{check}\n')
                idx += 1
                inputs.append(''.join(i))
                outputs.append(''.join(o))
        return inputs, outputs

    def check_a01935(self, rpn: str, vals: list[str]) -> str | bool:
        """ check the validity of the test case.
            if it's valid, return the expected answer else return False
        """
        from collections import deque as dq
        from operator import add, sub, mul, truediv as div

        o, d = {'+': add, '-': sub, '*': mul, '/': div}, {}
        i = 0
        q = dq()
        for v in rpn:
            if v not in '+-*/':
                if v not in d:
                    d[v] = int(vals[i])
                    i += 1
                q.append(d[v])
                continue
            f, s = q.pop(), q.pop()
            try:
                q.append(o[v](s, f))
                if not (-2e9 <= o[v](s, f) <= 2e9):
                    return False
            except ZeroDivisionError:
                return False
        return f'{q.pop():.2f}'

    def gen_a02164(self, n=5) -> tuple[list[str], list[str]]:
        """ generate test data for acmicpc.A02164 """
        inputs, outputs = [], []
        for _ in range(n):
            random_n = ri(250000, 500000)
            inputs.append(str(random_n) + '\n')
            outputs.append(self.ans_a02164(random_n) + '\n')
        return inputs, outputs
    
    def ans_a02164(self, n: int) -> str:
        """ return the expected answer for acmicpc.A02164 """
        from collections import deque as dq

        q = dq()
        for i in range(1, n + 1):
            q.append(i)
        while len(q) > 1:
            q.popleft()
            q.append(q.popleft())
        return str(q.pop())

if __name__ == '__main__':
    generator = TestDataGenerator()
    generator.generate('A02164')
