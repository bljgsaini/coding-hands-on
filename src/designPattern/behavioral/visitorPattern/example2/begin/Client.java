package designPattern.behavioral.visitorPattern.example2.begin;

public class Client {
    public static void main(String[] args) {
        StaffList staffList = new StaffList();
        System.out.println("Total salaries of employees : " + staffList.getSalary());
    }
}
