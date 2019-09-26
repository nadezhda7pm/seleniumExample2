package util;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Util {
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String convertLocalDateToString(LocalDate localDate){
        return new StringBuffer()
                .append(localDate.getDayOfWeek().name())
                .append(", ")
                .append(localDate.getMonth().name())
                .append(" ")
                .append(localDate.getDayOfMonth())
                .append(", ")
                .append(localDate.getYear())
                .toString();
    }

    public static void waitUntilLoad(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
