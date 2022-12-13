package designPattern.behavioral.visitorPattern.example2.end;

public class SalaryAdjustmentVisitor implements Visitor {
    @Override
    public void visit(SalesPerson salesPerson) {
        salesPerson.setSalary(45000);
    }

    @Override
    public void visit(Manager manager) {
        manager.setSalary(70000);
    }

    @Override
    public void visit(StaffList staffList) {
        System.out.println("Salary adjustment is done!!!");
    }
}
