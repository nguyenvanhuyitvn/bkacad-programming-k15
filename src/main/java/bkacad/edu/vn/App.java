package bkacad.edu.vn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/k15_programming_error";
        String USERNAME = "root";
        String PASSWORD = "";
        System.out.println("** Program search list of students whose name contain value input **");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Student Name:");
        String strName = sc.nextLine();
        System.out.println("Enter Student Code:");
        String studentCode = sc.nextLine();
        while (strName.length() == 0 || strName.equals("")) {
            System.out.println("Please enter student name");
            System.out.println("Enter value:");
            strName = sc.nextLine();
        }
        try {
            String str = "SELECT * FROM student WHERE full_name LIKE '%" + strName + "%'";

            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(str);

            System.out.println("** List of students **");
            while (rs.next()) {
                String fullname = rs.getString("full_name");
                String studentcode = rs.getString("student_code");
                String address = rs.getString("address");
                Date birthday = rs.getDate("birthday");

                System.out.println("Full name: " + fullname);
                System.out.println("Student code: " + studentcode);
                System.out.println("Address: " + address);
                System.out.println("Birthday: " + birthday);

                System.out.println("");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
