package lambdaFunctions;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateAndTime {
	// 5)
	static int[] daysInEachMonth(int year) {
		int[] monthDays = new int[12];
		Calendar cal = new GregorianCalendar(year, 0, 0);
		for(int month = 0; month < 12; month++) {
			cal.set(Calendar.MONTH, month);
			monthDays[month] = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		}
		return monthDays;
	}
	// 6)
	static ArrayList<Integer> mondaysInMonth(LocalDate date) {
		ArrayList<Integer> mondayDates = new ArrayList<Integer>();
		LocalDate tempDate = date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
		Month month = tempDate.getMonth();
		while(tempDate.getMonth() == month) {
			mondayDates.add(tempDate.getDayOfMonth());
			tempDate.plusWeeks(1);
		}
		return mondayDates;
	}
	// 7)
	static Boolean isFriday13th(LocalDate date) {
		return date.getDayOfMonth() == 13 && date.getDayOfWeek() == DayOfWeek.FRIDAY;
		
	}
	public static void main(String[] args) {
		// Answers to questions:
		// 1)  to store a date in years, months, days seconds and nanoseconds:
		// I would also need to provide an hour and minute time.
		LocalDateTime birthday = LocalDateTime.of(1980, Month.JANUARY, 1, 9, 38, 12, 123456789);
		
		// 2) To find the date of the previous Thursday:
		LocalDate thursday = LocalDate.now();
		while(thursday.getDayOfWeek() != DayOfWeek.THURSDAY) {
			thursday = thursday.minusDays(1);
		}
		int month = thursday.getMonthValue();
		int day = thursday.getDayOfMonth();
		
		/* 3) difference between ZoneId and ZoneOffset:
		* A ZoneId is a representation of a time-zone
		* ZoneOffset extends ZoneId and represents a difference in time-zone 
		* between a ZoneId and a LocalDate
		*/
		
		// 4) Convert Instant to ZonedDateTime:
		Instant instant = Instant.now();
		ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
		
		// Convert ZonedDateTime to Instant:
		zdt.toInstant();
	}

}
