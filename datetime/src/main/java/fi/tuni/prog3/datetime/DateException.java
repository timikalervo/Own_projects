package fi.tuni.prog3.datetime;

/**
 * @author timi autio
 */

// Inherits the Java library class Exception
public class DateException extends Exception{
    // Constructor that passes the parameter 'msg' to the constructor of the
    // superclass 'Exception'.
    public DateException(String msg){
        super(msg);
    }
}
