namespace Katas
{
    public class Clock
    {
        public static int Past(int h, int m, int s)
        {
            return h * 3_600_000 + m * 60_000 + s * 1_000;
        }
    }
}