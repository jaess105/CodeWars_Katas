#include <stdbool.h>
#include <stdio.h>

// Returned array must be freeable.
//
// *count is an in/out parameter. It contains the size of arr on input,
// and should be set to the lenght of returned array upon return.
//
// When input is invalid, the function should return NULL and set *count to 0.

#define exit    \
    *count = 0; \
    return NULL;

int *up_array(const int *arr, unsigned *count)
{
    unsigned original_count = *count;
    bool increase_size = true;

    if (original_count == 0)
    {
        exit
    }

    for (size_t i = 0; i < *count; ++i)
    {
        if (arr[i] == 9)
            continue;

        increase_size = false;
        if (arr[i] < 0 || arr[i] > 9)
        {
            exit
        }
    }

    if (increase_size)
    {
        (*count)++;
    }

    int *const ret_arr = malloc(sizeof(int) * (*count));

    if (increase_size)
    {
        ret_arr[0] = 1;
    }

    int carry_over = 1;
    int lowest = increase_size ? 1 : 0;

    for (int i = (*count) - 1, j = original_count - 1; i >= lowest; --i, --j)
    {
        int calc = arr[j] + carry_over;
        ret_arr[i] = calc % 10;
        carry_over = calc / 10;
    }
    return ret_arr;
}
