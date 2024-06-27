package com.overtimeanalysis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OvertimeByDays {
	
	 private float workingDayPercentage;
	    private float holidayPercentage;
	    private float weekOffPercentage;
	    private float totalOvertimeHours;

}
