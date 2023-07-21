package com.example.hbonetoonebidemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.hbonetoonebidemo.dao.InstructorDAO;
import com.example.hbonetoonebidemo.entity.Instructor;
import com.example.hbonetoonebidemo.entity.InstructorDetail;

@SpringBootApplication
public class HbOneToOneBiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HbOneToOneBiDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(InstructorDAO instructorDAO) {
		return runner -> {
			System.out.println("Welcome to hibernate");
			
			//saveInstructor(instructorDAO);
			
			//findInstructorById(instructorDAO);
			
			//deleteInstructor(instructorDAO);
			
			findInstructorDetailById(instructorDAO);
			
			deleteInstructorDetailById(instructorDAO);
		};
	}

	private void saveInstructor(InstructorDAO instructorDAO) {
		Instructor instructor1 = new Instructor ("vamshi", "marripudi", "vamshi.marripudi@fmr.com");
		InstructorDetail instructorDetail1 = new InstructorDetail("I love coding", "guitar");
		
		Instructor instructor2 = new Instructor ("abbu", "paturi", "abbu.paturi@fmr.com");
		InstructorDetail instructorDetail2 = new InstructorDetail("I love coding", "bike");
		
		Instructor instructor3 = new Instructor ("padmavathi", "velaga", "padmavathi.velaga@fmr.com");
		InstructorDetail instructorDetail3 = new InstructorDetail("I love coding", "chit chat");
		
		instructor1.setInstructorDetail(instructorDetail1);
		instructor2.setInstructorDetail(instructorDetail2);
		instructor3.setInstructorDetail(instructorDetail3);
		
		instructorDAO.save(instructor1);
		instructorDAO.save(instructor2);
		instructorDAO.save(instructor3);
		System.out.println("instructor & instructorDetail 1, 2, 3 saved successfully");
	}
	
	private void findInstructorById(InstructorDAO instructorDAO) {
		int id = 1;
		Instructor instructor1 = instructorDAO.findInstructorById(id);
		
		System.out.println("found instructor : " +instructor1);
		System.out.println("instructor detail found : " +instructor1.getInstructorDetail());
	}
	
	private void deleteInstructor(InstructorDAO instructorDAO) {
		int id = 1;
		instructorDAO.deleteInstructorById(id);
		System.out.println("instructor deleted successfully");
	}
	
	private void findInstructorDetailById(InstructorDAO instructorDAO) {
		int id =2;
		InstructorDetail instructorDetail = instructorDAO.findInstructorDetailById(id);
		
		System.out.println("Instructor detail found : " +instructorDetail);
	}
	
	private void deleteInstructorDetailById(InstructorDAO instructorDAO) {
		int id = 3;
		instructorDAO.deleteInstructorDetailById(id);
		System.out.println("deleted InstructorDetail By Id done");
		
	}

}
