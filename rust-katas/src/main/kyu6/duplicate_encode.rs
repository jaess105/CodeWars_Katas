use std::collections::HashMap;

fn duplicate_encode(word: &str) -> String {
    let mut seen_chars: HashMap<char, u32> = HashMap::new();

    word.to_lowercase().chars().for_each(|x| {
        seen_chars.insert(x, seen_chars.get(&x).unwrap_or_else(|| &0) + 1);
    });

    word.to_lowercase()
        .chars()
        .map(|x| {
            if *seen_chars.get(&x).unwrap() > 1_u32 {
                ")"
            } else {
                "("
            }
        })
        .fold("".to_string(), |x, y| x + y)
}

#[test]
fn run_tests() {
    assert_eq!(duplicate_encode("din"), "(((");
    assert_eq!(duplicate_encode("recede"), "()()()");
    assert_eq!(duplicate_encode("Success"), ")())())", "should ignore case");
    assert_eq!(duplicate_encode("(( @"), "))((");
}
