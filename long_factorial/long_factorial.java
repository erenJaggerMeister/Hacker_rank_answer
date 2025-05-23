package long_factorial;
import java.math.BigInteger;
import java.util.*;

public class long_factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int upper_limit = sc.nextInt();
        extraLongFactorials(upper_limit);
    }
    private static void extraLongFactorials(int n){
        BigInteger sum = new BigInteger("1");
        for(int i=0;i<n;i++){
            String add_number = Integer.toString((i+1));
            BigInteger current_number = new BigInteger(add_number);
            sum = sum.multiply(current_number);
        }
        System.out.println(sum);
    }
}
