package designPattern.behavioral.iteratorPattern.employeeIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee sam = new Employee("Sam");
        Employee dean = new Employee("Dean");
        Employee bobby = new Employee("Bobby");

        List<Employee> employeeList = new ArrayList();
        employeeList.add(sam);
        employeeList.add(dean);
        employeeList.add(bobby);

        EmployeeInventory employeeInventory = new EmployeeInventory(employeeList);

        Iterator iterator = employeeInventory.getIterator();

        while(iterator.hasNext()){
            Employee employee = (Employee) iterator.next();
            System.out.println(employee.getName());
        }

    }
}
