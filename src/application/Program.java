package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== Test 01: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n=== Test 02: seller findByDepartmentId ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
//		for (Seller obj : list) {
//			System.out.println(obj);
//		}
		list.forEach(System.out::println);

		System.out.println("\n=== Test 03: seller findAll ====");
		list = sellerDao.findAll();
		list.forEach(System.out::println);

		System.out.println("\n=== Test 04: seller insert ====");
		Seller newSeller = new Seller(null, "Greg", "greg@email.com", new Date(), 4000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id: " + newSeller.getId());
		
		System.out.println("\n=== Test 05: seller update ====");
		seller = sellerDao.findById(1);
		seller.setName("Martha Silva");
		seller.setEmail("masil@email.com");
		sellerDao.update(seller);
		System.out.println("Update completed");
	}

}
