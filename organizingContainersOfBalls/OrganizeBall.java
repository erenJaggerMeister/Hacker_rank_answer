import java.util.*;

public class OrganizeBall {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        int howManyTestCasse = scanner.nextInt();
        for(int testCase=0 ; testCase<howManyTestCasse ; testCase++){
            organizeContainerOfBall();
        }
    }

    private static void organizeContainerOfBall(){
        int iptRowAndCol = scanner.nextInt();
        List<List<Integer>> containers = new ArrayList<>();
        for(int row=0 ; row < iptRowAndCol ; row++){
            List<Integer> containerRow = new ArrayList<>();
            for(int col=0 ; col < iptRowAndCol ; col++){
                int numberOfBall = scanner.nextInt();
                containerRow.add(numberOfBall);
            }
            containers.add(containerRow);
        }

        organizingContainers(containers);
    }

    private static String organizingContainers(List<List<Integer>> container){
        List<Integer> sumOfEachRow = new ArrayList<>();
        List<Integer> sumOfEachCol = new ArrayList<>();

        //count sum row
        for(int row=0;row<container.size();row++){
            int totalSumRow = 0;
            for(int col=0;col<container.get(row).size();col++){
                totalSumRow = totalSumRow + container.get(row).get(col);
            }
            sumOfEachRow.add(totalSumRow);
        }

        //count sum col
        for(int col=0;col<container.get(0).size();col++){
            int totalSumCol = 0;
            for(int row=0;row<container.size();row++){
                totalSumCol = totalSumCol + container.get(row).get(col);
            }
            sumOfEachCol.add(totalSumCol);
        }

        String result = checkOfEachSumRowAndCol(sumOfEachRow, sumOfEachCol);
        System.out.println(result);
        return result;
    }

    private static String checkOfEachSumRowAndCol(List<Integer> sumOfEachRow, List<Integer> sumOfEachCol){
        //sort
        Collections.sort(sumOfEachRow);
        Collections.sort(sumOfEachCol);

        //check each index
        String result = "Possible";
        for(int idx=0;idx<sumOfEachRow.size();idx++){
            int idxRow = sumOfEachRow.get(idx);
            int idxCol = sumOfEachCol.get(idx);
            if(idxRow!=idxCol){
                result = "Impossible";
                return result;
            }
        }
        return result;
    }
}
