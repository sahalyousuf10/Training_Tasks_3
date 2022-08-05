import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class myjdbc {

    String insert(int id, String name, String department) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest", "root", "sahal123");
            String query = "insert into students(id,name,department) values(?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, department);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return "Student data inserted successfully!";
    }

    String delete(int id) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest", "root", "sahal123");
            String query = "delete from students where id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return "Student data deleted successfully!";
    }

    String update(int id, String name, String department) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest", "root", "sahal123");
            String query = "update students set name = ?, department = ? where id = ?";
            PreparedStatement psst3 = connection.prepareStatement(query);
            psst3.setString(1, name);
            psst3.setString(2, department);
            psst3.setInt(3, id);
            psst3.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return "Student data updated successfully!";
    }

    void display() {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest", "root", "sahal123");
            Statement statement = connection.createStatement();
            String query = "select * from students";
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("----Student Data----\n");
            while (resultSet.next()) {
                System.out.print("Id: " + resultSet.getString("id"));
                System.out.print(" | Name: " + resultSet.getString("name"));
                System.out.println(" | Department: " + resultSet.getString("department"));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    void specificid(int id) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest", "root", "sahal123");
            Statement statement = connection.createStatement();
            String query = "select * from students where id = " + id;
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("----Student Data----\n");
            while (resultSet.next()) {
                System.out.print("Id: " + resultSet.getString("id"));
                System.out.print(" | Name: " + resultSet.getString("name"));
                System.out.println(" | Department: " + resultSet.getString("department"));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }


    public static void main(String[] args) {

        myjdbc jdbc = new myjdbc();

        System.out.println("----Student Management System----\n");
        System.out.println("Press 1 to insert into Students table");
        System.out.println("Press 2 to delete from Students table");
        System.out.println("Press 3 to update into Students table");
        System.out.println("Press 4 to show data from Students table");
        System.out.println("Press 5 to get data of specific student");
        System.out.println("Press 6 to exit");

        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter your choice: ");
        int choice = Integer.parseInt(sc.nextLine());

        if (choice == 1) {

            System.out.println("Enter data to insert into students table\n");
            System.out.println("Enter student id insert into students table");
            int id = Integer.parseInt(sc.nextLine());
            System.out.println("\nEnter student name insert into students table");
            String name1 = sc.nextLine();
            System.out.println("\nEnter student department insert into students table");
            String department = sc.nextLine();
            String result = jdbc.insert(id, name1, department);
            System.out.println("\n" + result);

        } else if (choice == 2) {

            System.out.println("Enter the student id to delete data of student from table");
            int id = Integer.parseInt(sc.nextLine());
            String result = jdbc.delete(id);
            System.out.println("\n" + result);

        } else if (choice == 3) {

            System.out.println("Enter the student id to update student data");
            int id = Integer.parseInt(sc.nextLine());
            System.out.println("\nEnter the student name to update");
            String name = sc.nextLine();
            System.out.println("\nEnter the student department to update");
            String department = sc.nextLine();
            String result = jdbc.update(id, name, department);
            System.out.println("\n" + result);

        } else if (choice == 4) {

            System.out.println("\nStudent Data: ");
            jdbc.display();

        } else if (choice == 5) {

            System.out.println("Enter the student id to get data of specific student");
            int id = Integer.parseInt(sc.nextLine());
            jdbc.specificid(id);

        } else if (choice == 6) {

            System.exit(0);
        }
    }
}
