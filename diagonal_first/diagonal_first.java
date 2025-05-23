package diagonal_first;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import javax.swing.plaf.synth.SynthStyle;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class diagonal_first {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int size_of_matrices = sc.nextInt();
        List<List<Integer>> array_matrices = new ArrayList<>();
        for(int i=0;i<size_of_matrices;i++){
            array_matrices.add(new ArrayList<>());
        }
        for(int i=0;i<size_of_matrices;i++){
            for(int j=0;j<size_of_matrices;j++){
                int input_number = sc.nextInt();
                array_matrices.get(i).add(input_number);
            }
        }
        // System.out.println(size_of_matrices+" & "+array_matrices);
        // System.out.println(array_matrices);
        int sum = diagonalDifference(array_matrices);
        System.out.println(sum);
    }
    public static int diagonalDifference(List<List<Integer>> arr){
        int res = 0;
        //diagonal kiri atas ke kanan bawah
        for(int i=0;i<arr.size();i++){
            res += arr.get(i).get(i);
        }
        // System.out.println(res);
        //diagonal kanan atas ke kiri bawah
        for(int i=0;i<arr.size();i++){
            res -= arr.get(i).get(arr.size()-(i+1));
        }
        if (res<0) {
            res = res * (-1);
        }
        return res;
    }
}