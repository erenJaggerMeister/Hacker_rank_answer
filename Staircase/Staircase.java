import java.util.*;

public class Staircase {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int angkaStair = sc.nextInt();
        int sisaKolom = -1;
        for(int i=0;i<angkaStair;i++){
            sisaKolom = ((i)%angkaStair)+1;
            for(int j=0;j<angkaStair;j++){
                if(j>=(angkaStair-sisaKolom)){
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
