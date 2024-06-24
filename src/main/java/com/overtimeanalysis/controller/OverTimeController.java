package com.overtimeanalysis.controller;


import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.overtimeanalysis.entity.OvertimeAnalysis;
import com.overtimeanalysis.service.OvertimeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/overtime")
public class OverTimeController {
	
	private final OvertimeService overtimeService;
	
	@GetMapping("/getbyId/{id}")
	public Optional<OvertimeAnalysis> getById(@PathVariable Long id) {
		return overtimeService.getId(id);
	}
	
//	@GetMapping("/findByUser/{username}")
//	public OvertimeAnalysis findBYUser(@PathVariable String username) {
//	    return overtimeService.getByName(username);
//	}


}
