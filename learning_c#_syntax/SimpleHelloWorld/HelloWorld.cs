using System;

namespace HelloWorld
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
            Console.WriteLine(3+3);

            string simpanName = "John Doe";
            Console.WriteLine(simpanName);

            string compareString1 = "White Plum";
            string compareString2 = "White Plum";
            bool resultOfCompareTwoString = compareString1 == compareString2;
            Console.WriteLine(resultOfCompareTwoString);

            int numberFirst = 80;
            string testStringNumber = "80";
            Console.WriteLine("The Number: "+numberFirst);
            Console.WriteLine("The String Number: "+testStringNumber);
            Console.WriteLine("Result of compare = "+(testStringNumber.Equals(numberFirst)));
            string convertIntToString = Convert.ToString(numberFirst);
            Console.WriteLine("Result of compare after convert = " + (convertIntToString==testStringNumber));

            Console.WriteLine("Go ahead to input anything");
            string username = Console.ReadLine();
            Console.WriteLine("Here is the result = "+username);

            Console.WriteLine("Input your age");
            int ageOfYours = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Here is your age = "+ageOfYours);

            int numberCompareFirst = 15;
            int numberCompareSecond = 20;
            Console.WriteLine("The result of comparing two number = " +( numberCompareFirst > numberCompareSecond));
            Console.WriteLine("The result of comparing two number = " +( numberCompareSecond > numberCompareFirst));

            Console.WriteLine("The maximum number = "+ Math.Max(numberCompareFirst,numberCompareSecond));
            Console.WriteLine("The minimum number = "+ Math.Min(numberCompareFirst,numberCompareSecond));

            Console.WriteLine("The square of number 15 is "+ Math.Sqrt(numberCompareFirst));
            Console.WriteLine("The square of number 25 is "+ Math.Sqrt(25));

            Console.WriteLine("The length of text input = "+username.Length);

            string strInterpolation = $"The input is: {username}";
            Console.WriteLine(strInterpolation);

            char indexOfWords = username[1];
            Console.WriteLine("The index of words : " + indexOfWords);

            int postionOfWords = username.IndexOf("o");
            Console.WriteLine("The position at: "+postionOfWords);

            Console.WriteLine("Input of first number that will be used in \'if\'");
            int inputFirstNumberOfIf = Convert.ToInt32(Console.ReadLine());

            Console.WriteLine("Input of second number that will be used in \'if\'");
            int inputSecondNumberOfIf = Convert.ToInt32(Console.ReadLine());

            // logic if and else 
            if(inputFirstNumberOfIf > inputSecondNumberOfIf)
            {
                Console.WriteLine("Your first number is bigger than second number");
            } else
            {
                Console.WriteLine("Your first number is smaller than second number \\ Your second number is bigger than first number");
            }

            string resultOfConcatString = "";
            for(int i=0 ; i < inputFirstNumberOfIf ; i++)
            {
                if (i == 4)
                {
                    break;
                }
                resultOfConcatString = string.Concat(resultOfConcatString, Console.ReadLine());
            }
            Console.WriteLine(resultOfConcatString);

            string[] cars = {"mazda", "toyota", "honda", "BMW"};
            for(int i=0 ; i<cars.Length ; i++)
            {
                Console.WriteLine("Mobil kamu di garasi = " + cars[i]);
            }

            Console.WriteLine("Mobil ketiga kamu : " + cars[2]);

            Array.Sort(cars);
            foreach(string i in cars)
            {
                Console.WriteLine(i);
            }

            int[,] numbers = new int [3,5];
            for(int i=0 ; i<3 ; i++)
            {
                for(int j=0 ; j<5 ; j++)
                {
                    numbers[i,j] = Convert.ToInt32(Console.ReadLine());
                }
            }

            // print hasil angka array multi dimensi
            for(int i=0 ; i<3 ; i++)
            {
                for(int j=0 ; j<5 ; j++)
                {
                    Console.Write(numbers[i,j]+" ");
                }
                Console.WriteLine();
            }
        }
    }
}