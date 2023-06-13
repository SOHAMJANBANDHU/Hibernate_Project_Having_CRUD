package student.dto.controller;

import java.util.Scanner;

import student.dto.Student;
import student.dto.dao.StudentCRUD;

public class MainController {

	public static void main(String[] args) {
		
		Student stu = new Student();
		StudentCRUD crud = new StudentCRUD();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice \n 1. insert \n 2.fetch \n 3.update \n 4.delete \n 5.display all data");
		int choice = sc.nextInt();
		
		switch (choice)
		{
		case 1:
		{
			System.out.println("Enter the id");
			int id = sc.nextInt();
			System.out.println("Enter the name");
			String name = sc.next();
			System.out.println("Enter the marks");
			int marks = sc.nextInt();
			System.out.println("Enter the address");
			String address = sc.next();
			System.out.println("Enter the Phone");
			long phone = sc.nextLong();
			System.out.println("Enter the Percentage");
			double percentage = sc.nextDouble();
			
			stu.setId(id);
			stu.setName(name);
			stu.setMarks(marks);
			stu.setAddress(address);
			stu.setPhone(phone);
			stu.setPercentage(percentage);
			
			crud.saveStudent(stu);
			System.out.println("Data inserted Sucessully");
			break;
		}
		case 2:
		{
			System.out.println("Enter the id");
			int id = sc.nextInt();
			
			stu.setId(id);
			crud.fetchStudent(stu, id);
			break;
		}
		case 3:
		{
			
			System.out.println("Enter the id");
			int id = sc.nextInt();
			
			stu.setId(id);
			crud.fetchStudent(stu, id);
			
			if(crud.fetchStudent(stu, id) == true)
			{
				System.out.println("Enter the name");
				String name = sc.next();
				System.out.println("Enter the marks");
				int marks = sc.nextInt();
				System.out.println("Enter the address");
				String address = sc.next();
				System.out.println("Enter the Phone");
				long phone = sc.nextLong();
				System.out.println("Enter the Percentage");
				double percentage = sc.nextDouble();
				
				stu.setId(id);
				stu.setName(name);
				stu.setMarks(marks);
				stu.setAddress(address);
				stu.setPhone(phone);
				stu.setPercentage(percentage);
				
				crud.updateStudent(stu, id);
			}
			else
			{
				System.out.println("Invalid id...");
			}
			break;
		}
		case 4:
		{
			System.out.println("Enter the id");
			int id = sc.nextInt();
			
			stu.setId(id);
			crud.fetchStudent(stu, id);
			
			if(crud.fetchStudent(stu, id) == true)
			{
				
				crud.deleteStudent(stu, id);
				System.out.println("data deleted SUCCESSFULLY...");
			}
			else
			{
				System.out.println("Invalid id...");
			}
			break;
		}
		case 5:
		{
			System.out.println("these are the details...");
			crud.allDataStudent();
			break;
		}
		
			
		}
		
		
	}
}
