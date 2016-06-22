package UtilDate;


/**
 * Created by jcf.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
public class UtilDate {
	/*sample format*/
	public static final String TIME_24 = "HH:mm:ss";
	public static final String TIME_12 = "hh:mm:ss a";
	
	public static Calendar dateToCalendar(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
	public static String getDate(String format, long timestamp) {
		SimpleDateFormat dateFormat = new SimpleDateFormat( format, Locale.US );
        return dateFormat.format( new Date(timestamp) );
	}
	public static String getDate(String format, Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat( format, Locale.US );
		return dateFormat.format( date );
	}
	public static String getDate(String format,Calendar cal) {
		SimpleDateFormat dateFormat = new SimpleDateFormat( format, Locale.US );
		return dateFormat.format(cal.getTime());
	}
	public static Calendar getDate(String format,String date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(parseDate(format,date));
		return cal;
	}
	public static int getDayOfWeek(int year, int month, int dayOfMonth){
		Calendar calendar = new GregorianCalendar(year,month,dayOfMonth);
		return calendar.get(Calendar.WEEK_OF_MONTH);
	}
	/* function to parse string to date format */
	public static Date parseDate(String format,String date) {
		try {
			return new SimpleDateFormat(format,Locale.US).parse(date);
		}
		catch(ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	/* function to convert date to calendar*/
	public static Calendar getDatePart(Date date){
	    Calendar cal = Calendar.getInstance();       // get calendar instance
	    cal.setTime(date);      
	    cal.set(Calendar.HOUR_OF_DAY, 0);            // set hour to midnight
	    cal.set(Calendar.MINUTE, 0);                 // set minute in hour
	    cal.set(Calendar.SECOND, 0);                 // set second in minute
	    cal.set(Calendar.MILLISECOND, 0);            // set millisecond in second
	    return cal;                                  // return the date part
	}
	/* function to compute date difference for updating */
	public static int daysBetween(Date startDate, Date endDate) {
		  Calendar sDate = getDatePart(startDate);
		  Calendar eDate = getDatePart(endDate);
		  int daysBetween = 0;
		  while ( sDate.before(eDate) ) {
		      sDate.add( Calendar.DAY_OF_MONTH, 1 );
		      daysBetween++;
		  }
		  return daysBetween;
	}
	/* @param day - Calendar.MONDAY */
	public static int getFirstDayOfTheWeek(int year, int month,int week,int day) {
		Calendar cacheCalendar = Calendar.getInstance();
	    cacheCalendar.set(Calendar.DAY_OF_WEEK,day);
	    cacheCalendar.set(Calendar.DAY_OF_WEEK_IN_MONTH,week);
	    cacheCalendar.set(Calendar.MONTH, month);
	    cacheCalendar.set(Calendar.YEAR,year);
	    return cacheCalendar.get(Calendar.DATE);
	}
	public static int getLastDateOfTheMonth(int month, int year) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.set(Calendar.MONTH, month);
	    calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
	    return calendar.get(Calendar.DATE);
	}
	//
	public static boolean isTimeBetweenTwoTime(Date startTime, Date stopTime, Date currentTime) {
	    //Start Time
	    Calendar StartTime = Calendar.getInstance();
	    StartTime.setTime(startTime);
	    //Current Time
	    Calendar CurrentTime = Calendar.getInstance();
	    CurrentTime.setTime(currentTime);
	    //Stop Time
	    Calendar StopTime = Calendar.getInstance();
	    StopTime.setTime(stopTime);
	    if (stopTime.compareTo(startTime) < 0) {
	        if (CurrentTime.compareTo(StopTime) < 0) {
	            CurrentTime.add(Calendar.DATE, 1);
	        }
	        StopTime.add(Calendar.DATE, 1);
	    }
	    return CurrentTime.compareTo(StartTime) >= 0 && CurrentTime.compareTo(StopTime) < 0;
	}
}