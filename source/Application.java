package source;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.List;


public class Application {
    public static void main(String[] args){


        EmployeeDao employeeDao = new EmployeeDaoImpl();
//        employeeDao.getAllEmployee().forEach(System.out::println);
//
//        System.out.println();
//        System.out.println(employeeDao.getById(3));

        Employee employee = new Employee(7, "Kuzya", "Kurchavin", "male", 23, 1);

        employee.setId(null);
        employeeDao.createEmployee(employee);
//        employeeDao.getAllEmployee().forEach(System.out::println);

    }
}
