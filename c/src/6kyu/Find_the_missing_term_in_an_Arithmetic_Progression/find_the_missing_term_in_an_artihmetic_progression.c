#include <stddef.h>
#include <stdlib.h>
#include <stdio.h>
#include "find_the_missing_term_in_an_artihmetic_progression.h"

typedef struct DiffS
{
    int diff;
    int occurrence;
} Diff;

void add_to_diffs(Diff *diffs[], int diff);
int occurrence_of(Diff *diffs[], int diff);
int highest_occurring_diff(Diff *diffs[]);
void free_diffs(Diff *diffs[]);

int find_missing(const int *nums, size_t n)
{
    Diff *diffs[2] = {NULL, NULL};
    int result;

    for (size_t i = 1; i < n; i++)
    {
        add_to_diffs(diffs, nums[i] - nums[i - 1]);
    }

    for (size_t i = 1; i < n; i++)
    {
        if (occurrence_of(diffs, nums[i] - nums[i - 1]) == 1)
        {
            result = nums[i - 1] + highest_occurring_diff(diffs);
            free_diffs(diffs);
            return result;
        }
    }

    result = nums[n - 1] + highest_occurring_diff(diffs);
    free_diffs(diffs);

    return result;
}

void add_to_diffs(Diff *diffs[], int diff)
{
    if (diffs[0] == NULL)
    {
        diffs[0] = malloc(sizeof(Diff));
        diffs[0]->occurrence = 1;
        diffs[0]->diff = diff;
    }
    else if (diffs[0]->diff == diff)
    {
        diffs[0]->occurrence++;
    }
    else if (diffs[1] == NULL)
    {
        diffs[1] = malloc(sizeof(Diff));
        diffs[1]->occurrence = 1;
        diffs[1]->diff = diff;
    }
    else
    {
        diffs[1]->occurrence++;
    }
}

int occurrence_of(Diff *diffs[], int diff)
{
    return diffs[0]->diff == diff ? diffs[0]->occurrence : diffs[1]->occurrence;
}

int highest_occurring_diff(Diff *diffs[])
{
    if (diffs[1] == NULL)
    {
        return diffs[0]->diff;
    }

    return diffs[0]->occurrence > diffs[1]->occurrence ? diffs[0]->diff : diffs[1]->diff;
}

void free_diffs(Diff *diffs[])
{
    free(diffs[0]);
    free(diffs[1]);
}
