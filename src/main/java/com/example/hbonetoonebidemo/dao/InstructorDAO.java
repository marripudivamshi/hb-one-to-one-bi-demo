package com.example.hbonetoonebidemo.dao;

import com.example.hbonetoonebidemo.entity.Instructor;
import com.example.hbonetoonebidemo.entity.InstructorDetail;

public interface InstructorDAO {
	void save(Instructor instructor);
	
	Instructor findInstructorById(int id);
	
	void deleteInstructorById(int id);

	InstructorDetail findInstructorDetailById(int id);

	void deleteInstructorDetailById(int id);
	
	
}
