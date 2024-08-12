using NUnit.Framework;

namespace TestProject.Extensions;

public static class AssertExtensions
{
    public static void AreEqual<TA, TB>(TA a, TB b)
    {
        Assert.That(a, Is.EqualTo(b));
    }

    public static void AreEqual<TA, TB>(TA a, TB b, string errorMsg)
    {
        Assert.That(a, Is.EqualTo(b), errorMsg);
    }
}