package fr.nantes.junit.examples.tests;


import fr.nantes.junit.examples.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created on 28/11/2017.
 *
 * @author AtlanMod team.
 */
class DateTest {

    private Date date;

    @DisplayName("Valid leap years")
    @ParameterizedTest(name = "year: {0}")
    @ValueSource(ints = { 1904, 1940, 1996, 2000, 2004})
    void testLeapYear(int year) {
        assertThat(Date.isLeapYear(year)).isTrue();
    }

    @DisplayName("Unusual valid leap years")
    @ParameterizedTest(name = "year: {0}")
    @ValueSource(ints = { 1600,2000})
    void testUnusualLeapYear(int year) {
        assertThat(Date.isLeapYear(year)).isTrue();
    }

    @DisplayName("Unusual invalid leap years")
    @ParameterizedTest(name = "year: {0}")
    @ValueSource(ints = {1700,1800,1900})
    void testUnusualNotLeapYear(int year) {
        assertThat(Date.isLeapYear(year)).isFalse();
    }

    @DisplayName("Invalid leap years")
    @ParameterizedTest
    @MethodSource("fiveTimesWorldChampion")
    void testNotLeapYear(int year) {
        assertThat(Date.isLeapYear(year)).isFalse();
    }

    @DisplayName("Constructor: valid dates")
    @ParameterizedTest
    @MethodSource("validDates")
    void testConstructorValidDates(int d, int m, int y) {
        Date date = new Date(d,m,y);
        assertThat(date.year()).isEqualTo(y);
        assertThat(date.month()).isEqualTo(m);
        assertThat(date.day()).isEqualTo(d);
    }

    @DisplayName("Constructor: invalid dates")
    @ParameterizedTest
    @CsvSource({"10,10,1000","33,2,1999","1,13,1999","0,2,1999","10,0,1999"})
    void testConstructotInvalidDates(int d, int m, int y) {
        assertThrows(IllegalArgumentException.class, () -> new Date(d,m,y));
    }

    @Test
    void testTwoThousandIsALeapYear() {
        assertThat(Date.isLeapYear(2000)).isTrue();
    }


    static IntStream fiveTimesWorldChampion() {
        return IntStream.of(1958,1962,1970,1994,2002);
    }

    static Stream<Arguments> validDates() {
        return Stream.of(
                Arguments.of(10, 10, 2000),
                Arguments.of(23, 2, 1999)
        );
    }
}