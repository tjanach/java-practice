package examples.datatime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import static java.time.temporal.TemporalAdjusters.*;



public class LocalDateDemo {

    public static void main(String[] args){
        LocalDate now, bDate, nowPlusMonth, nextTues;

        now = LocalDate.now();
        System.out.println("Now date: "+now);
        System.out.println("Now date: "+now.getDayOfWeek());

        bDate = LocalDate.of(1955,5,25);
        System.out.println("Java bDate: "+bDate);
        System.out.println("Java bDate is before now: "+bDate.isBefore(now));
        System.out.println("Java bDate a leap year: "+bDate.isLeapYear());
        System.out.println("Java bDate is a day of week: "+bDate.getDayOfWeek());

        nowPlusMonth = now.plusMonths(1);
        System.out.println("Java nowPlusMonth: "+nowPlusMonth);

        nextTues = now.with(next(DayOfWeek.TUESDAY));

        System.out.println("Next tuesday from now is : "+nextTues);
    }

}
