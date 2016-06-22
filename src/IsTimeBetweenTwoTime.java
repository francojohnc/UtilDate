import java.util.Date;

import UtilDate.UtilDate;



public class IsTimeBetweenTwoTime {

	public static void main(String[] args) {

		Date currentTime = UtilDate.parseDate(UtilDate.TIME_24, "22:02:23");
		Date startTime = UtilDate.parseDate(UtilDate.TIME_24, "21:00:00");
		Date endTime = UtilDate.parseDate(UtilDate.TIME_24, "06:00:00");
		
		System.out.println("currentDate: "+UtilDate.getDate(UtilDate.TIME_12, currentTime));
		System.out.println("startTime: "+UtilDate.getDate(UtilDate.TIME_12, startTime));
		System.out.println("endTime: "+UtilDate.getDate(UtilDate.TIME_12, endTime));
		System.out.println("isTimeBetweenTwoTime: "+UtilDate.isTimeBetweenTwoTime(startTime, endTime, currentTime));

	}

}
