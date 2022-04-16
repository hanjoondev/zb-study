def solution(dirs):
    d = {c: direc for c, direc in 
         zip('UDRL', ((1, 0), (-1, 0), (0, 1), (0, -1)))}
    v = set()
    r = c = 0
    for cmd in dirs:
        dr, dc = d[cmd]
        nr, nc = r + dr, c + dc
        if -5 <= nr <= 5 and -5 <= nc <= 5:
            v.add(tuple(sorted(((r, c), (nr, nc)))))
            r, c = nr, nc
    return len(v)
