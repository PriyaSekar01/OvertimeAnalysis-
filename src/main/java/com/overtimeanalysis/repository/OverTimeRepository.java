package com.overtimeanalysis.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.overtimeanalysis.entity.OvertimeAnalysis;

@Repository
public interface OvertimeRepository extends JpaRepository<OvertimeAnalysis, Long> {

	@Query("SELECT SUM(oa.overtimeHours) FROM OvertimeAnalysis oa")
	Float findTotalOvertimeHours();

	@Query("SELECT COUNT(DISTINCT oa.userId) FROM OvertimeAnalysis oa WHERE oa.overtimeHours > 0")
	Long findTotalEmployeesWithOvertime();

	List<OvertimeAnalysis> findByAttendanceDateBetween(String startDate, String endDate);

	@Query("SELECT SUM(oa.overtimeHours) FROM OvertimeAnalysis oa WHERE oa.attendanceDate BETWEEN :startDate AND :endDate")
	Float getTotalOvertimeHours(@Param("startDate") String startDate, @Param("endDate") String endDate);

	List<OvertimeAnalysis> findByUserName(String userName);

	List<OvertimeAnalysis> findByUserNameAndDay(String userName, String day);

	// New queries for filtering overtime by day type
	List<OvertimeAnalysis> findByProjectCodeAndDay(String projectCode, String day);

}
