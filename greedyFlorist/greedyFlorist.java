import java.util.Arrays;
import java.util.Scanner;

public class greedyFlorist {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int totalBunga = sc.nextInt();
        int totalTeman = sc.nextInt();
        int[] arrayBunga = new int[totalBunga];

        for(int i=0 ; i<totalBunga ; i++){
            arrayBunga[i] = sc.nextInt();
        }

        int totalHargaBunga = getMinimumCost(totalTeman, arrayBunga);
        System.out.println("Total harga bunga yang didapatkan = " + totalHargaBunga);
    }

    public static int getMinimumCost(int k, int[] c){
        Arrays.sort(c);

        int[] reverseArraySort = new int[c.length];
        int indexMaks = c.length - 1;
        for(int i = 0; i<c.length ; i++){
            reverseArraySort[i] = c[indexMaks];
            indexMaks--;
        }

        int indexTeman = 0;
        int totalHargaBunga = 0;
        int kIndex = 0;
        for(int i=0 ; i<c.length ; i++){
            int hrgBunga = (kIndex + 1) * reverseArraySort[i];
            totalHargaBunga += hrgBunga;
            indexTeman++;
            if(indexTeman==k){
                indexTeman = 0;
                kIndex++;
            }
        }

        return  totalHargaBunga;
    }
}
