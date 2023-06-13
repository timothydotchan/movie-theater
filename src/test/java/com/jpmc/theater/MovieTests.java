package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTests {
    @Test
    void movieWhereMaxDiscountIsSpecialDiscount20Percent() {
        double ticketPrice = 12.5;
        double expectedDiscount = ticketPrice*0.2;
        double expectedPrice = ticketPrice - expectedDiscount;
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),ticketPrice, 1);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0)));
        assertEquals(expectedPrice, spiderMan.calculateTicketPrice(showing));

        System.out.println(Duration.ofMinutes(90));
    }

    @Test
    void movieWhereMaxDiscountIsSequence1() {
        double ticketPrice = 4.0;
        double expectedDiscount = 3;
        double expectedPrice = ticketPrice - expectedDiscount;
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),ticketPrice, 1);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0)));
        assertEquals(expectedPrice, spiderMan.calculateTicketPrice(showing));

        System.out.println(Duration.ofMinutes(90));
    }

    @Test
    void movieWhereMaxDiscountIsSequence2() {
        double ticketPrice = 4.0;
        double expectedDiscount = 2;
        double expectedPrice = ticketPrice - expectedDiscount;
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),ticketPrice, 1);
        Showing showing = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0)));
        assertEquals(expectedPrice, spiderMan.calculateTicketPrice(showing));

        System.out.println(Duration.ofMinutes(90));
    }

    @Test
    void movieWhereMaxDiscountIsSequence7() {
        double ticketPrice = 4.0;
        double expectedDiscount = 1;
        double expectedPrice = ticketPrice - expectedDiscount;
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),ticketPrice, 0);
        Showing showing = new Showing(spiderMan, 7, LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0)));
        assertEquals(expectedPrice, spiderMan.calculateTicketPrice(showing));

        System.out.println(Duration.ofMinutes(90));
    }

    @Test
    void movieWhere7MaxDiscountIs11AnTo4PmSpecial() {
        double ticketPrice = 13.0;
        double expectedDiscount = ticketPrice*.25;
        double expectedPrice = ticketPrice -  expectedDiscount ;
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),ticketPrice, 1);
        Showing showing = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 0)));
        assertEquals(expectedPrice, spiderMan.calculateTicketPrice(showing));

        System.out.println(Duration.ofMinutes(90));
    }

    @Test
    void movieWithNoDiscount() {

        double ticketPrice = 13.0;
        double expectedDiscount = 0;
        double expectedPrice = ticketPrice -  expectedDiscount ;

        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),ticketPrice, 0);
        Showing showing = new Showing(spiderMan, 3, LocalDateTime.of(LocalDate.now(), LocalTime.of(17, 0)));
        assertEquals(expectedPrice, spiderMan.calculateTicketPrice(showing));

        System.out.println(Duration.ofMinutes(90));
    }

}
