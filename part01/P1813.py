def solution(s, fr, to):
    return __import__("re").sub(r"\b{}\b".format(fr) if len(fr) > 1
                                else r"{}".format(fr), to, s)


if __name__ == '__main__':
    data = [
        ["Hello Java, Nice to meet you! Java is fun!", "Java", "자바"],
        ["POP", "P", "W"]
    ]
    for s, fr, to in data:
        print(solution(s, fr ,to))
