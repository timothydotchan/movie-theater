package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TheaterTests {
    @Test
    void totalFeeForCustomer() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        Customer john = new Customer("John Doe", "id-12345");
        Reservation reservation = theater.reserve(john, 2, 4);
//        System.out.println("You have to pay " + reservation.getTotalFee());
        assertEquals(reservation.totalFee(), 50);
    }

    @Test
    void printSimpleTextShouldNotBeNull() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        String printString = theater.printSchedule(PrintType.TEXT);
        assertNotNull(printString);
    }

    @Test
    void printJsonShouldNotBeNull() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        String printString = theater.printSchedule(PrintType.JSON);
        assertNotNull(printString);
    }
}
