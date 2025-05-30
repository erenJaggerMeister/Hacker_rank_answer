package Encryption;
import java.io.IOException;
import java.util.*;

public class encryption {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        try{
            String input_text = sc.next();
            String out_string = encryption_res(input_text);
            System.out.println("Hasilnya adalah = "+out_string);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public static String encryption_res(String s) {
    // Write your code here
        String result = "";
        int baris = (int)Math.floor(Math.sqrt(s.length()));
        int kolom = (int)Math.ceil(Math.sqrt(s.length()));
        if (baris*kolom < s.length()) {
            baris++;
        }
        // System.out.println("Baris = "+baris+" ; Kolom = "+kolom);
        char[][] text_two_dimension = new char[baris][kolom];
        int iter_index_string = 0;
        for(int i=0;i<baris;i++){
            for(int j=0;j<kolom;j++){
                text_two_dimension[i][j] = s.charAt(iter_index_string);
                iter_index_string++;
                if (iter_index_string==s.length()) {
                    break;
                }
            }
        }
        // for(int i=0;i<baris;i++){
        //     for(int j=0;j<kolom;j++){
        //         System.out.print(text_two_dimension[i][j]);
        //     }
        //     System.out.println();
        // }
        //encrypt
        for(int j=0;j<kolom;j++){
            for(int i=0;i<baris;i++){
                result += text_two_dimension[i][j];
            }
            result += " ";
        }
        return result;
    }
}
