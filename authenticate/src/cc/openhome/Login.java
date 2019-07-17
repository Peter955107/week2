package cc.openhome;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
    	String driver = "com.mysql.jdbc.Driver"; 
        String url = "jdbc:mysql://localhost/web_db"; 
        String dbuser = "root"; 
        String password = "123456";
        try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,dbuser, password);
		 
			if(conn != null && !conn.isClosed()) {
                System.out.println("資料庫連線測試成功！");
                PrintWriter out = response.getWriter();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM user");
                while(rs.next()){
                    // 通过字段检索
                	String dbUser  = rs.getString("user");
                    String dbPass = rs.getString("pass");
                    String dbemail = rs.getString("email");

                    // 输出数据
                    out.println(dbUser +" "+ dbPass + " " + dbemail);
                }
                //response.sendRedirect("user");
            }
		} 
        catch (ClassNotFoundException e) {
			response.sendRedirect("login.html");
			e.printStackTrace();
		} 
        catch(SQLException e) { 
            e.printStackTrace(); 
        } 
    } 
}