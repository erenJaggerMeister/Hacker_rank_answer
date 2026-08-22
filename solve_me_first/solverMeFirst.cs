using System;

namespace SolveMeFirst.Sum;

class Solution
{
    static void Main(string[] args)
    {
        int val1 = Convert.ToInt32(Console.ReadLine());
        int val2 = Convert.ToInt32(Console.ReadLine());
        int sum = sumMethod(val1, val2);
        Console.WriteLine(sum);
    }

    static int sumMethod(int a, int b)
    {
        int sum = a + b;
        return sum;
    }
}