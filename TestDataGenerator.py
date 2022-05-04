from os.path import dirname, join
from pathlib import Path as P
from random import randint as ri, choice as rc, sample as rs


class TestDataGenerator:
    def __init__(self, name, n=5):
        self.name = name
        self.tdir = join(dirname(__file__), 'data_big')
        self.mkdir()
        self.save(self.gen_a01935(n))

    def mkdir(self) -> None:
        """ make directory if not exists """
        try:
            P(self.tdir).mkdir(exist_ok=False)
        except FileExistsError:
            pass
    
    def save(self, data: tuple[str]) -> None:
        """ save test data to the following path:
            inputs: ./data_big/{name}in{i}.txt
            outputs: ./data_big/{name}out{i}.txt
            * i: 1, 2, ..., n
            * name: the basename of the module
                    (A01935 for acmicpc.A01935) 
        """
        inputs, outputs = data
        for i, (inp, out) in enumerate(zip(inputs, outputs)):
            with open(join(self.tdir, f'{self.name}in{i+1}.txt'), 'w') as f:
                f.write(inp)
            with open(join(self.tdir, f'{self.name}out{i+1}.txt'), 'w') as f:
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

    def check_a01935(self, rpn: str, vals: list[str]):
        """ check the validity of the test case """
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


if __name__ == '__main__':
    generator = TestDataGenerator('A01935')
