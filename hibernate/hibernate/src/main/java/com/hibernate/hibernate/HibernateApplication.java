package com.hibernate.hibernate;

import com.hibernate.hibernate.dao.StudentDao;
import com.hibernate.hibernate.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class })
public class HibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao ){
		return runner -> {
//				createStudent(studentDao);
//			readStudent(studentDao);
//			findAllStudent(studentDao);
//			findByLastNameQury(studentDao);
//			updateObj(studentDao);
//			deleteObj(studentDao);
			deleteAllObj(studentDao);

		};
	}

	private void deleteAllObj(StudentDao studentDao) {
		int rosDel = studentDao.deleteAll();
		System.out.println("number of row delete " + rosDel);
	}

	private void deleteObj(StudentDao studentDao) {

		int id  = 3;

		System.out.println(" obj to delete db " + id);
		studentDao.delete(id);

	}

	private void updateObj(StudentDao studentDao) {

		System.out.println("going to find obj in db ");

		Student myStudent = studentDao.findById(1);
		System.out.println(" find obj in db " + myStudent.toString());

		myStudent.setFirst_name("RasVihari");
		myStudent.setLast_name("RasViharni");

		System.out.println(" find obj in db " + myStudent.toString());

		studentDao.update(myStudent);

	}

	private void findByLastNameQury(StudentDao studentDao) {

		List<Student> al =  studentDao.findByLastName("raman");
		for(Student obj : al){
			System.out.println(" obj from database " + obj);
		}
	}

	private void findAllStudent(StudentDao studentDao) {

		List<Student> al =  studentDao.findAll();

		for(Student obj : al){
			System.out.println(" obj from database " + obj);
		}
	}

	private void readStudent(StudentDao studentDao) {

		System.out.println("going to create obj in db ");
		Student tmpStudent = new Student("radha", "raman", "radhaRaman@god.com");

		System.out.println("obj to create " + tmpStudent.toString());

		studentDao.save(tmpStudent);

		System.out.println("id of created obj " + tmpStudent.getId());

		Student myStudent = studentDao.findById(tmpStudent.getId());

		System.out.println("obj read fom db " + myStudent.toString());

	}

	private void createStudent(StudentDao studentDao) {

		System.out.println("going to create obj in db ");
	//	Student tmpStudent = new Student("radhe", "shyam", "radheShyam@god.com");
		Student tmpStudent2 = new Student("kanha", "radhika", "kanhaRadhika@god.com");
		Student tmpStudent3 = new Student("krishn", "shyama", "shyamaKrishn@god.com");
		Student tmpStudent4 = new Student("keshav", "krishn", "keshavKrishn@god.com");

		System.out.println("obj to create " + tmpStudent2.toString());

		studentDao.save(tmpStudent2);
		studentDao.save(tmpStudent3);
		studentDao.save(tmpStudent4);

		System.out.println("id of created obj " + tmpStudent2.getId());
	}

}
