package examples.datatime;

import java.time.*;
import static java.time.Month.*;
import static java.time.temporal.ChronoUnit.*;

public class LocalDateTimeDemo {

    public static void main(String[] args){
        LocalDateTime meeting, flight, courseStart, courseEnd;

        meeting = LocalDateTime.of(2018, 3, 21, 17,15);
        System.out.println("Meeting is on: "+meeting);

        LocalDate flightDate = LocalDate.of(2018,3,31);
        LocalTime flightTime = LocalTime.of(19,20);

        flight = LocalDateTime.of(flightDate,flightTime);
        System.out.println("My flight is on: "+flight);

        courseStart = LocalDateTime.of(2018, JULY, 16, 9,00);
        courseEnd = courseStart.plusDays(4).plusHours(8);

        System.out.println("My course starts on: "+courseStart+" and finishes on: "+courseEnd);
    }

}
