#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdio.h>
#include "encrypt_this.h"

const int BUFFER_SIZE = 101;

char *encrypt_word(const char *str, size_t str_len);
void trim_mut(char *str);
void encrypt_and_cat(char *dest, const char *src, size_t len);

char *encrypt_this(const char *str)
{
    const size_t str_len = strlen(str);
    size_t curr_start = 0;
    char *const string = malloc(BUFFER_SIZE);
    string[0] = '\0';

    for (size_t curr_end = 0; curr_end < str_len;)
    {
        if (str[curr_end] == ' ')
        {
            encrypt_and_cat(string, &str[curr_start], curr_end - curr_start);
            strcat(string, " ");

            while (str[curr_end] == ' ')
                curr_start = ++curr_end;
        }
        else
            curr_end++;
    }

    if (str[str_len - 1] != ' ')
        encrypt_and_cat(string, &str[curr_start], str_len - curr_start);

    trim_mut(string);
    return string;
}

void encrypt_and_cat(char *dest, const char *src, size_t len)
{
    char *const word = encrypt_word(src, len);
    strcat(dest, word);
    free(word);
}

char *encrypt_word(const char *str, size_t str_len)
{
    int ascii;
    char *const string = malloc(BUFFER_SIZE);

    if (str_len == 0)
    {
        string[0] = '\0';
        return string;
    }

    // ascii
    ascii = (int)str[0];

    sprintf(string, "%d", ascii);

    if (str_len == 1)
        return string;

    // place last char at second place
    strncat(string, &str[str_len - 1], 1);
    strncat(string, &str[2], str_len >= 3 ? str_len - 3 : 0);

    if (str_len >= 3)
        strncat(string, &str[1], 1);

    return string;
}

void trim_mut(char *str)
{
    char *start = str, *end;
    size_t str_len = strlen(str);
    if (str_len == 0)
        return;

    end = &str[str_len - 1];

    for (; *start == ' '; start++)
        ;
    for (; *end == ' '; end--)
        ;
    for (; start <= end; start++, str++)
        *str = *start;

    *str = '\0';
}

char *decrypt_this(const char *str)
{
    int ascii;
    char *string = malloc(BUFFER_SIZE);

    if (strlen(str) == 0)
    {
        string[0] = '\0';
        return string;
    }

    sscanf(str, "%d%s", &ascii, string);

    int len = strlen(string);

    char tmp = string[0];
    string[0] = string[len - 1];
    string[len - 1] = tmp;

    for (size_t i = len; i > 0; i--)
    {
        string[i] = string[i - 1];
    }
    string[0] = (char)ascii;
    string[len + 1] = '\0';

    return string;
}