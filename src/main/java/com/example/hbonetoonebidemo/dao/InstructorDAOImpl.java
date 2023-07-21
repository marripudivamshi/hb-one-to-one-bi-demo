package com.example.hbonetoonebidemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.hbonetoonebidemo.entity.Instructor;
import com.example.hbonetoonebidemo.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class InstructorDAOImpl implements InstructorDAO {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public void save(Instructor instructor) {
		entityManager.persist(instructor);
	}

	@Override
	public Instructor findInstructorById(int id) {
		Instructor instructor = entityManager.find(Instructor.class, id);
		return instructor;
	}

	@Override
	@Transactional
	public void deleteInstructorById(int id) {
		Instructor instructor = entityManager.find(Instructor.class, id);
		entityManager.remove(instructor);
	}

	@Override
	public InstructorDetail findInstructorDetailById(int id) {
		InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
		return instructorDetail;
	}

	@Override
	@Transactional
	public void deleteInstructorDetailById(int id) {
		InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
		instructorDetail.setInstructor(null);
		entityManager.remove(instructorDetail);
	}
	
	
}
