package designPattern.behavioral.iteratorPattern.employeeIterator;

import java.util.Iterator;
import java.util.List;

public class EmployeeInventory {

    private List<Employee> employeeList;


    public EmployeeInventory(List<Employee> employeeList){
        this.employeeList = employeeList;
    }

    public List<Employee> getEmployeeList(){
        return employeeList;
    }

    public Iterator getIterator(){
        return new EmployeeIterator(this);
    }

}
