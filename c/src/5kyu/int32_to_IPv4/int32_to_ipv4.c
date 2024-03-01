#include <inttypes.h>
#include <stdio.h>

void uint32_to_ip(uint32_t number, char *IPv4)
{
    sprintf(
        IPv4,
        "%d.%d.%d.%d",
        (uint8_t)(number >> 24),
        (uint8_t)(number >> 16),
        (uint8_t)(number >> 8),
        (uint8_t)number);
}