#include <stddef.h>

void move_zeros(size_t len, int arr[len])
{
    int *last_zero = arr;
    size_t i = 0;

    // find first zero
    for (; *last_zero != 0; i++, last_zero++)
    {
        if (i == len)
            return;
    }

    for (; i < len; i++)
    {
        if (arr[i] == 0)
            continue;
        
        *last_zero = arr[i];
        arr[i] = 0;
        last_zero++;
    }
}
