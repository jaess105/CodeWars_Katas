// Returns number of complete beeramid levels
int beeramid(double bonus, double price)
{
    int level = 1;
    for (int beers = 1;
         (bonus >= price * (beers = level * level));
         ++level)
    {
        bonus -= price * beers;
    }

    return level - 1;
}