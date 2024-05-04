fn persistence(mut num: u64) -> u64 {
    let mut iterations = 0;
    while num >= 10 {
        num = num
            .to_string()
            .chars()
            .map(|c| c.to_digit(10).unwrap() as u64)
            .reduce(|first, second| first * second)
            .unwrap_or(0);
        iterations += 1;
    }

    iterations
}

#[cfg(test)]
mod tests {
    use super::persistence;

    #[test]
    fn sample_tests() {
        assert_eq!(persistence(39), 3);
    }
    #[test]
    fn sample_tests1() {
        assert_eq!(persistence(4), 0);
    }
    #[test]
    fn sample_tests2() {
        assert_eq!(persistence(25), 2);
    }
    #[test]
    fn sample_tests3() {
        assert_eq!(persistence(999), 4);
    }
}
