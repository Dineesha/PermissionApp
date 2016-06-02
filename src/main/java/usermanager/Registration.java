package usermanager;


import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by hsenid on 4/25/16.
 */
public class Registration extends HttpServlet {
    final static Logger logger = Logger.getLogger(Registration.class);

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String fname = request.getParameter("f_name");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String dob = request.getParameter("date2");
        String phone = request.getParameter("phonenumber");
        String country = request.getParameter("dd1");
        String group = request.getParameter("group");
        String username = request.getParameter("uname");
        String password = request.getParameter("password");
        String city_id=request.getParameter("city");

        try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database
            Connection con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/login_form", "root", "root");

            PreparedStatement ps = con.prepareStatement
                    ("INSERT INTO user (fname, lname, email, dob, country,city_id,phone,username,password," +
                            "group_id)\n" + "VALUES (?,?,?,?,?,(SELECT city_id from city where city_name=?),?,?,?,(select group_id from tbl_group where group_name=?)); ");

            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, email);
            ps.setString(4, dob);
            ps.setString(5, country);
            ps.setString(6, city_id);
            ps.setString(7, phone);
            ps.setString(8, username);
            ps.setString(9, password);
            ps.setString(10, group);

            PreparedStatement ps2=con.prepareStatement("INSERT INTO user_group (useruser_id," +
                    "groupgroup_id)\n" + "VALUES ((SELECT user_id from user where username=?),(SELECT group_id from tbl_group where group_name=?)); ");
            ps2.setString(1,username);
            ps2.setString(2,group);
            ps.execute();
            ps2.execute();
            out.close();
          //  response.sendRedirect("signup.jsp");
            //RequestDispatcher rd = getServletContext().getRequestDispatcher("/signup.jsp");

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/signup.jsp");

            rd.forward(request, response);




        } catch (ClassNotFoundException e) {


            e.printStackTrace();
        } /*catch (MySQLIntegrityConstraintViolationException e){
            response.sendRedirect("signup.jsp?name=" + username);
            out.print("<p style=\"color:red\">username already exists</p>");


        }*/ catch (SQLException e) {
            response.sendRedirect("signup.jsp?name=" + username);

            e.printStackTrace();

        }
    }
}

