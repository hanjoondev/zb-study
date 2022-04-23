from time import perf_counter_ns as ns


class Trie:
    def __init__(self):
        self.root = {}

    def add(self, number: str) -> None:
        """ adds a phone number to the Trie """
        node = self.root
        for char in number:
            if char not in node:
                node[char] = {}
            node = node[char]

    def find(self, prefix) -> dict:
        """ returns node with given prefix """
        node = self.root
        for char in prefix:
            if char not in node.keys():
                return None
            node = node[char]
        return node


def solution(numbers):
    yellowpage = Trie()
    for n in numbers:
        yellowpage.add(n)
    for n in numbers:
        if (d := yellowpage.find(n)) is not None and len(d.values()):
            return False
    return True


if __name__ == '__main__':
    ITERATIONS = 1
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        (["119", "97674223", "1195524421"], False),
        (["123", "456", "789"], True),
        (["12", "123", "1235", "567", "88"], False)
    )
    for phone_numbers, expected in tests:
        print(f'solution({phone_numbers}) returned', end=' ')
        if (result := solution(phone_numbers)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(phone_numbers)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
