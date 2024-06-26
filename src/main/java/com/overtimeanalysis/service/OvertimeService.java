package com.overtimeanalysis.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

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
	

	public OvertimeMetrics getOvertimeMetrics(String startDate, String endDate) {
        List<OvertimeAnalysis> overtimes = repository.findByAttendanceDateBetween(startDate, endDate);
        float totalOvertimeHours = 0;
        int totalEmployeesWithOvertime = overtimes.size();
        float totalCostIncurred = 0;
        for (OvertimeAnalysis overtime : overtimes) {
            if (overtime.getOvertimeHours() != null) {
                totalOvertimeHours += overtime.getOvertimeHours();
            }
            if (overtime.getCostIncurred() != null) {
                totalCostIncurred += overtime.getCostIncurred();
            }
        }

        float overtimePercentage = totalEmployeesWithOvertime == 0 ? 0 :
                (totalOvertimeHours / (totalOvertimeHours + totalEmployeesWithOvertime)) * 100;
        return new OvertimeMetrics(totalOvertimeHours, totalEmployeesWithOvertime, totalCostIncurred, overtimePercentage);
    }	

//	    public Map<String, Double> calculateOvertimePercentage(String userName) {
//	        List<OvertimeAnalysis> totalOvertime = repository.findByUserName(userName);
//	        double totalOvertimeHours = totalOvertime.stream()
//	                                                 .mapToDouble(oa -> oa.getOvertimeHours() != null ? oa.getOvertimeHours() : 0.0)
//	                                                 .sum();
//
//	        if (totalOvertimeHours == 0) {
//	            return Map.of("WorkingDay", 0.0, "Holiday", 0.0, "WeekOff", 0.0);
//	        }
//
//	        List<OvertimeAnalysis> workingDayOvertime = repository.findByUserNameAndDay(userName, "Working Day");
//	        List<OvertimeAnalysis> holidayOvertime = repository.findByUserNameAndDay(userName, "Holiday");
//	        List<OvertimeAnalysis> weekOffOvertime = repository.findByUserNameAndDay(userName, "Week Off");
//
//	        double workingDayHours = workingDayOvertime.stream()
//	                                                   .mapToDouble(oa -> oa.getOvertimeHours() != null ? oa.getOvertimeHours() : 0.0)
//	                                                   .sum();
//	        double holidayHours = holidayOvertime.stream()
//	                                             .mapToDouble(oa -> oa.getOvertimeHours() != null ? oa.getOvertimeHours() : 0.0)
//	                                             .sum();
//	        double weekOffHours = weekOffOvertime.stream()
//	                                             .mapToDouble(oa -> oa.getOvertimeHours() != null ? oa.getOvertimeHours() : 0.0)
//	                                             .sum();
//
//	        double workingDayPercent = (workingDayHours / totalOvertimeHours) * 100;
//	        double holidayPercent = (holidayHours / totalOvertimeHours) * 100;
//	        double weekOffPercent = (weekOffHours / totalOvertimeHours) * 100;
//
//	        return Map.of("WorkingDay", workingDayPercent, "Holiday", holidayPercent, "WeekOff", weekOffPercent);
//	    }

}
