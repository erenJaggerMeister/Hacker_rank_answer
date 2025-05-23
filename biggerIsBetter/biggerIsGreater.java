package biggerIsBetter;
import java.util.*;

public class biggerIsGreater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iter_limit = sc.nextInt();
        for(int i=0;i<iter_limit;i++){
            String input_text = sc.next();
            String output_text = biggerIsGreater(input_text);
            System.out.println(output_text);
        }
    }
    public static String biggerIsGreater(String w) {
    // Write your code here
        String result = "";
        char[] letters = w.toCharArray();
        for(int i=letters.length-1;i>0;i--){
            char[] current_arr_char = letters;
            for(int j=i;j>0;j--){
                int change_index = j-1;
                char get_curr_char = current_arr_char[j];
                current_arr_char[j] = current_arr_char[change_index];
                current_arr_char[change_index] = get_curr_char;

                //check greater
                String current_string = new String(current_arr_char);
                // System.out.println(current_string);
                if(current_string.compareTo(w) > 0){
                    result = current_string;
                    return result;
                }
            }
        }
        if (result.equals("")) {
            result = "no answer";
        }
        return result;
    }
}
