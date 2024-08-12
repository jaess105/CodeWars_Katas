#ifdef DEBUG
#include <stdio.h>
#define dbg(x) x
#define dbg_log(str, args...) printf(str, args)
#else
#define dbg(x)
#define dbg_log(str, args...)
#endif

#ifdef DEBUG
#define print_arr(arr, len, str)  \
    printf("[");                  \
    for (int i = 0; i < len; i++) \
    {                             \
        printf(str, arr[i]);      \
    }                             \
    printf("]\n");
#else
#define print_arr(arr, len, str)
#endif

int beeramid(double bonus, double price);