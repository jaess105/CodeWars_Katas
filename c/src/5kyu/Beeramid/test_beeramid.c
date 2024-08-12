#include <criterion/criterion.h>

int beeramid(double bonus, double price);
void test_beeramid(double bonus, double price, int expected);

Test(beeramid, should_pass_some_fixed_tests)
{
    test_beeramid(1500., 2., 12);
    test_beeramid(5000., 3., 16);
    test_beeramid(9., 2., 1);
}

void test_beeramid(double bonus, double price, int expected)
{
    int result = beeramid(bonus, price);
    cr_assert_eq(result, expected, "Should have been %d, but was %d", expected, result);
}
