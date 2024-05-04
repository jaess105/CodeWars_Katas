use regex::Regex;

lazy_static! {
    static ref NUM_REGEX: Regex = regex::Regex::new(r"(\d+)").unwrap();
}

fn get_number(word: &str) -> u32 {
    NUM_REGEX.captures(word).unwrap()[0].parse::<u32>().unwrap()
}

fn order(sentence: &str) -> String {
    let mut res: Vec<&str> = sentence.split_whitespace().collect();
    res.sort_by_key(|word| get_number(&word));
    res.join(" ")
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn returns_expected() {
        assert_eq!(order(""), "");
    }

    #[test]
    fn minimal_test() {
        assert_eq!(order("is2 Thi1s T4est 3a"), "Thi1s is2 3a T4est");
    }
}
