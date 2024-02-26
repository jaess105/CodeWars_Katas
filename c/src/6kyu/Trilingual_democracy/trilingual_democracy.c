#include <stdbool.h>

// input is a null-terminated string of three chars from the set
// 'D', 'F', 'I', 'K'; output is a single char from this set
char trilingual_democracy(const char *group)
{
    if (group[0] == group[1])
    {
        return group[2];
    }
    else if (group[0] == group[2])
    {
        return group[1];
    }
    else if (group[1] == group[2])
    {
        return group[0];
    }

    bool got_k = false, got_i = false, got_f = false;

    for (int i = 0; i < 3; i++)
    {
        switch (group[i])
        {
        case 'F':
            got_f = true;
            break;

        case 'I':
            got_i = true;
            break;

        case 'K':
            got_k = true;
            break;
        }
    }

    if (!got_k)
        return 'K';
    else if (!got_i)
        return 'I';
    else if (!got_f)
        return 'F';
    else
        return 'D';
}