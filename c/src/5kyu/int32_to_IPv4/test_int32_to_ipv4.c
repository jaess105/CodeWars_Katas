#include <criterion/criterion.h>
#include <inttypes.h>

extern void uint32_to_ip (uint32_t ip, char *output);
static void do_test (uint32_t number, const char *expected);

Test(uint32_to_ip, BasicTest) 
{
	do_test(1234, "0.0.4.210");
	do_test(2154959208, "128.114.17.104");
	do_test(0, "0.0.0.0");
	do_test(UINT32_MAX, "255.255.255.255");
	do_test(2149583361, "128.32.10.1");
	do_test(1804289383, "107.139.69.103");
}

static void do_test (uint32_t number, const char *expected)
{
	char actual[16] = "@@@@@@@@@@@@@@@@";
	uint32_to_ip(number, actual);
	cr_assert_str_eq(actual, expected,
		"for uint32 = %"PRIu32" expected:\n\"%s\"\nbut got:\n\"%s\"",
		number, expected, actual
	);
}