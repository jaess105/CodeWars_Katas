#ifdef DEBUG
#define dbg(x) x
#define dbg_log(str, args...) printf(str, args);
#else
#define dbg(x)
#define dbg_log(str, args...)
#endif

#ifdef DEBUG
#define print_arr(arr, len, str)  \
    for (int i = 0; i < len; i++) \
    {                             \
        printf(str, arr[i]);      \
    }                             \
    printf("\n");
#endif

int find_missing(const int *nums, size_t n);
