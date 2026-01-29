import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TestLocalDate {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        LocalDateTime currentTime = LocalDateTime.now(ZoneId.of("Asia/Jakarta"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
        String result = currentTime.format(formatter);

        int currentPeriod = Integer.parseInt(java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyyMM")));
        String convertPeriod = String.valueOf(currentPeriod);

        YearMonth start = YearMonth.parse(result, formatter);
        YearMonth threeBeforeMonths = start.minusMonths(3);

        String threeConvertBeforeMonths = threeBeforeMonths.format(formatter);

        System.out.println("Manual method="+result);
        System.out.println("Auto from integer: "+currentPeriod);
        System.out.println("Convert from String Period: "+convertPeriod);
        System.out.println("3 String months before: "+threeConvertBeforeMonths);
    }
}
