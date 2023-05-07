package source;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getAllEmployee();
    Employee getById(int id);
    void createEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
}
