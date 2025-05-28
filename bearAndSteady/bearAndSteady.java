package bearAndSteady;
import java.lang.reflect.Array;
import java.text.ListFormat.Style;
import java.util.*;

public class bearAndSteady {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n_input = sc.nextInt();
        String gene = sc.next();
        char[] gene_convert = gene.toCharArray();
        // int result = steadyGene(gene_convert, n_input);
        System.out.println(steadyGene(gene));
    }
    // public static int steadyGene(char[] array_gen, int number_steady){
    //     int totalSubstring = 0;
    //     char[] huruf = {'A','T','G','C'};
    //     HashMap<Character, Integer> gene_total_char = new HashMap<>();
    //     HashMap<Character, String> gene_status_success = new HashMap<>();
    //     //inisialisasi
    //     for(int i=0;i<4;i++){
    //         gene_total_char.put(huruf[i], 0);
    //         gene_status_success.put(huruf[i], "belum");
    //     }

    //     //masukkan huruf input
    //     for(int i=0;i<array_gen.length;i++){
    //         gene_total_char.put(array_gen[i], (gene_total_char.get(array_gen[i])+1));
    //     }

    //     System.out.println(gene_total_char);

    //     while ((gene_total_char.get('A')!=(array_gen.length/4))||(gene_total_char.get('T')!=(array_gen.length/4))||
    //     (gene_total_char.get('G')!=(array_gen.length/4))||(gene_total_char.get('C')!=(array_gen.length/4))) {
    //         char max = 'A';
    //         for(int i=1;i<huruf.length;i++){
    //             if(gene_total_char.get(huruf[i])>gene_total_char.get(max)){
    //                 max = huruf[i];
    //             }
    //         }

    //         char min = 'A';
    //         for(int i=1;i<huruf.length;i++){
    //             if(gene_total_char.get(huruf[i])<gene_total_char.get(min)){
    //                 min = huruf[i];
    //             }
    //         }

    //         gene_total_char.put(max, (gene_total_char.get(max)-1));
    //         gene_total_char.put(min, (gene_total_char.get(min)+1));
    //         totalSubstring++;

    //         System.out.println(gene_total_char);
    //         System.out.println(totalSubstring);
    //     }

    //     System.out.println(gene_total_char);
    //     System.out.println(totalSubstring);
    //     return totalSubstring;
    // }

    public static int steadyGene(String gene) {
        int n = gene.length();
        int expected = n / 4;
        int[] count = new int[128];  // ASCII

        // Count the characters
        for (char c : gene.toCharArray()) {
            count[c]++;
        }

        // If already steady
        if (count['A'] == expected && count['C'] == expected &&
            count['G'] == expected && count['T'] == expected) {
            return 0;
        }

        int minLength = n;
        int left = 0;

        for (int right = 0; right < n; right++) {
            count[gene.charAt(right)]--;

            while (count['A'] <= expected &&
                   count['C'] <= expected &&
                   count['G'] <= expected &&
                   count['T'] <= expected) {
                minLength = Math.min(minLength, right - left + 1);
                count[gene.charAt(left)]++;
                left++;
            }
        }

        return minLength;
    }
}
