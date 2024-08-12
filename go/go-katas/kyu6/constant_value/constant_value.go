package constant_value

import (
	"strings"
)

func solve(str string) int {
	split := strings.FieldsFunc(str, func(r rune) bool {
		return r == 'a' ||
			r == 'e' ||
			r == 'i' ||
			r == 'o' ||
			r == 'u'
	})

	var seq_vals []int
	for _, seq := range split {
		seq_val := 0
		for _, r := range seq {
			seq_val += (int)(r - 'a' + 1)
		}
		seq_vals = append(seq_vals, seq_val)
	}

	return max(seq_vals)
}

func max(slice []int) int {
	max := 0
	for _, i := range slice {
		if max < i {
			max = i
		}
	}
	return max
}
