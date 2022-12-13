package designPattern.behavioral.visitorPattern.example2.begin;

public class SalesPerson implements Employee {

    private long salary = 50000;

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }
}
