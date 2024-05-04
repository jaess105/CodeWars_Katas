fn least_larger(a: &[i32], i: usize) -> Option<usize> {
    let lower_bound = &a[i];
    let mut lowest_higher: Option<(usize, &i32)> = None;
    for (j, x) in a.iter().enumerate() {
        if x > lower_bound && (lowest_higher.is_none() || lowest_higher.unwrap().1 > x) {
            lowest_higher.replace((j, x));
        }
    }

    lowest_higher.and_then(|(j, _)| Some(j))
}

// Add your tests here.
// See https://doc.rust-lang.org/stable/rust-by-example/testing/unit_testing.html

#[cfg(test)]
mod tests {
    use super::least_larger;

    const ERR_MSG: &str = "\nYour result (left) did not match the expected output (right)";

    fn dotest(a: &[i32], i: usize, expected: Option<usize>) {
        assert_eq!(
            least_larger(a, i),
            expected,
            "{ERR_MSG} with a = {a:?}, i = {i}"
        )
    }

    #[test]
    fn sample_tests() {
        dotest(&[4, 1, 3, 5, 6], 0, Some(3));
        dotest(&[4, 1, 3, 5, 6], 4, None);
        dotest(&[1, 3, 5, 2, 4], 0, Some(3));
    }
}
