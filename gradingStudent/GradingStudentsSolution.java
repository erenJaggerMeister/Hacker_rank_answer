package gradingStudent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradingStudentsSolution {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int howManyStudent = sc.nextInt();
        int[] scoreOfEachStudent = new int[howManyStudent];

        for(int i=0 ; i<howManyStudent ; i++){
            scoreOfEachStudent[i] = sc.nextInt();
        }

        for(int i=0 ; i<howManyStudent ; i++){
            int finalResult = 0;
            if(scoreOfEachStudent[i]<38){
                finalResult = scoreOfEachStudent[i];
                System.out.println(finalResult+" ");
                continue;
            }

            int rounded = (int) Math.ceil(scoreOfEachStudent[i] / 5.0) * 5;
            int difference = Math.abs(rounded - scoreOfEachStudent[i]);
            System.out.println("Rounded: "+rounded+" ;Hasil selisih: "+difference);
            if(difference < 3){
                finalResult = rounded;
            } else {
                finalResult = scoreOfEachStudent[i];
            }
            System.out.println(finalResult);
        }
        System.out.println();
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> finalResult = new ArrayList<>();
        for(int i=0 ; i<grades.size() ; i++){
            if(grades.get(i)<38){
                finalResult.add(grades.get(i));
                continue;
            }

            int rounded = (int) Math.ceil(grades.get(i) / 5.0) * 5;
            int difference = Math.abs(rounded - grades.get(i));
            if(difference < 3){
                finalResult.add(rounded);
            } else {
                finalResult.add(grades.get(i));
            }
        }
        return finalResult;
    }
}
