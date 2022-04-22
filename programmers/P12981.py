from time import perf_counter_ns as ns


def solution(n, words):
    if len(words[0]) <= 1:
        return [1, 1]
    appeared = {words[0]}
    for i, word in enumerate(words[1:]):
        if (len(word) <= 1
                or not words[i].endswith(word[0])
                or word in appeared):
            return [(i + 1) % n + 1, (i + 1) // n + 1]
        appeared.add(word)
    return [0, 0]


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        (3, ["tank", "kick", "know", "wheel", "land",
             "dream", "mother", "robot", "tank"],
         [3, 3]),
        (5, ["hello", "observe", "effect", "take", "either",
             "recognize", "encourage", "ensure", "establish", "hang",
             "gather", "refer", "reference", "estimate", "executive"],
         [0, 0]),
        (2, ["hello", "one", "even", "never", "now", "world", "draw"],
         [1, 3])
    )
    for num, word_list, expected in tests:
        print(f'solution({num}, {word_list}) returned', end=' ')
        if (result := solution(num, word_list)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(num, word_list)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
