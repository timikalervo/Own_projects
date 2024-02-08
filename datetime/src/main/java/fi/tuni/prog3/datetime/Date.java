package fi.tuni.prog3.datetime;

/**
 * @author timi autio
 */

public class Date {
    private int year;
    private int month;
    private int day;

    // Constructor for Date. Accepets three int values: year, month and day
    // Throws DateException if dates are not valid
    public Date(int year, int month, int day) throws DateException {
        
        // Check date
        if(!isValidDate(day, month, year)){
            throw new DateException(String.format("Illegal date %d.%d.%d", 
                    day, month, year));
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // Getters for year, month and day
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    // Return formatted string: day.month.year
    @Override
    public String toString() {
        return String.format("%02d.%02d.%d", day, month, year);
    }

    
    // !! DATE TESTS BELOW INSPIRED BY STUDY MATERIALS EXAMPLES !!
    
    // Checks if a year is a leap year
    public static boolean isLeapYear(int year) {
        // A leap year is divisible by 4, except for years divisible by 100 unless they are also divisible by 400
        return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
    }

    // Determines the number of days in a given month of a year
    public static int getDaysInMonth(int month, int year) {
        
        // Array to hold the number of days for each month
        // (index 0-11 for Jan-Dec)
        int[][] daysInMonth = {
                {31, 31}, // January
                {28, 29}, // February (normal year, leap year)
                {31, 31}, // March
                {30, 30}, // April
                {31, 31}, // May
                {30, 30}, // June
                {31, 31}, // July
                {31, 31}, // August
                {30, 30}, // September
                {31, 31}, // October
                {30, 30}, // November
                {31, 31}  // December
        };

        if (month >= 1 && month <= 12) {
            // If it's a leap year, return the second value for February, 
            // otherwise return the first
            return isLeapYear(year) ? daysInMonth[month - 1][1] : 
                   daysInMonth[month - 1][0];
            
        } else {
            // Return -1 for an invalid month
            return -1;
        }
    }

    // Checks if a given date (day, month, year) is valid
    public static boolean isValidDate(int day, int month, int year) {
        // Check if month is valid
        if (month < 1 || month > 12) {
            return false; // Invalid month
        }

        // Get the number of days in the given month and year
        int maxDaysInMonth = getDaysInMonth(month, year);

        // Check if day is within the valid range for the given month
        return (day >= 1 && day <= maxDaysInMonth);
    }
}