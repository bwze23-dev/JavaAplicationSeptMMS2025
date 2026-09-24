package hospital.services;

import hospital.dao.DepartmentDAO;
import hospital.models.Department;

import java.util.List;

public class DepartmentService {

    private final DepartmentDAO departmentDAO;

    public DepartmentService() {
        departmentDAO = new DepartmentDAO();
    }

    public boolean addDepartment(Department department) {

        if (department == null) {
            System.out.println("Department cannot be null.");
            return false;
        }

        if (department.getName() == null || department.getName().trim().isEmpty()) {
            System.out.println("Department name is required.");
            return false;
        }

        departmentDAO.addDepartment(department);
        return true;
    }

    public List<Department> getAllDepartments() {
        return departmentDAO.findAllDepartments();
    }

    public Department getDepartmentById(int departmentId) {

        if (departmentId <= 0) {
            System.out.println("Invalid department ID.");
            return null;
        }

        return departmentDAO.findDepartmentById(departmentId);
    }
}
