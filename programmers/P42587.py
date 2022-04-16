def solution(priorities, location):
    papers = [p + 256 for p in priorities]
    d = {p: papers.count(p) for p in papers}
    target, answer = papers[location], 0
    while True:
        first = papers.pop(0)
        if first >= max(d):
            answer += 1
            if first is target:
                return answer
            d[first] -= 1
            if not d[first]:
                del d[first]
        else:
            papers.append(first)
