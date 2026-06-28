package exceptions;

import java.sql.SQLException;

public class Client {

    public static void main(String[] args) {
        Student student = new Student();
        try {
            student.findById(19);
        }catch (Exception e){
            System.out.println("after 3 retries still not able to connect");
        }



    }
}
