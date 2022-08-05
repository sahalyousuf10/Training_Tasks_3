import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Courses {

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest", "root", "sahal123");
            Statement statement = connection.createStatement();
            System.out.println("Enter the student id to get the courses of student\n");
            Scanner sc = new Scanner(System.in);
            int id = Integer.parseInt(sc.nextLine());
            String query = "select * from students JOIN courses ON students.id = courses.courseid where students.id = "+id;
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("----Student Data----\n");
            while (resultSet.next()) {
                System.out.print("Id: "+resultSet.getString("id"));
                System.out.print(" | Name: "+resultSet.getString("name"));
                System.out.print(" | Department: "+resultSet.getString("department"));
                System.out.print(" | Course 1: "+resultSet.getString("course1"));
                System.out.print(" | Course 2: "+resultSet.getString("course2"));
                System.out.println(" | Course 3: "+resultSet.getString("course3"));
            }
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
}
