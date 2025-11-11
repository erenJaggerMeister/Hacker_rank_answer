import java.util.*;

public class TimeInWords {
    static HashMap<Integer, String> dictionaryTimeHour;
    static HashMap<Integer,String> dictionaryTimeMinute;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int h = sc.nextInt();
        int m = sc.nextInt();
        String result = resTimeInWords(h, m);
        System.out.println(result);
    }

    private static String resTimeInWords(int h, int m){
        dictionaryTimeHour = new HashMap<>();
        dictionaryTimeMinute = new HashMap<>();
        initHashDictionary();
        String readResultTime = "";
        if(m <= 30){
            if(m == 0){
                readResultTime += dictionaryTimeHour.get(h) + " " + dictionaryTimeMinute.get(m);
            } else {
                readResultTime += dictionaryTimeMinute.get(m) + " " + dictionaryTimeHour.get(h);
            }
        } else {
            if(m == 0){
                readResultTime += dictionaryTimeHour.get(h) + " " + dictionaryTimeMinute.get(m);
            } else {
                readResultTime += dictionaryTimeMinute.get(m) + " " + dictionaryTimeHour.get(h+1);
            }
        }
        return readResultTime;
    }

    private static void initHashDictionary(){
        //hour
        dictionaryTimeHour.put(1, "one");
        dictionaryTimeHour.put(2, "two");
        dictionaryTimeHour.put(3, "three");
        dictionaryTimeHour.put(4, "four");
        dictionaryTimeHour.put(5, "five");
        dictionaryTimeHour.put(6, "six");
        dictionaryTimeHour.put(7, "seven");
        dictionaryTimeHour.put(8, "eight");
        dictionaryTimeHour.put(9, "nine");
        dictionaryTimeHour.put(10, "ten");
        dictionaryTimeHour.put(11, "eleven");
        dictionaryTimeHour.put(12, "twelve");
        //minutes
        dictionaryTimeMinute.put(0, "o' clock");
        dictionaryTimeMinute.put(15, "quarter past");
        dictionaryTimeMinute.put(30, "half past");
        dictionaryTimeMinute.put(45, "quarter to");
        dictionaryTimeMinute.put(1, "one minute past");
        dictionaryTimeMinute.put(2, "two minutes past");
        dictionaryTimeMinute.put(3, "three minutes past");
        dictionaryTimeMinute.put(4, "four minutes past");
        dictionaryTimeMinute.put(5, "five minutes past");
        dictionaryTimeMinute.put(6, "six minutes past");
        dictionaryTimeMinute.put(7, "seven minutes past");
        dictionaryTimeMinute.put(8, "eight minutes past");
        dictionaryTimeMinute.put(9, "nine minutes past");
        dictionaryTimeMinute.put(10, "ten minutes past");
        dictionaryTimeMinute.put(11, "eleven minutes past");
        dictionaryTimeMinute.put(12, "twelve minutes past");
        dictionaryTimeMinute.put(13, "thirteen minutes past");
        dictionaryTimeMinute.put(14, "fourteen minutes past");
        dictionaryTimeMinute.put(16, "sixteen minutes past");
        dictionaryTimeMinute.put(17, "seventeen minutes past");
        dictionaryTimeMinute.put(18, "eighteen minutes past");
        dictionaryTimeMinute.put(19, "nineteen minutes past");
        dictionaryTimeMinute.put(20, "twenty minutes past");
        dictionaryTimeMinute.put(21, "twenty one minutes past");
        dictionaryTimeMinute.put(22, "twenty two minutes past");
        dictionaryTimeMinute.put(23, "twenty three minutes past");
        dictionaryTimeMinute.put(24, "twenty four minutes past");
        dictionaryTimeMinute.put(25, "twenty five minutes past");
        dictionaryTimeMinute.put(26, "twenty six minutes past");
        dictionaryTimeMinute.put(27, "twenty seven minutes past");
        dictionaryTimeMinute.put(28, "twenty eight minutes past");
        dictionaryTimeMinute.put(29, "twenty nine minutes past");
        dictionaryTimeMinute.put(31, "twenty nine minutes to");
        dictionaryTimeMinute.put(32, "twenty eight minutes to");
        dictionaryTimeMinute.put(33, "twenty seven minutes to");
        dictionaryTimeMinute.put(34, "twenty six minutes to");
        dictionaryTimeMinute.put(35, "twenty five minutes to");
        dictionaryTimeMinute.put(36, "twenty four minutes to");
        dictionaryTimeMinute.put(37, "twenty three minutes to");
        dictionaryTimeMinute.put(38, "twenty two minutes to");
        dictionaryTimeMinute.put(39, "twenty one minutes to");
        dictionaryTimeMinute.put(40, "twenty minutes to");
        dictionaryTimeMinute.put(41, "nineteen minutes to");
        dictionaryTimeMinute.put(42, "eighteen minutes to");
        dictionaryTimeMinute.put(43, "seventeen minutes to");
        dictionaryTimeMinute.put(44, "sixteen minutes to");
        dictionaryTimeMinute.put(46, "fourteen minutes to");
        dictionaryTimeMinute.put(47, "thirteen minutes to");
        dictionaryTimeMinute.put(48, "twelve minutes to");
        dictionaryTimeMinute.put(49, "eleven minutes to");
        dictionaryTimeMinute.put(50, "ten minutes to");
        dictionaryTimeMinute.put(51, "nine minutes to");
        dictionaryTimeMinute.put(52, "eight minutes to");
        dictionaryTimeMinute.put(53, "seven minutes to");
        dictionaryTimeMinute.put(54, "six minutes to");
        dictionaryTimeMinute.put(55, "five minutes to");
        dictionaryTimeMinute.put(56, "four minutes to");
        dictionaryTimeMinute.put(57, "three minutes to");
        dictionaryTimeMinute.put(58, "two minutes to");
        dictionaryTimeMinute.put(59, "one minute to");
    }
}
