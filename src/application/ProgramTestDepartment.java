package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgramTestDepartment {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== Test 01: department findById ===");
		Department department = departmentDao.findById(1);
		System.out.println(department);

		System.out.println("\n=== Test 02: department findAll ===");
		List<Department> list = new ArrayList<>();
		list = departmentDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n=== Test 03: department insert ===");
		Department newDep = new Department(null, "Food");
		departmentDao.insert(newDep);
		System.out.println("Insertd. New Id department: " + newDep.getId());
		
		System.out.println("\n=== Test 04: department update ===");
		department = departmentDao.findById(2);
		department.setName("Services");
		departmentDao.update(department);
		System.out.println("Done!");
		
		System.out.println("\n=== Test 05: department delete ===");
		System.out.print("Enter id for delete: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Done!");

		sc.close();
	}

}
