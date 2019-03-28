package tempAdj;

import java.time.DayOfWeek;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class WorkingDays implements TemporalAdjuster {

	int qDays;
	DayOfWeek[] restDays;
	
	
	public WorkingDays(int qDays, DayOfWeek[] restDays) {
		this.restDays = restDays;
		this.qDays = qDays;
		
	}


	@Override
	public Temporal adjustInto(Temporal temp) {
		int count = 0;
			while (count<qDays) {
		temp = temp.plus(1, ChronoUnit.DAYS);
		for (int i = 0; i < restDays.length; i++) {
		if (DayOfWeek.from(temp)==restDays[i])break;
		if (DayOfWeek.from(temp)!= restDays[i]&&i == restDays.length-1) count++;
		}
	}
		return temp;
	}

}
