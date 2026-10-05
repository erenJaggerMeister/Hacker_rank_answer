import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class plusMinus {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int banyakAngka = sc.nextInt();
        int[] arrayAngka = new int[banyakAngka];
        List<Integer> listAngka = new ArrayList<>();
        for(int i=0;i<banyakAngka;i++){
            arrayAngka[i] = sc.nextInt();
            listAngka.add(arrayAngka[i]);
        }

        System.out.println("Print Angka");
        for (int i : arrayAngka) {
            System.out.print(i+",");
        }
        System.out.println();

        //panggil methodnya
        plusMinusMethod(listAngka);
    }

    public static void plusMinusMethod(List<Integer> arr){
        int angkaPlus = 0;
        int angkaMinus = 0;
        int angkaNol = 0;

        for(int i : arr){
            if(i>0){
                angkaPlus++;
            }

            if(i<0){
                angkaMinus++;
            }

            if(i==0){
                angkaNol++;
            }
        }

        double avgPlus = (double) angkaPlus/arr.size();
        double avgMinus = (double) angkaMinus/arr.size();
        double avgZero = (double) angkaNol/arr.size();
        
        System.out.printf("%.6f%n", avgPlus);
        System.out.printf("%.6f%n", avgMinus);
        System.out.printf("%.6f%n", avgZero);
    }
}
