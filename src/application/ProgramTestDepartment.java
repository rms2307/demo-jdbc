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
		Department department = departmentDao.findById(2);
		System.out.println(department);

		System.out.println("\n=== Test 02: department findAll ===");
		List<Department> list = new ArrayList<>();
		list = departmentDao.findAll();
		list.forEach(System.out::println);

		sc.close();
	}

}
