#include <stdlib.h>
#include <stdio.h>
#include <criterion/criterion.h>
#include "plus_one_array.h"

#define ARRAY_COUNT(a) (sizeof(a) / sizeof((a)[0]))

int *up_array(const int *arr, unsigned *count);
void do_test(const int *arr, unsigned count, const int *expected, unsigned expcount);
static void complete_test();

Test(sample_test1, example_tests)
{
    int arr[] = {2, 3, 9},
        exp[] = {2, 4, 0};
    do_test(arr, ARRAY_COUNT(arr), exp, ARRAY_COUNT(exp));
    complete_test();
}

Test(sample_test2, example_tests)
{
    int arr[] = {4, 3, 2, 5},
        exp[] = {4, 3, 2, 6};
    do_test(arr, ARRAY_COUNT(arr), exp, ARRAY_COUNT(exp));
    complete_test();
}

Test(sample_test3, example_tests)
{
    int arr[] = {1, -9};
    do_test(arr, ARRAY_COUNT(arr), NULL, 0);
    complete_test();
}

Test(sample_test4, example_tests)
{
    int arr[] = {0, 4, 2},
        exp[] = {0, 4, 3};
    do_test(arr, ARRAY_COUNT(arr), exp, ARRAY_COUNT(exp));
    complete_test();
}

Test(sample_test5, example_tests)
{
    int arr[] = {9, 9, 9},
        exp[] = {1, 0, 0, 0};
    do_test(arr, ARRAY_COUNT(arr), exp, ARRAY_COUNT(exp));
    complete_test();
}

Test(sample_test6, example_tests)
{
    int arr[] = {9, 2, 2, 3, 3, 7, 2, 0, 3, 6, 8, 5, 4, 7, 7, 5, 8, 0, 7},
        exp[] = {9, 2, 2, 3, 3, 7, 2, 0, 3, 6, 8, 5, 4, 7, 7, 5, 8, 0, 8};
    do_test(arr, ARRAY_COUNT(arr), exp, ARRAY_COUNT(exp));
    complete_test();
}

void do_test(const int *arr, unsigned count, const int *expected, unsigned expcount)
{
    int original_count = count;
    int *actual = (int *)up_array(arr, &count);

    if (expected != NULL)
        cr_assert_not_null(actual);

    cr_expect_eq(count, expcount, "expected size of %d, but was %d", expcount, count);
    cr_assert_arr_eq(actual, expected, expcount, "expected start %d actual start %d", expected[0], actual[0]);


    printf("Original: ");
    print_arr(arr, original_count, "%d, ");
    printf("Expected: ");
    print_arr(expected, count, "%d, ");
    printf("Actual: ");
    print_arr(actual, count, "%d, ");
    printf("\n");

    free(actual);
}

static void complete_test()
{
    fflush(stdout);
    cr_assert(true);
}