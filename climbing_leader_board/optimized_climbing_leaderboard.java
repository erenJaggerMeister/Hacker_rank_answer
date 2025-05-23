package climbing_leader_board;
import java.util.*;
public class optimized_climbing_leaderboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> ranked = new ArrayList<>();
        List<Integer> player = new ArrayList<>();

        int rankedCount = sc.nextInt();
        for(int i = 0; i < rankedCount; i++) {
            ranked.add(sc.nextInt());
        }

        int playerCount = sc.nextInt();
        for(int i = 0; i < playerCount; i++) {
            player.add(sc.nextInt());
        }

        List<Integer> output_result = climbingLeaderboard(ranked, player);
        for (int rank : output_result) {
            System.out.println(rank);
        }
    }
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Remove duplicates and sort descending
        TreeSet<Integer> rankedSet = new TreeSet<>(Collections.reverseOrder());
        rankedSet.addAll(ranked);
        List<Integer> uniqueRanked = new ArrayList<>(rankedSet);

        List<Integer> result = new ArrayList<>();

        int n = uniqueRanked.size();

        for (int score : player) {
            int left = 0, right = n - 1;
            int position = n; // Assume it's lower than all

            while (left <= right) {
                int mid = (left + right) / 2;
                if (score >= uniqueRanked.get(mid)) {
                    position = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            result.add(position + 1); // Rank is index + 1
        }

        return result;
    }
}
