package com.overtimeanalysis.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.overtimeanalysis.dto.OvertimeByDays;
import com.overtimeanalysis.dto.OvertimeMetrics;
import com.overtimeanalysis.entity.OvertimeAnalysis;
import com.overtimeanalysis.repository.OvertimeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OvertimeService {
	
	private final OvertimeRepository repository;

	public Optional<OvertimeAnalysis> getById(Long id) {
	
		return repository.findById(id);
	}
	
	  public Float getTotalOvertimeHours() {
	        return repository.findTotalOvertimeHours();
	    }
	  public Long getTotalEmployeesWithOvertime() {
	        return repository.findTotalEmployeesWithOvertime();
	    }
	
	  
	  public float parseHoursMinutes(String hoursMinutes) {
	        if (hoursMinutes == null || hoursMinutes.isEmpty()) {
	            return 0;
	        }
	        String[] parts = hoursMinutes.split(":");
	        if (parts.length != 2) {
	            throw new IllegalArgumentException("Invalid hours:minutes format: " + hoursMinutes);
	        }
	        float hours = Float.parseFloat(parts[0]);
	        float minutes = Float.parseFloat(parts[1]) / 60;
	        return hours + minutes;
	    }
	  
	  
	  public OvertimeMetrics getOvertimeMetrics(String startDate, String endDate) {
	        List<OvertimeAnalysis> overtimes = repository.findByAttendanceDateBetween(startDate, endDate);
	        float totalOvertimeHours = 0;
	        float totalCostIncurred = 0;
	        float totalEstimatedHours = 0;
	        int totalEmployeesWithOvertime = overtimes.size();

	        for (OvertimeAnalysis overtime : overtimes) {
	            if (overtime.getOvertimeHours() != null) {
	                totalOvertimeHours += overtime.getOvertimeHours();
	            }
	            if (overtime.getOvertimeHours() != null) {
	                totalCostIncurred += (overtime.getOvertimeHours() * 15);
	            }
	            if (overtime.getEstimatedHours() != null && !overtime.getEstimatedHours().isEmpty()) {
	                totalEstimatedHours += parseHoursMinutes(overtime.getEstimatedHours());
	            }
	        }

	        float overtimePercentage = totalEstimatedHours == 0 ? 0 : (totalOvertimeHours / totalEstimatedHours) * 100;

	        return new OvertimeMetrics(totalOvertimeHours, totalEmployeesWithOvertime, totalCostIncurred, overtimePercentage);
	    }

	  
	  public OvertimeByDays getOvertimeByDays(String startDate, String endDate) {
	        List<OvertimeAnalysis> overtimes = repository.findByAttendanceDateBetween(startDate, endDate);
	        float totalOvertimeHours = 0;
	        float overtimeOnWorkingDays = 0;
	        float overtimeOnHolidays = 0;
	        float overtimeOnWeekOffs = 0;

	        for (OvertimeAnalysis overtime : overtimes) {
	            if (overtime.getOvertimeHours() != null) {
	                totalOvertimeHours += overtime.getOvertimeHours();
	                if ("Working Day".equals(overtime.getDay())) {
	                    overtimeOnWorkingDays += overtime.getOvertimeHours();
	                } else if ("Holiday".equals(overtime.getDay())) {
	                    overtimeOnHolidays += overtime.getOvertimeHours();
	                } else if ("Week Off".equals(overtime.getDay())) {
	                    overtimeOnWeekOffs += overtime.getOvertimeHours();
	                }
	            }
	        }

	        float workingDayPercentage = totalOvertimeHours == 0 ? 0 : (overtimeOnWorkingDays / totalOvertimeHours) * 100;
	        float holidayPercentage = totalOvertimeHours == 0 ? 0 : (overtimeOnHolidays / totalOvertimeHours) * 100;
	        float weekOffPercentage = totalOvertimeHours == 0 ? 0 : (overtimeOnWeekOffs / totalOvertimeHours) * 100;

	        return new OvertimeByDays(workingDayPercentage, holidayPercentage, weekOffPercentage, totalOvertimeHours);
	    }
	  

}
