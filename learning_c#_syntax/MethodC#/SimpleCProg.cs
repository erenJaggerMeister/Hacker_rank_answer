using System;
using supportProg;

namespace CollectionMethod
{
    class ColsMethod
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello world");
            sumOfFruit();
            fruitShop.nameOfFruit();

            Cars myCar = new Cars();

            string carList = myCar.listOfCars();

            Console.WriteLine("Hasil Pemanggilan Kelas Lain: "+carList);
        }

        static void sumOfFruit()
        {
            int x = 5;
            int y = 6;
            Console.WriteLine(x+y);
        }
    }

    class fruitShop
    {
        public static void nameOfFruit()
        {
            Console.Write("Collection of fruit: ");
            string[] fruits = {"banana", "apple", "mango"};
            foreach(string i in fruits)
            {
                Console.Write(i+" ");
            }
            Console.WriteLine();
        }
    }
}