package fi.tuni.prog3.datetime;

/**
 * @author timi autio
 */

// Class inherits the class Date. In addition stores information about time.
// hour, minute, second.
public class DateTime extends Date{
    private int hour;
    private int minute;
    private int second;
    
    // Constructor for DateTime
    // Accepts six int values: year, month, day, hour, minute, second.
    // Throws DateException if date/time not valid.
    public DateTime(int year, int month, int day,
                    int hour, int minute, int second) throws DateException{
        super(year, month, day);
        if( hour>=60 || minute>=60 || second>=60 ){
            throw new DateException(String.format("Illegal time %d:%d:%d", hour, minute, second));
        }
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    // Getters for hour, minute and second.
    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public String toString() {
        String date = super.toString();
        return String.format("%s %02d:%02d:%02d" , date, hour, minute, second);
    }
    
    // Own tests in main class
    public static void main(String[] args) {

        // Valid test dates
        try{
            
        // First test
        Date date = new Date(2024,12,22);
        System.out.println(date.toString());
        
        // Second test
        Date date2 = new Date(2024,1,1);
        System.out.println(date2.toString());
        
        // Third test
        DateTime datetime = new DateTime(2024,2,20,19,51,16);
        System.out.println(datetime.toString());
        
        // Fourth test
        DateTime datetime2 = new DateTime(2024,02,20,9,8,7);
        System.out.println(datetime2.toString());
        
        // Error check
        // Program should catch next line (datetime_error)
        DateTime datetime_error = new DateTime(2024,02,2,12,60,7);
        System.out.println(datetime_error.toString());
        
        // !! Program should not end up here !!
        Date date_error2 = new Date(2024,15,1);
        System.out.println(date_error2);
        
        }
        catch(DateException e){
            System.out.println(e);
            
        }
    }
}