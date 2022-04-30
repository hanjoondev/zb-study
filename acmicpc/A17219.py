from sys import stdin


class Trie:
    def __init__(self):
        self.root = {}
        self.pwd = None

    def insert(self, url: str, pwd: str) -> None:
        node = self.root
        for c in url:
            if c not in node:
                node[c] = {}
            node = node[c]
        node['pwd'] = pwd

    def startswith(self, url: str) -> str:
        node = self.root
        for c in url:
            if c not in node:
                return ""
            node = node[c]
        return node['pwd']


def reader():
    num_inserts, num_queries = map(int, stdin.readline().split())
    t = Trie()
    for _ in range(num_inserts):
        url, pwd = stdin.readline().split()
        t.insert(url, pwd)
    ans = [t.startswith(stdin.readline().strip()) for _ in range(num_queries)]
    print('\n'.join(ans))


if __name__ == '__main__':
    reader()


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
'''  # input

'''
THEKINGOD
UAENA
IU
ADREAMER
'''  # expected
