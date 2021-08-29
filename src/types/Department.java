package types;

import java.util.List;

public class Department {
    private String name;
    private String code;
    private List<Employee> employees;

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
