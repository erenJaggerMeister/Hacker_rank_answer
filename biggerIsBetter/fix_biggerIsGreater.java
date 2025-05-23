package biggerIsBetter;
import java.util.*;

public class fix_biggerIsGreater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iter_limit = sc.nextInt();
        sc.nextLine(); // Consume newline
        for (int i = 0; i < iter_limit; i++) {
            String input_text = sc.nextLine();
            String output_text = biggerIsGreater(input_text);
            System.out.println(output_text);
        }
    }
    public static String biggerIsGreater(String w) {
        char[] chars = w.toCharArray();
        int i = chars.length - 2;

        // Step 1: Find pivot
        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--;
        }

        if (i == -1) {
            return "no answer"; // Already the last permutation
        }

        // Step 2: Find rightmost successor to the pivot
        int j = chars.length - 1;
        while (chars[j] <= chars[i]) {
            j--;
        }

        // Step 3: Swap
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;

        // Step 4: Reverse suffix
        int start = i + 1;
        int end = chars.length - 1;
        while (start < end) {
            char t = chars[start];
            chars[start] = chars[end];
            chars[end] = t;
            start++;
            end--;
        }

        return new String(chars);
    }
}
