package source;

import java.sql.*;
import java.util.List;


public class Application {
    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String pass = "root";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement statement = connection.prepareStatement("" +
                     "SELECT  * FROM employee WHERE id = (?)")) {
            statement.setInt(1, 2);
            final ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = "Name: " + resultSet.getString("first_name");
                String surname = "Surname: " + resultSet.getString("last_name");
                String gender = "Gender: " + resultSet.getString(4);
                String city = "City id: " + resultSet.getInt(6);

                System.out.println(name);
                System.out.println(surname);
                System.out.println(gender);
                System.out.println(city);
            }

            EmployeeDao employeeDao = new EmployeeDaoImpl();
            List <Employee> employees  = employeeDao.getAllEmployee();

            for (Employee employee : employees) {
                System.out.println("Id: " + employee.getId());
                System.out.println("Name: " + employee.getFirst_name());
                System.out.println("Surname: " + employee.getLast_name());
                System.out.println("Gender: " + employee.getGender());
                System.out.println("City id: " + employee.getCity_id());
                System.out.println("Age: " + employee.getAge());
                System.out.println("----------------------------------");
            }
            Employee john = new Employee(7,"john", "Washington", "male", 44,1);
//            employeeDao.createEmployee(john);
//            employeeDao.deleteEmployee(7);
//            employeeDao.updateEmployee(4, john);

            System.out.println(employeeDao.getById(3).getFirst_name());
        }
    }
}
