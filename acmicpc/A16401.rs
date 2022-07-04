use std::io::{self, prelude::*};
 
fn solve<B: BufRead, W: Write>(mut scan: Scanner<B>, mut w: W) {
    let (m, n) = (scan.token(), scan.token());
    let mut s = Vec::with_capacity(n);
    let mut r: i32 = 0;
    for _ in 0..n {
        let tmp: i32 = scan.token::<i32>();
        s.push(tmp);
        if tmp > r {
            r = tmp;
        }
    }
    let mut ans: i32 = 0;
    let mut l: i32 = 1;
    let mut mid: i32;
    let mut cnt: i32;
    while l <= r {
        mid = l + (r - l) / 2;
        cnt = 0;
        for i in 0..n {
            cnt += s[i] / mid;
        }
        if cnt >= m { ans = mid; l = mid + 1; }
        else { r = mid - 1; }
    }
    writeln!(w, "{}", ans);
}
 
fn main() {
    let stdin = io::stdin();
    let stdout = io::stdout();
    let reader = Scanner::new(stdin.lock());
    let writer = io::BufWriter::new(stdout.lock());
    solve(reader, writer);
}
 
pub struct Scanner<B> {
    reader: B,
    buf_str: Vec<u8>,
    buf_iter: std::str::SplitWhitespace<'static>,
}
impl<B: BufRead> Scanner<B> {
    pub fn new(reader: B) -> Self {
        Self {
            reader,
            buf_str: Vec::new(),
            buf_iter: "".split_whitespace()
        }
    }
    pub fn token<T: std::str::FromStr>(&mut self) -> T {
        loop {
            if let Some(token) = self.buf_iter.next() {
                return token.parse().ok().expect("Failed parse");
            }
            self.buf_str.clear();
            self.reader.read_until(b'\n', &mut self.buf_str).expect("Failed read");
            self.buf_iter = unsafe {
                let slice = std::str::from_utf8_unchecked(&self.buf_str);
                std::mem::transmute(slice.split_whitespace()) }
        }
    }
}
