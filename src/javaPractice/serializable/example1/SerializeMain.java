package javaPractice.serializable.example1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeMain {

    public static void main(String[] args) {

        Employee emp = new Employee();
        emp.setEmployeeId(101);
        emp.setEmployeeName("Arpit");
        emp.setDepartment("CS");
        try {
            FileOutputStream fileOut = new FileOutputStream("src/javaPractice/serializable/example1/employee.ser");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
            outputStream.writeObject(emp);
            outputStream.close();
            fileOut.close();
        }catch(IOException i) {
            i.printStackTrace();
        }
    }

}
