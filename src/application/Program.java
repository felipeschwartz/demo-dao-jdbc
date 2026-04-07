package application;

import java.time.LocalDate;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Department obj = new Department(1, "Books");
        Seller seller = new Seller(21, "Bob", "bob@gmail.com", LocalDate.now(), 3000.0, obj);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println(seller.toString());

        sc.close();
    }
}