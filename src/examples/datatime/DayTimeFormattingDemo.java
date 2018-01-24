package examples.datatime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DayTimeFormattingDemo {

    public static void main(String[] args) {
        Period p = Period.ofDays(15).plusDays(3);
        System.out.println("Period p: " + p);

        String dateFormat = "MMMM d, yyyy";
        LocalDate aDate = LocalDate.of(2010, 02, 9);
        System.out.println();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dateFormat);

        System.out.println(dateFormatter.format(aDate));

        boolean validString = false;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (!validString){
            System.out.print("Enter a date: ");
            try {
                String enteredDate = br.readLine();
                aDate = LocalDate.parse(enteredDate, dateFormatter);
                validString = true;
            } catch (IOException | DateTimeParseException ex){
                System.out.println(ex);
                validString = false;
            }
        }

        System.out.println("Date entered was: " + aDate);
        LocalDate now = LocalDate.now();

        Period between;
        if (aDate.isBefore(now)){
            between = Period.between(aDate, now);
        } else {
            between = Period.between(now, aDate);
        }

        int years = between.getYears();
        int months = between.getMonths();
        int days = between.getDays();

        System.out.println("There are "+ years +" years, "+months+" months, "+days+" days between now and the date entered.");
    }

}
