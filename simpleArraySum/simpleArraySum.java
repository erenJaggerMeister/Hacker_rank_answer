package simpleArraySum;
import java.util.*;

public class simpleArraySum {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        int besar_array = sc.nextInt();
        for(int i=0;i<besar_array;i++){
            arrayList.add(sc.nextInt());
        }
        System.out.println(simpleArraySum_answer(arrayList));
    }
    public static int simpleArraySum_answer(List<Integer> ar) {
    // Write your code here
        int result = 0;
        for(int i=0;i<ar.size();i++){
            result += ar.get(i);
        }
        return result;
    }
}
