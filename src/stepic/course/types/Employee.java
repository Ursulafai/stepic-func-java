package stepic.course.types;

import java.util.Objects;

public class Employee {
    private String name;
    private Long salary;

    public String getName() {
        return name;
    }

    public Long getSalary() {
        return salary;
    }

    public Employee(String name, Long salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }
}