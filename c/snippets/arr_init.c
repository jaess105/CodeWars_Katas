#define arr_init(type, name, len, num) \
    type name[len];                    \
    for (int i = 0; i < len; i++)      \
    {                                  \
        name[i] = num;                 \
    }