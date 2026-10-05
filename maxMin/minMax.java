import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class minMax {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int howManyElementsArray = sc.nextInt();
        int howManyPickElementFromArray = sc.nextInt();

        List<Integer> arrayOfNumber = arrayInsert(howManyElementsArray);
        int resultMinMax = findMinMax(arrayOfNumber, howManyPickElementFromArray);
        System.out.println("result of finding min max ==> "+resultMinMax);
    }

    public static List<Integer> arrayInsert(int howManyElementArray){
        List<Integer> list = new ArrayList<>();

        for(int i=0 ; i<howManyElementArray ; i++){
            int input = sc.nextInt();
            list.add(input);
        }

        list.sort(Integer::compareTo);

        System.out.print("Array input total = ");
        for(Integer i : list){
            System.out.print(i+" - ");
        }
        System.out.println();

        return list;
    }

    public static int findMinMax(List<Integer> arr, int k){
        int minUnfairness = Integer.MAX_VALUE;

        for(int i=0; i<= arr.size() - k ; i++){
            int currentUnfairness = arr.get(i + k - 1) - arr.get(i);
            if(currentUnfairness < minUnfairness){
                minUnfairness = currentUnfairness;
            }
        }

        return minUnfairness;
    }
}
