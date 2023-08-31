use std::collections::HashMap;

fn is_valid_walk(walk: &[char]) -> bool {
    fn get_or_0<'a>(map: &'a HashMap<&char, u32>, val: &char) -> u32 {
        *map.get(val).unwrap_or_else(|| &0)
    }

    let map = walk
        .iter()
        .fold(HashMap::new(), |mut map: HashMap<&char, u32>, k| {
            let v = *map.get(k).unwrap_or_else(|| &0_u32) + 1;
            map.insert(&k, v);
            map
        });

    walk.len() == 10
        && get_or_0(&map, &'n') == get_or_0(&map, &'s')
        && get_or_0(&map, &'e') == get_or_0(&map, &'w')
}

// Add your tests here.
// See https://doc.rust-lang.org/stable/rust-by-example/testing/unit_testing.html

#[cfg(test)]
mod tests {
    use super::is_valid_walk;

    #[test]
    fn sample_tests1() {
        assert!(is_valid_walk(&[
            'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'
        ]));
    }
    #[test]
    fn sample_tests2() {
        assert!(!is_valid_walk(&[
            'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e'
        ]));
    }
    #[test]
    fn sample_tests3() {
        assert!(!is_valid_walk(&['w']));
    }
    #[test]
    fn sample_tests4() {
        assert!(!is_valid_walk(&[
            'n', 'n', 'n', 's', 'n', 's', 'n', 's', 'n', 's'
        ]));
    }
    #[test]
    fn sample_tests5() {
        assert!(!is_valid_walk(&[
            'e', 'e', 'e', 'e', 'w', 'w', 's', 's', 's', 's'
        ]))
    }

    #[test]
    fn sample_tests6() {
        assert!(is_valid_walk(&[
            's', 'n', 'n', 'e', 'w', 'e', 'n', 'w', 's', 's'
        ]))
    }

    #[test]
    fn sample_tests7() {
        assert!(is_valid_walk(&[
            'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'
        ]))
    }

    #[test]
    fn sample_tests8() {
        assert!(is_valid_walk(&[
            'e', 'w', 'e', 'w', 'n', 's', 'n', 's', 'e', 'w'
        ]))
    }
}
