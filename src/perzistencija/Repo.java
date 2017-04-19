package perzistencija;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class Repo {
    public static DefaultTableModel dtm = new DefaultTableModel();
    private static Connection conn;
    
    public static Connection getConnection() throws SQLException {
        if(conn==null){
            conn = DriverManager.getConnection("jdbc:mysql://localhost/","root","kolikosad22");
            DBengine();
        }
        return conn;
    }
   
    public static void DBengine() throws SQLException{
    try {
    PreparedStatement stCreateDB = conn.prepareStatement("create database employeeDB;");
    stCreateDB.execute();
    } catch(SQLException ex) {System.out.println("error in creating DB");}
    PreparedStatement use = conn.prepareStatement("use employeeDB");
    use.execute();
    try {
    PreparedStatement stCTable = conn.prepareStatement("create table employee (id int primary key auto_increment, name varchar(256), address varchar(256), age int, wage int);");
    stCTable.execute();
    } catch(SQLException ex) {System.out.println("error in creating table");}
    }
}
