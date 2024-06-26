package com.overtimeanalysis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OvertimeMetrics {

	private Float totalOvertimeHours;
	private int totalEmployeesWithOvertime;
	private float totalCostIncurred;
	private float overtimePercentage;
}