package append_and_delete;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class append_and_delete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int k = sc.nextInt();
        String result = appendAndDelete(s, t, k);
        System.out.println(result);
    }
    public static String appendAndDelete(String s, String t, int k) {
    // Write your code here
        String res = "No";
        List<Character> s_convert = new ArrayList<>();
        for(char e : s.toCharArray()){
            s_convert.add(e);
        }

        List<Character> t_convert = new ArrayList<>();
        for(char e : t.toCharArray()){
            t_convert.add(e);
        }
        //check delete char
        for(int i=0;i<k;i++){
            s_convert.removeLast();
            if(t_convert.containsAll(s_convert)){
                res = "Yes";
                break;
            }
        }
        return res;
    }
}
