#include <criterion/criterion.h>
#include <stddef.h>
#include "find_the_missing_term_in_an_artihmetic_progression.h"

int find_missing(const int *nums, size_t n);

Test(Sample_Test, should_return_the_missing_term)
{
    cr_assert_eq(find_missing((const int[]){1, 3, 5, 9, 11}, 5ul), 7);
    cr_assert_eq(find_missing((const int[]){-11, -9, -7, -3, -1}, 5ul), -5);
    cr_assert_eq(find_missing((const int[]){1, 1, 1}, 3ul), 1);
}