package examples.datatime;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeDemo {

    public static void main(String[] args){

        ZoneId SFO = ZoneId.of("America/Los_Angeles");
        ZoneId BOS = ZoneId.of("America/New_York");
        ZoneId BLR = ZoneId.of("Asia/Calcutta");

        LocalDateTime departure = LocalDateTime.of(2018, Month.JUNE, 13, 22, 30);
        ZonedDateTime departSFO = ZonedDateTime.of(departure, SFO);
        System.out.println("Flight 123 departs SFO at: " + departSFO);

        ZonedDateTime departTimeAtBOS = departSFO.toOffsetDateTime().atZoneSameInstant(BOS);
        System.out.println("Local time BOS at departure: " + departTimeAtBOS);
        System.out.println("Flight time: 5 hours 30 minutes");

        ZonedDateTime arriveBOS = departSFO.plusHours(5).plusMinutes(30).toOffsetDateTime().atZoneSameInstant(BOS);
        System.out.println("Flight 123 arrives BOS: " + arriveBOS);

        ZonedDateTime arriveTimeAtSFO = arriveBOS.toOffsetDateTime().atZoneSameInstant(SFO);
        System.out.println("Local time SFO at arrival: " + arriveTimeAtSFO);
    }
}
