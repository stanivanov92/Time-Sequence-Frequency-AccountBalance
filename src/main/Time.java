import org.jetbrains.annotations.NotNull;

public class Time {

    /** Keeps track of the hours */
    private int hours;

    /** Keeps track of the minutes */
    private int minutes;

    /** Keeps track of the seconds */
    private int seconds;


    /**
     * Ctor
     * <p>Throws IllegalArgument exception
     *    if any of the parameters is negative</p>
     * @param hours sets the hours attribute
     * @param minutes sets the minutes attribute
     * @param seconds sets the seconds attribute
     */
    public Time(int hours, int minutes, int seconds){
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }


    /**
     * Get the time of the instance in hours minutes and seconds
     *
     * @return the hours minutes and seconds of the time instance
     */
    public String timeString(){
        StringBuilder strTime = new StringBuilder();
        strTime.append(timeValueToString(hours) + ":");
        strTime.append(timeValueToString(minutes) + ":");
        strTime.append(timeValueToString(seconds));
        return strTime.toString();
    }

    /**
     * Add seconds to the time of the instance the
     * <p>Throws IllegalArgument exception
     *    if the parameter is negative</p>
     *
     * @param seconds adds the specified seconds to the time
     */
    public void scale(int seconds){
        if(seconds > -1)
            setSeconds(seconds + this.seconds);
        else
            throw new IllegalArgumentException("Seconds can not be a negativen number");
    }


    /**
     * Normalises the time in case
     * seconds, minutes or hours have
     * gone over the designated limit
     */
    private void normaliseTime(){
        minutes += seconds / 60;
        hours += minutes / 60;
        seconds = seconds % 60;
        minutes = minutes % 60;
        hours = hours % 24;
    }


    /**
     * Converts an integer into a string
     * the string is always of length 2
     * where a leading 0 is added if required
     *
     * @param value the time value for seconds minutes or hours
     * @return the time of variable as 2 character string
     */
    private String timeValueToString(int value){
        return value > 9 ? String.valueOf(value) : "0" + String.valueOf(value);
    }


    /**
     * Sets the time hours is set to the provided parameter
     *  <p>Throws IllegalArgument exception
     *     if any of the parameters is negative</p>
     * The value stored is the module of 24
     *
     * @param hours sets the time hours value
     */
    private void setHours(int hours){
        if(hours < 0)
            throw new IllegalArgumentException("Hours can not be a negative number");
        this.hours = hours;
        if(hours > 23);
            normaliseTime();
    }

    /**
     * Sets the time minutes is set to the provided parameter
     *  <p>Throws IllegalArgument exception
     *     if any of the parameters is negative</p>
     * The value stored is the module of 60
     *
     * @param minutes
     */
    private void setMinutes(int minutes) {
        if(minutes < 0)
            throw new IllegalArgumentException("Minutes can not be a negative number");
        this.minutes = minutes;
        if(minutes > 59)
            normaliseTime();
    }

    /**
     * Sets the time seconds is set to the provided parameter
     *  <p>Throws IllegalArgument exception
     *     if any of the parameters is negative</p>
     * The value stored is the module of 60
     *
     * @param seconds
     */
    private void setSeconds(int seconds) {
        if (seconds < 0)
            throw new IllegalArgumentException("Seconds can not be a negative number");
        this.seconds = seconds;
        if(seconds > 59)
            normaliseTime();
    }
}
