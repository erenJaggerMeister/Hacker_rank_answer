package nonDivisibleSubset;
import java.util.*;

public class nonDivisibleSubset {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int sizeArray = sc.nextInt();
        int divisive_k = sc.nextInt();
        int[] array = new int[sizeArray];
        for(int i=0;i<sizeArray;i++){
            array[i] = sc.nextInt();
        }
        List<List<Integer>> getList = makeSubsetArray(array);
        System.out.println(getList);
    }

    public static List<List<Integer>> makeSubsetArray(int[] array){
        List<List<Integer>> subsetArray = new ArrayList<>();
        int iter_index_max = 0;
        for(int i=0;i<array.length-1;i++){
            List<Integer> object = new ArrayList<>();
            object.add(array[i]);
            for(int j=i+1;j<array.length;j++){
                object.add(array[(i+j)%array.length]);
                subsetArray.add(object);
            }
        }
        return subsetArray;
    }
}
