package com.overtimeanalysis.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.overtimeanalysis.dto.OvertimeByDays;
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
	public ResponseEntity<Float> getTotalOvertimeHours() {
		try {
			Float totalOvertimeHours = service.getTotalOvertimeHours();
			return new ResponseEntity<>(totalOvertimeHours, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/total-employees-overtime")
	public ResponseEntity<Long> getTotalEmployeesWithOvertime() {
		try {
			Long totalEmployees = service.getTotalEmployeesWithOvertime();
			return new ResponseEntity<>(totalEmployees, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/metrics")
	public ResponseEntity<OvertimeMetrics> getOvertimeMetrics(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate) {
		try {
			OvertimeMetrics metrics = service.getOvertimeMetrics(startDate, endDate);
			return new ResponseEntity<>(metrics, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/overtimeByDays")
	public ResponseEntity<OvertimeByDays> getOvertimeByDays(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate) {
		try {
			OvertimeByDays overtimeByDays = service.getOvertimeByDays(startDate, endDate);
			return new ResponseEntity<>(overtimeByDays, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
