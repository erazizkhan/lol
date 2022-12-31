package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entity.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao bean = context.getBean("studentDao", StudentDao.class);
//Student st2=new Student(103,"faisal","mumbai");
//   Student st1=new Student();
//   st1.setId(102);
//   st1.setName("ajaz");
//   st1.setCity("mumbai");
// int r = bean.insert(st2);
//        Student r1 = bean.getStudent(102);
//      List<Student> list = bean.getAll();
//      bean.deleteStudent(103);
//        List<Student> list = bean.getAll();
//   System.out.println("number of row inserted "+r1);
//   System.out.println(list);

		Scanner br = new Scanner(System.in);
		Scanner br1 = new Scanner(System.in);
		Student st1 = new Student();
		boolean go = true;

		while (go) {
			System.out.println("Press 1 for insert new Student");
			System.out.println("Press 2 for display all Student");
			System.out.println("Press 3 for get single Student");
			System.out.println("Press 4 for delete students");
			System.out.println("Press 5 for update Student");
			System.out.println("Press 6 for Exit");
			try {
				int intput = Integer.parseInt(br.nextLine());
//int id = Integer.parseInt(br.nextLine());
				switch (intput) {
				case 1:
					System.out.println("pleae enter id");
					st1.setId(br.nextInt());
					System.out.println("please enter name");
					st1.setName(br1.nextLine());
					System.out.println("please enter city");
					st1.setCity(br1.nextLine());
					int r = bean.insert(st1);
					System.out.println(r+" is inserted successfully");
					break;
				case 2:
					List<Student> list = bean.getAll();
					System.out.println("Studens details are " + list);
					break;
				case 3:
					System.out.println("plese Enter id");
					Student r1 = bean.getStudent(br.nextInt());
					System.out.println("Student details are " + r1);
					break;
				case 4:
					System.out.println("please enter id");
					bean.deleteStudent(br.nextInt());
					System.out.println("one row deleted");
					break;
				case 5:
					System.out.println("pleae enter id");
					st1.setId(br.nextInt());
					System.out.println("please enter name");
					st1.setName(br1.nextLine());
					System.out.println("please enter city");
					st1.setCity(br1.nextLine());	
                     bean.update(st1);
                  System.out.println("one row updated....");
					break;
				case 6:
					go = false;
					break;

				default:
					break;
				}

			} catch (Exception e) {
				System.out.println("invalid input try with another one !!");
				System.out.println(e.getMessage());
			}

		}

		System.out.println("Thankyou using this application");
		System.out.println("see you soon !!");
	}
}
