package designPattern.behavioral.visitorPattern.example2.begin;

import java.util.ArrayList;
import java.util.List;

public class StaffList implements Employee {

    private List<Employee> employeeList;

    public StaffList(){
        employeeList = new ArrayList<>();
        Manager manager = new Manager();
        SalesPerson salesPerson1 = new SalesPerson();
        SalesPerson salesPerson2 = new SalesPerson();
        employeeList.add(manager);
        employeeList.add(salesPerson1);
        employeeList.add(salesPerson2);
    }

    @Override
    public double getSalary() {
        return employeeList.stream().mapToDouble(Employee::getSalary).sum();
    }
}
