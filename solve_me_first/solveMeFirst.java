package solve_me_first;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class solveMeFirst {
    static int solve(int a, int b) {
      	// Hint: Type return a+b; below 
        int result = a+b;
        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a;
        a = in.nextInt();
        int b;
        b = in.nextInt();
        int sum;
        sum = solve(a, b);
        System.out.println(sum);
    }
}
