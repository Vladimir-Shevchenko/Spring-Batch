package com.H2Students;

import java.sql.*;

public class Main {

    private static final String url = "jdbc:h2:D:\\EPAM\\DB\\root";
    private static final String user = "cat";
    private static final String password = "meow";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void main(String[] args)  {

        try {
            Class.forName("org.h2.Driver");

            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();

            rs = stmt.executeQuery("SELECT  * FROM STUDENTS;");

            while (rs.next()){
                System.out.println(rs.getInt("ID")+"  "+
                        rs.getString("FIRSTNAME")+"  "+
                        rs.getString("SECONDNAME")+"  "+
                        rs.getInt("AGE")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            con.close();
            stmt.close();
            rs.close();
        }catch(SQLException ex){}
    }

}
