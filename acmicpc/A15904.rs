use std::io::stdin;

fn main() {
    let mut input = String::new();
    stdin().read_line(&mut input).unwrap();
    let target = "UCPC";
    let mut t = target.chars().next().unwrap();
    let mut i = 0;
    for c in input.chars() {
        if c == t {
            if i < 3 {
                i += 1;
                t = target.chars().nth(i).unwrap();
            } else {
                i += 1;
                break;
            }
        }
    }
    if i == 4 {
        println!("I love UCPC");
    } else {
        println!("I hate UCPC");
    }
}
