package demo_jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Databasejdbc_postgres {

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee_info", "postgres", "Dsi$@1434");
            con.setAutoCommit(false);
            System.out.println("Database Connection has Opened........! ");
            //stmt = con.createStatement();
            //*  String sql = "CREATE TABLE STUDENT_INFO "
            //+ "(ROLL_NO SERIAL NOT NULL PRIMARY KEY , "
            // + " NAME TEXT NOT NULL , "
            //+ " MOBILE_NO BIGINT NOT NULL , "
            // + "ADDRESS TEXT NOT NULL , "
            //+ " PERCENTAGE REAL NOT NULL) ";
            // stmt.executeUpdate(sql);
            //  stmt = con.createStatement();
            //String sql = " insert into STUDENT_INFO VALUES (4,'VISHAL KATHAR',9240404015,'GHANSAVNGI,JALNA',65.52 ) ";
            // stmt.executeUpdate(sql);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM STUDENT_INFO;");
            while (rs.next()) {
                int roll_no = rs.getInt("roll_no");
                String name = rs.getString("Name");
                String mobile_no = rs.getString("mobile_no");
                String address = rs.getString("address");
                double percentage = rs.getDouble("percentage");
                // DISPLAY THE RESULT  
                System.out.println(" ROLL_NO " + roll_no);
                System.out.println("-----------------------------");
                System.out.println(" NAME " + name);
                System.out.println("-----------------------------");
                System.out.println(" MOBILE_NO " + mobile_no);
                System.out.println("-----------------------------");
                System.out.println(" ADDRESS " + address);
                System.out.println("-----------------------------");
                System.out.println(" PERCENTAGE " + percentage);
                System.out.println("-----------------------------");
            }
            stmt.close();
            con.commit();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getClass().getName());
            System.exit(0);

        }
        System.out.println("Values insert into Table Sucessfully...............!");
    }

}
