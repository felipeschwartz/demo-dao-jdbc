package application;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("==== TEST 1: seller findById ====");

        System.out.print("Enter Seller's Id: ");
        Seller seller = sellerDao.findById(sc.nextInt());

        System.out.println(seller.toString());

        System.out.println("\n==== TEST 2: seller findByDepartment ====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj.toString());
        }

        System.out.println("\n==== TEST 3: seller findAll ====");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj.toString());
        }

        System.out.println("\n==== TEST 4: seller insert ====");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", LocalDate.now(), 4000.00, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());



        sc.close();
    }
}