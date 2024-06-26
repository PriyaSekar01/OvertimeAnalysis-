package com.overtimeanalysis.controller;

import java.text.ParseException;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.overtimeanalysis.dto.OvertimeMetrics;
import com.overtimeanalysis.entity.OvertimeAnalysis;
import com.overtimeanalysis.service.OvertimeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OvertimeController {

	private final OvertimeService service;

	@GetMapping("/getById/{id}")
	public Optional<OvertimeAnalysis> getId(@PathVariable Long id) {
		return service.getById(id);
	}

	@GetMapping("/total-overtime-hours")
	public Float getTotalOvertimeHours() {
		return service.getTotalOvertimeHours();
	}

	@GetMapping("/total-employees-with-overtime")
	public Long getTotalEmployeesWithOvertime() {
		return service.getTotalEmployeesWithOvertime();
	}

	@GetMapping("/metrics")
	public OvertimeMetrics getOvertimeMetrics(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate) {
		return service.getOvertimeMetrics(startDate, endDate);
	}

}
