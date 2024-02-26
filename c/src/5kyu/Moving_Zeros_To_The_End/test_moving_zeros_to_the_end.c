#include <criterion/criterion.h>
#include "moving_zeros_to_the_end.h"

// extern void do_test(size_t len, int *arr, int *expected);
void do_test(size_t len, int *arr, int *expected)
{
    move_zeros(len, arr);
    cr_assert_arr_eq(
        arr, expected, len);
}

Test(move_zeros, sample_tests)
{
    do_test(8, ((int[]){0, 1, 0, 2, 0, 3, 4, 5}), ((int[]){1, 2, 3, 4, 5, 0, 0, 0}));
    do_test(20, ((int[]){9, 0, 0, 9, 1, 2, 0, 1, 0, 1, 0, 3, 0, 1, 9, 0, 0, 0, 0, 9}), ((int[]){9, 9, 1, 2, 1, 1, 3, 1, 9, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    do_test(2, ((int[]){0, 0}), ((int[]){0, 0}));
    do_test(1, ((int[]){0}), ((int[]){0}));
    do_test(0, ((int[]){}), ((int[]){}));
}
