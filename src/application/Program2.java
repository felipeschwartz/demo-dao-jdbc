package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("\n==== TEST 1: Department findById ====");
        Department department = departmentDao.findById(1);
        System.out.println(department.toString());

        System.out.println("\n==== TEST 2: Depertment findAll ====");
        List<Department> list = departmentDao.findAll();
        for (Department d : list) {
            System.out.println(d.toString());
        }

        System.out.println("\n==== TEST 3: Department insert ====");
        Department newDepartment = new Department(null, "School");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id = " + newDepartment.getId());

        System.out.println("\n==== TEST 4: Department update ====");
        department = departmentDao.findById(6);
        department.setName("Games");
        departmentDao.update(department);
        System.out.println("Update Completed!");

        System.out.println("\n==== TEST 5: Department delete ====");
        System.out.print("Enter Department's Id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Deleted Completed");

        sc.close();
    }
}