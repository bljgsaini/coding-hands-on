package designPattern.behavioral.visitorPattern.example2.end;

public class Client {
    public static void main(String[] args) {
        StaffList staffList = new StaffList();
        System.out.println("Total salaries of employees : " + staffList.getSalary());
        staffList.accept(new SalaryAdjustmentVisitor());
        System.out.println("Total salaries of employees after adjustment : " + staffList.getSalary());
    }
}
