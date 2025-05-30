package minimumLoss;
import java.util.*;

public class minLoss {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int years = sc.nextInt();
        List<Long> priceOfHouse = new ArrayList<>();
        for(int i=0;i<years;i++){
            priceOfHouse.add(sc.nextLong());
        }
        System.out.println(minimumLoss(priceOfHouse));
    }
    // public static int minimumLoss(List<Long> price) {
    // // Write your code here
    //     int resultLoss = Integer.MAX_VALUE;
    //     for(int i=0;i<price.size()-1;i++){
    //         for(int j=i+1;j<price.size();j++){
    //             if ((price.get(i)-price.get(j))<0) {
    //                 continue;
    //             } else {
    //                 if ((price.get(i)-price.get(j))<resultLoss) {
    //                     resultLoss = Long.valueOf(price.get(i)-price.get(j)).intValue();
    //                 } else {
    //                     resultLoss = resultLoss;
    //                 }
    //             }
    //         }
    //     }
    //     return resultLoss;
    // }
    public static int minimumLoss(List<Long> price) {
        int n = price.size();
        
        // Create pairs of (price, original_index)
        List<AbstractMap.SimpleEntry<Long, Integer>> priceWithIndex = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            priceWithIndex.add(new AbstractMap.SimpleEntry<>(price.get(i), i));
        }
        
        // Sort by price in ascending order
        priceWithIndex.sort(Map.Entry.comparingByKey());
        
        long minLoss = Long.MAX_VALUE;
        
        // Check adjacent elements in sorted array
        for (int i = 0; i < n - 1; i++) {
            long currentPrice = priceWithIndex.get(i).getKey();
            int currentIndex = priceWithIndex.get(i).getValue();
            long nextPrice = priceWithIndex.get(i + 1).getKey();
            int nextIndex = priceWithIndex.get(i + 1).getValue();
            
            // We can only sell after we buy (currentIndex < nextIndex)
            // Loss = buyPrice - sellPrice (nextPrice - currentPrice)
            if (nextIndex < currentIndex) {
                long loss = nextPrice - currentPrice;
                minLoss = Math.min(minLoss, loss);
            }
        }
        
        return (int) minLoss;
    }

}
