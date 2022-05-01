from sys import stdin as s


def solution(n: int, devices: list[int]) -> None:
    d = {}
    for device in devices:
        d[device] = d.get(device, 0) + 1
    power_strip = [0] * n
    num_swaps = 0
    for i, new_device in enumerate(devices):
        d[new_device] -= 1
        if new_device in power_strip:
            continue
        elif 0 in power_strip:
            power_strip[power_strip.index(0)] = new_device
        else:
            last = last_idx = 0
            for device in power_strip:
                if not d[device]:
                    last = device
                    break
                elif (idx := devices[i:].index(device)) > last_idx:
                    last_idx = idx
                    last = device
            power_strip[power_strip.index(last)] = new_device
            num_swaps += 1
    print(num_swaps)


def reader():
    n, k = map(int, s.readline().split())
    solution(n, list(map(int, s.readline().split())))


if __name__ == '__main__':
    reader()
