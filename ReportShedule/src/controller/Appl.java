package controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import tempAdj.WorkingDays;

public class Appl {

	public static void main(String[] args) {
		String pb1 = "Tarik";
		String pb2 = "Michael";
		String pb3 = "Daniel";
		String pb4 = "Kfir";
		String wpo1 = "Tal";
		String wpo2 = "Shirel";
		String wpo3 = "Viki";

		String[] shedule = new String[7];
		
		shedule[0]= pb1;
		shedule[1]= pb2;
		shedule[2]= pb3;
		shedule[3]= pb4;
		shedule[4]= wpo1;
		shedule[5]= wpo2;
		shedule[6]= wpo3;
		
		LocalDate sheduleStart = LocalDate.of(2019,3,24);
		LocalDate sheduleFinish = LocalDate.now();
		long period = ChronoUnit.DAYS.between(sheduleStart, sheduleFinish);
		DayOfWeek[] restDays = { DayOfWeek.FRIDAY, DayOfWeek.SATURDAY };
		
		
		LocalDate finishWithoutWeekends = sheduleStart.with(new WorkingDays((int) period,restDays));
		long periodWithoutWeekends = ChronoUnit.DAYS.between(sheduleStart, finishWithoutWeekends);
		int temp = (int) (periodWithoutWeekends%shedule.length);
		System.out.println(shedule[temp]);
		
	}
	
}
