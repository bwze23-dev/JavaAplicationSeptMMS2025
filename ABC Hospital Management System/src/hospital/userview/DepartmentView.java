package hospital.userview;

import hospital.models.Department;

import java.util.List;

public class DepartmentView {

    public void displayDepartments(List<Department> departments) {

        if (departments == null || departments.isEmpty()) {
            System.out.println();
            System.out.println("No departments found.");
            return;
        }

        System.out.println();
        System.out.println("========================================================");
        System.out.printf("%-6s %-25s %-20s%n", "ID", "NAME", "HEAD OF DEPARTMENT");
        System.out.println("========================================================");

        for (Department d : departments) {
            System.out.printf("%-6d %-25s %-20s%n",
                    d.getId(), d.getName(), d.getHeadOfDepartment() != null ? d.getHeadOfDepartment() : "");
        }

        System.out.println("========================================================");
    }

    public void displayDepartmentAdded() {
        System.out.println();
        System.out.println("Department added successfully.");
    }
}
