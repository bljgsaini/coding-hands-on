package designPattern.behavioral.visitorPattern.example2.end;

public interface Employee {
    double getSalary();
    void accept(SalaryAdjustmentVisitor salaryAdjustmentVisitor);
}
