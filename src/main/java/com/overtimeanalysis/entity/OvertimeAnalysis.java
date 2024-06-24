package com.overtimeanalysis.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "overtime_analysis", schema = "public")
public class OvertimeAnalysis {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "Job Code")
	    private String jobCode;

	    @Column(name = "Job Name")
	    private String jobName;

	    @Column(name = "Phase Code")
	    private String phaseCode;

	    @Column(name = "Phase Name")
	    private String phaseName;

	    @Column(name = "Project Code")
	    private String projectCode;

	    @Column(name = "Project Name")
	    private String projectName;

	    @Column(name = "Estimated-Hours")
	    private String estimatedHours;

	    @Column(name = "Status")
	    private String status;

	    @Column(name = "User ID")
	    private Integer userId;

	    @Column(name = "User Name")
	    private String userName;

	    @Column(name = "attendance-date")
	    private String attendanceDate;

	    @Column(name = "Job Hours")
	    private String jobHours;

	    @Column(name = "Job Count")
	    private Float jobCount;

	    @Column(name = "ot1")
	    private String ot1;

	    @Column(name = "ot2")
	    private String ot2;

	    @Column(name = "Clocked Hours")
	    private Float clockedHours;

	    @Column(name = "Overtime_Hours")
	    private Float overtimeHours;

	    @Column(name = "department-name")
	    private String departmentName;

	    @Column(name = "designation")
	    private String designation;

	    @Column(name = "designation-name")
	    private String designationName;

	    @Column(name = "organization-name")
	    private String organizationName;

	    @Column(name = "grade-name")
	    private String gradeName;

	    @Column(name = "section-name")
	    private String sectionName;

	    @Column(name = "category-name")
	    private String categoryName;

	    @Column(name = "branch-name")
	    private String branchName;

	    @Column(name = "Cost Per Hour")
	    private Float costPerHour;

	    @Column(name = "Cost Incurred")
	    private Float costIncurred;

	    @Column(name = "ProjectID")
	    private String projectId;

	    @Column(name = "max-end-date")
	    private LocalDate maxEndDate;

	    @Column(name = "Project Status")
	    private String projectStatus;

	    @Column(name = "HasProjectStarted")
	    private String hasProjectStarted;

	    @Column(name = "Active Project")
	    private Float activeProject;

	    @Column(name = "Created Datetime")
	    private LocalDateTime createdDatetime;

	    @Column(name = "Start Date Time")
	    private LocalDateTime startDateTime;

	    @Column(name = "End Date Time")
	    private LocalDateTime endDateTime;

	    @Column(name = "ProcessDate")
	    private String processDate;

	    @Column(name = "FHSHS")
	    private String fhshs;

	    @Column(name = "Day")
	    private String day;

	    @Column(name = "Overtime-Percent")
	    private String overtimePercent;

    // Getters and setters
    // ...

    // Constructors
    // ...
	    }
	