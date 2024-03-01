#include <criterion/criterion.h>
#include <stdio.h>
#include "encrypt_this.h"

static void do_test(const char *str, const char *expected);
static void complete_test();
static void test_trim(const char *expected, const char *test_str);

Test(the_multiply_function1, should_pass_all_the_tests_provided)
{
    do_test("", "");

    complete_test();
}

Test(the_multiply_function2, should_pass_all_the_tests_provided)
{
    do_test("A", "65");

    complete_test();
}
Test(the_multiply_function3, should_pass_all_the_tests_provided)
{

    do_test("Ab", "65b");

    complete_test();
}

Test(the_multiply_function3_2, should_pass_all_the_tests_provided)
{

    do_test("Abc", "65cb");

    complete_test();
}

Test(the_multiply_function4, should_pass_all_the_tests_provided)
{
    do_test("Abcd", "65dcb");
    complete_test();
}
Test(the_multiply_function5, should_pass_all_the_tests_provided)
{

    do_test("Abcd", "65dcb");

    complete_test();
}
Test(the_multiply_function6, should_pass_all_the_tests_provided)
{

    do_test("  Abcd   Abcd", "65dcb 65dcb");
    do_test("Abcd Aahhhhhhhhhhhhhhhhz", "65dcb 65zhhhhhhhhhhhhhhhha");
    do_test(" Hello world ", "72olle 119drlo");
    complete_test();
}
Test(the_multiply_function7, should_pass_all_the_tests_provided)
{

    do_test("Abcd Aahhhhhhhhhhhhhhhhz", "65dcb 65zhhhhhhhhhhhhhhhha");
    complete_test();
}
Test(the_multiply_function8, should_pass_all_the_tests_provided)
{
    do_test(" Hello world ", "72olle 119drlo");
    complete_test();
}

Test(the_multiply_function9, should_pass_all_the_tests_provided)
{
    const char *input = "A wise old owl lived in an oak";
    const char *expected = "65 119esi 111dl 111lw 108dvei 105n 97n 111ka";
    do_test(input, expected);
    complete_test();
}

static void do_test(const char *str, const char *expected)
{
    char *actual = encrypt_this(str);
    if (!actual)
        cr_assert(false, "Received NULL ptr\n");
    if (strcmp(actual, expected) != 0)
        cr_assert(false, "Result from \"%s\":\nExpected \"%s\"\nReceived \"%s\"\n", str, expected, actual);
    free(actual);
}
static void complete_test()
{
    fflush(stdout);
    cr_assert(true);
}

Test(test_the_trimming, test_empty_string)
{
    const char *input = "";
    const char *expected = input;

    test_trim(expected, input);
}

Test(test_the_trimming, test_no_trim_necessary)
{
    const char *input = "hello there";
    const char *expected = input;

    test_trim(expected, input);
}

Test(test_the_trimming, test_trim_necessary)
{
    const char *input = " hello there ";
    const char *expected = "hello there";

    test_trim(expected, input);
}

Test(test_the_trimming, test_big_trim_necessary)
{
    const char *input = "                         hello there                                  ";
    const char *expected = "hello there";

    test_trim(expected, input);
}

Test(test_the_trimming, test_trim_front_necessary)
{
    const char *input = "                         hello there";
    const char *expected = "hello there";

    test_trim(expected, input);
}

Test(test_the_trimming, test_trim_back_necessary)
{
    const char *input = "hello there                                      ";
    const char *expected = "hello there";

    test_trim(expected, input);
}

static void test_trim(const char *expected, const char *input_str)
{
    char *mut_str = malloc(strlen(input_str) + 1);
    strcpy(mut_str, input_str);

    trim_mut(mut_str);
    cr_assert_str_eq(mut_str, expected);

    free(mut_str);
}