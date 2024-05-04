//  don't allocate memory for the results array
//  assign values to the provided results array
//  set length pointer as size of results array
//  after calculations return the results array

#include <stdio.h>
#include <stddef.h>
#include <math.h>
#include <stdlib.h>

typedef unsigned long long ull;

size_t length_of_num(ull num);
ull *sum_dig_pow(ull a, ull b, ull *results, size_t *length);

int main(int argc, char const *argv[])
{
    ull a = 1, b = 100;
    size_t length = 10;
    ull *results = malloc(sizeof(ull) * length);

    sum_dig_pow(a, b, results, &length);

    for (size_t i = 0; i < length; ++i)
    {
        printf("%llu, ", results[i]);
    }

    return 0;
}

ull *sum_dig_pow(ull a, ull b, ull *results, size_t *length)
{
    size_t len;
    size_t ic;
    int digit;
    double num;
    *length = 0;

    for (ull i = a; i <= b; ++i)
    {
        // construct eureka counterpart of number
        ic = i;
        len = length_of_num(i);
        num = 0;
        for (; len > 0; --len)
        {
            digit = ic % 10;
            ic /= 10;
            num += pow(digit, len);
        }
        // is eureka number
        if (num == i)
        {
            results[*length] = i;
            *length += 1;
        }
    }

    return results;
}

size_t length_of_num(ull num)
{
    size_t len = 0;
    while (num >= 1)
    {
        num /= 10;
        ++len;
    }

    return len;
}