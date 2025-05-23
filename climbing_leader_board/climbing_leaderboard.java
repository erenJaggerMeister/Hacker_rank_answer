package climbing_leader_board;
import java.util.*;

public class climbing_leaderboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> ranked = new ArrayList<>();
        List<Integer> player = new ArrayList<>();

        int rankedCount = sc.nextInt();
        for(int i=0;i<rankedCount;i++){
            int score_input = sc.nextInt();
            ranked.add(score_input);
        }

        int playerCount = sc.nextInt();
        for(int i=0;i<playerCount;i++){
            int score_input = sc.nextInt();
            player.add(score_input);
        }
        List<Integer> output_result = climbingLeaderboard(ranked, player);
        System.out.println(output_result);
    }
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    // Write your code here
        List<Integer> output_result = new ArrayList<>();
        number_have_ranked[] object = new number_have_ranked[ranked.size()];
        int dense_ranked = 1;
        for(int i=0;i<ranked.size();i++){
            object[i] = new number_have_ranked(ranked.get(i));
            if (i==0) {
                object[i].set_ranked(dense_ranked);
            } else {
                if(ranked.get(i) < ranked.get(i-1)){
                    dense_ranked++;
                    object[i].set_ranked(dense_ranked);
                } else {
                    object[i].set_ranked(dense_ranked);
                }
            }
        }
        for(int i=0;i<player.size();i++){
            int posisi_rank = ranking_check(object, player.get(i));
            output_result.add(posisi_rank);
        }
        return output_result;
    }
    public static int ranking_check(number_have_ranked[] object, int number_check){
        int position = -1;
        for(int i=0;i<object.length;i++){
            if(number_check >= object[i].get_number()){
                position = object[i].get_rank();
                break;
            }
        }
        if (position==-1) {
            position = object[object.length-1].get_rank()+1;
        }
        return position;
    }
}
class number_have_ranked{
    private int number_input;
    private int ranked_dense;
    public number_have_ranked(int number){
        this.number_input = number;
    }

    public void set_ranked(int ranked){
        this.ranked_dense = ranked;
    }
    public int get_number(){
        return number_input;
    }
    public int get_rank(){
        return ranked_dense;
    }
}
