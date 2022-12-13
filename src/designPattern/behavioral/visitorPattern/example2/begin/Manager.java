package designPattern.behavioral.visitorPattern.example2.begin;

public class Manager implements Employee {

    private long salary = 80000;

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }
}
