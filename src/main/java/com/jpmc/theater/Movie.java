package com.jpmc.theater;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Movie {
    private static int MOVIE_CODE_SPECIAL = 1;

    private String title;
    private String description;
    private Duration runningTime;
    private double ticketPrice;
    private int specialCode;

    public Movie(String title, Duration runningTime, double ticketPrice, int specialCode) {
        this.title = title;
        this.runningTime = runningTime;
        this.ticketPrice = ticketPrice;
        this.specialCode = specialCode;
    }

    public String getTitle() {
        return title;
    }

    public Duration getRunningTime() {
        return runningTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public double calculateTicketPrice(Showing showing) {
        return ticketPrice - getDiscount(showing.getSequenceOfTheDay(), showing.getStartTime());
    }

    private double getDiscount(int showSequence, LocalDateTime showStartTime) {
        double specialDiscount = 0;
        if (MOVIE_CODE_SPECIAL == specialCode) {
            specialDiscount = ticketPrice * 0.2;  // 20% discount for special movie
        }

        double sequenceDiscount = 0;
        if (showSequence == 1) {
            sequenceDiscount = 3; // $3 discount for 1st show
        } else if (showSequence == 2) {

            sequenceDiscount = 2; // $2 discount for 2nd show
        } else if (showSequence == 7) {

            sequenceDiscount = 1; // $1 discount for 7nd show
        }

        LocalDateTime discountStartDateTime =  LocalDateTime.of(LocalDateProvider.singleton().currentDate(), LocalTime.of(11, 0));
        LocalDateTime discountEndDateTime =  LocalDateTime.of(LocalDateProvider.singleton().currentDate(), LocalTime.of(16, 0));

        // showStartTime is between discountStartDateTime && discountEndDateTime
        double between11AmTo4PmDiscount = 0; 
        if( (showStartTime.isEqual(discountStartDateTime) || showStartTime.isAfter(discountStartDateTime))
            &&(showStartTime.isBefore(discountEndDateTime))) {
            between11AmTo4PmDiscount = ticketPrice * 0.25;  // 20% discount for special movie
        }

        // biggest discount wins
        List<Double> discounts = Arrays.asList(0.0,specialDiscount, sequenceDiscount, between11AmTo4PmDiscount);
        double biggestDiscount = discounts.stream().max(Comparator.naturalOrder()).get();
        return biggestDiscount;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.ticketPrice, ticketPrice) == 0
                && Objects.equals(title, movie.title)
                && Objects.equals(description, movie.description)
                && Objects.equals(runningTime, movie.runningTime)
                && Objects.equals(specialCode, movie.specialCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, runningTime, ticketPrice, specialCode);
    }
}