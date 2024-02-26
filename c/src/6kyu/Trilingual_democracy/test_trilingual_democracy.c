#include <criterion/criterion.h>
#include "trilingual_democracy.h"


static void test(const char *group, char want) {
  char got = trilingual_democracy(group);
  cr_assert_eq(want, got, "Input: \"%s\" Want: '%c' Got: '%c'\n", group, want, got);
}

Test(Example_Tests, should_pass_example_tests) {
  test("FFF", 'F');
  test("IIK", 'K');
  test("DFK", 'I');
}
