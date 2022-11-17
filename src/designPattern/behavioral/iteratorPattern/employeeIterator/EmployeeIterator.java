package designPattern.behavioral.iteratorPattern.employeeIterator;

import java.util.Iterator;
import java.util.List;

public class EmployeeIterator implements Iterator {

    private EmployeeInventory employeeInventory;

    private int index;

    public EmployeeIterator(EmployeeInventory employeeInventory){
        this.employeeInventory = employeeInventory;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        List<Employee> employeeList = employeeInventory.getEmployeeList();
        if(index < employeeList.size()) return true;
        return false;
    }

    @Override
    public Object next() {
        List<Employee> employeeList = employeeInventory.getEmployeeList();
        Employee employee = employeeList.get(index++);
        return employee;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
}
