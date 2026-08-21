using System;

namespace supportProg
{
    public class Cars
    {
        public string listOfCars()
        {
            Console.WriteLine("Here is the list of cars");
            string resultOfStringConcat = "";
            string[] carsInGarage = {"BMW", "Mercedes", "Toyota", "BYD", "KIA"};
            foreach(string i in carsInGarage)
            {
                string printCars = i;
                Console.Write(i+" ");
                resultOfStringConcat = resultOfStringConcat + i + " ";
            }
            Console.WriteLine();
            return resultOfStringConcat;
        }
    }
}