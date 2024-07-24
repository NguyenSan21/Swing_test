/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentManagerSwing.ClassFolder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class ConnectDB {
     //Các tham số kết nối
    private String hostName = "localhost:1433";
    private String dbName = "ManagermentStudent";
    private String username = "sa";
    private String password = "1234";
    //Chuỗi kết nối
    private String conURL = "jdbc:sqlserver://" + hostName + ";databaseName=" + dbName;

    public Connection Connect() throws ClassNotFoundException {

        //Tạo đối tượng Connection
        Connection conn = null;

        try {
            //Kết nối qua trình điều khiển JDBC
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(conURL, username, password);
            System.out.println("Connect!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn; //Trả về chuỗi kết nối
    }
    public static void main(String[] args) throws ClassNotFoundException {
       ConnectDB obj = new ConnectDB();
       obj.Connect();
       
            // Call the Connect() method to establish a connection to the database
            
    }
}
