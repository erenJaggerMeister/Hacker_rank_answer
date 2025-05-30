package compareTriplets;
import java.text.ListFormat.Style;
import java.util.*;

public class compareTriplets {
    static Scanner sc =new Scanner(System.in);
    public static void main(String[] args) {
        List<Integer> alice = new ArrayList<>();
        List<Integer> bob = new ArrayList<>();
        for(int i=0;i<3;i++){
            alice.add(sc.nextInt());
        }
        for(int i=0;i<3;i++){
            bob.add(sc.nextInt());
        }
        List<Integer> result = compareTriplets(alice, bob);
        System.out.println(result);
    }
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(0);
        for(int i=0;i<a.size();i++){
            if(a.get(i)>b.get(i)){
                result.set(0, result.get(0)+1);
            } else if (a.get(i)<b.get(i)) {
                result.set(1, result.get(1)+1);
            } else{
                continue;
            }
        }
        return result;
    }
}