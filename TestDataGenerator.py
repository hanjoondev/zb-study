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

    def gen_a01158(self, n=5) -> tuple[list[str], list[str]]:
        """ generate test data for acmicpc.A01158 """
        inputs, outputs = [], []
        for _ in range(n):
            N = ri(3000, 5000)
            K = ri(5, N - 100)
            inputs.append(f'{N} {K}\n')
            outputs.append(self.ans_a01158(N, K) + '\n')
        return inputs, outputs

    def ans_a01158(self, n: int, k: int) -> str:
        """ return the expected answer for acmicpc.A01158 """
        from collections import deque as dq

        ans = []
        q = dq()
        for i in range(1, n + 1):
            if not i % k:
                ans.append(str(i))
                continue
            q.append(i)
        i = n % k
        while q:
            i += 1
            if not i % k:
                ans.append(str(q.popleft()))
                continue
            q.append(q.popleft())
        return f'<{", ".join(ans)}>'

    def gen_a01802(self, n=5) -> tuple[list[str], list[str]]:
        """ generate test data for acmicpc.A01802 """
        inputs, outputs = [], []
        for _ in range(n):
            i, o = '', ''
            t = ri(50, 100)
            i += str(t) + '\n'
            half_random = t * ri(50, 100) // 100
            full_random = t - half_random
            for _ in range(half_random):
                length = 2**(exp := ri(5, 12)) - 1
                mid = str(ri(0, 1))
                correct = ri(0, 1)
                if not correct:
                    lft = ''.join(rc('01') for _ in range(length // 2))
                    rgt = lft[::-1]
                    i += f'{lft}{mid}{rgt}\n'
                if correct:
                    base = rc('01')
                    for _ in range(exp - 1):
                        base += mid + ''.join('0' if c == '1' else '1' for c in base[::-1])
                    i += f'{base}\n'
                o += self.ans_a01802(f'{lft}{mid}{rgt}' if not correct else base) + '\n'
            for _ in range(full_random):
                length = 2**ri(5, 12) - 1
                full = ''.join(rc('01') for _ in range(length))
                i += f'{full}\n'
                o += self.ans_a01802(full) + '\n'
            inputs.append(i)
            outputs.append(o)
        return inputs, outputs

    def ans_a01802(self, s) -> str:
        if len(s) <= 1:
            return 'YES'
        length = len(s) // 2
        i = 0
        while i < length:
            if s[i] == s[-1 - i]:
                return 'NO'
            i += 1
        return self.ans_a01802(s[:length])

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

    def gen_a02023(self, n=5) -> tuple[list[str], list[str]]:
        """ generate test data for acmicpc.A02023 """
        inputs = rs(range(1, 9), min(n, 8))
        outputs = [self.ans_a02023(i) for i in inputs]
        return [str(i) + '\n' for i in inputs], outputs

    def ans_a02023(self, n: int) -> str:
        """ return a list of right-truncatable primes with n digit(s) """
        d = {
            1: map(str, [2, 3, 5, 7]),
            2: map(str, [23, 29, 31, 37, 53, 59, 71, 73, 79]),
            3: map(str, [233, 239, 293, 311, 313, 317, 373, 379, 593, 599, 719, 733, 739, 797]),
            4: map(str, [2333, 2339, 2393, 2399, 2939, 3119, 3137, 3733, 3739, 3793, 3797, 5939, 7193, 7331, 7333, 7393]),
            5: map(str, [23333, 23339, 23399, 23993, 29399, 31193, 31379, 37337, 37339, 37397, 59393, 59399, 71933, 73331, 73939]),
            6: map(str, [233993, 239933, 293999, 373379, 373393, 593933, 593993, 719333, 739391, 739393, 739397, 739399]),
            7: map(str, [2339933, 2399333, 2939999, 3733799, 5939333, 7393913, 7393931, 7393933]),
            8: map(str, [23399339, 29399999, 37337999, 59393339, 73939133]),
        }
        return '\n'.join(d[n]) + '\n'

    def gen_a02164(self, n=5) -> tuple[list[str], list[str]]:
        """ generate test data for acmicpc.A02164 """
        inputs, outputs = [], []
        for _ in range(n):
            random_n = ri(250000, 500000)
            inputs.append(str(random_n) + '\n')
            outputs.append(str(self.ans_a02164(random_n)) + '\n')
        return inputs, outputs
    
    def ans_a02164(self, n: int) -> str:
        """ return the expected answer for acmicpc.A02164 """
        if n < 2:
            return n
        exp = 1
        while 2**exp < n:
            exp += 1
        exp -= 1
        return (n - 2**exp) * 2


if __name__ == '__main__':
    generator = TestDataGenerator()
    generator.generate()
