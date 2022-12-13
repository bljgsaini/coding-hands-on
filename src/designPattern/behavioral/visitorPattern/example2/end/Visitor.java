package designPattern.behavioral.visitorPattern.example2.end;

public interface Visitor {
    void visit(SalesPerson salesPerson);
    void visit(Manager manager);
    void visit(StaffList staffList);
}
