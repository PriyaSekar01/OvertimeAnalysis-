package com.overtimeanalysis.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overtimeanalysis.entity.OvertimeAnalysis;
import com.overtimeanalysis.repository.OverTimeRepository;



@Service

public class OvertimeService {
	
	@Autowired
	private  OverTimeRepository overTimeRepository;

	public Optional<OvertimeAnalysis> getId(Long id) {
//		// TODO Auto-generated method stub
//		Optional<OvertimeAnalysis> obj= overTimeRepository.findById(id);
		return overTimeRepository.findById(id) ;
	}
//
//	 public OvertimeAnalysis getByName(String username) {
//	        return overTimeRepository.getByName(username);
//	    }
}
