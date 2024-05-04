fn check_exam(arr_a: &[&str], arr_b: &[&str]) -> i64 {
    arr_a
        .iter()
        .zip(arr_b)
        .fold(0, |res, answers| {
            res + match answers {
                (a, b) if a == b => 4,
                (_, b) if *b == "" => 0,
                _ => -1,
            }
        })
        .max(0)
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn basic() {
        assert_eq!(check_exam(&["a", "a", "b", "b"], &["a", "c", "b", "d"]), 6);
        assert_eq!(check_exam(&["a", "a", "c", "b"], &["a", "a", "b", ""]), 7);
        assert_eq!(check_exam(&["a", "a", "b", "c"], &["a", "a", "b", "c"]), 16);
        assert_eq!(check_exam(&["b", "c", "b", "a"], &["", "a", "a", "c"]), 0);
    }
}
