package util;

import java.util.Calendar;
import java.util.GregorianCalendar;

public final class Util {
	public static int getRandomGrade() {
		return (int) (Math.random()*4)+9;
	}
	
	public static int getRandomGraduationYear() {
		return new GregorianCalendar().get(Calendar.YEAR)+(int) (Math.random()*4);
	}
	
	public static int getRandomId() {
		int digits = 4, number = 0;
		if ((int) (Math.random()*5)==0) digits++;
		for (int i = 0;i<digits;i++) {
			number = number*10+(int) (Math.random()*10);
		}
		return number;
	}
}
