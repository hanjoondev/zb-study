import operator


def solution(expression):
    answer, nums, ops, n = 0, [], [], ''
    for c in expression:
        if c in '+-*':
            nums.append(int(n))
            ops.append(c)
            n = ''
        else:
            n += c
    nums.append(int(n))
    for order in '+-* +*- *+- *-+ -+* -*+'.split():
        ops_copy, nums_copy = [o for o in ops], [n for n in nums]
        for op in order:
            calc = operator.add if op == '+' else operator.sub if op == '-' else operator.mul
            i = 0
            while i < len(ops_copy):
                if ops_copy[i] == op:
                    nums_copy[i] = calc(nums_copy[i], nums_copy[i + 1])
                    del ops_copy[i]
                    del nums_copy[i + 1]
                else:
                    i += 1
        answer = max(abs(answer), abs(nums_copy[0]))
    return answer
