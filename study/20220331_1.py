def solution():
    """
    Problem: https://www.acmicpc.net/problem/17219
    Result: Passed
    """
    line, n = map(int, input().strip('\n').split())
    d = {}
    for _ in range(line):
        url, pwd = input().split()
        d[url] = pwd
    for _ in range(n):
        print(d[input().strip('\n')])


if __name__ == '__main__':
    solution()


'''
16 4
noj.am IU
acmicpc.net UAENA
startlink.io THEKINGOD
google.com ZEZE
nate.com VOICEMAIL
naver.com REDQUEEN
daum.net MODERNTIMES
utube.com BLACKOUT
zum.com LASTFANTASY
dreamwiz.com RAINDROP
hanyang.ac.kr SOMEDAY
dhlottery.co.kr BOO
duksoo.hs.kr HAVANA
hanyang-u.ms.kr OBLIVIATE
yd.es.kr LOVEATTACK
mcc.hanyang.ac.kr ADREAMER
startlink.io
acmicpc.net
noj.am
mcc.hanyang.ac.kr
'''  # data

'''
THEKINGOD
UAENA
IU
ADREAMER
'''  # expected
