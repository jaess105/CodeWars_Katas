pub fn narcissistic(num: u64) -> bool {
    fn sum(x: u64, y: u64) -> u64 {
        x + y
    }

    let mut vec: Vec<u64> = Vec::new();
    let mut n = num;
    while n != 0 {
        vec.push(n % 10);
        n /= 10;
    }
    let exponent = vec.len() as u32;
    vec.iter().map(|x| x.pow(exponent)).reduce(sum).unwrap() == num
}

#[cfg(test)]
mod tests {
    use super::*;

    fn dotest(input: u64, expected: bool) {
        let actual = narcissistic(input);
        assert_eq!(
            actual, expected,
            "\nIncorrect answer for n={}\nExpected: {expected}\nActual: {actual}",
            input
        )
    }

    #[test]
    fn basic_tests1() {
        dotest(7, true);
    }

    #[test]
    fn basic_tests2() {
        dotest(371, true);
    }

    #[test]
    fn basic_tests3() {
        dotest(122, false);
    }

    #[test]
    fn basic_tests4() {
        dotest(4887, false);
    }
}
