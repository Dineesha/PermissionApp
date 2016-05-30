package usermanager;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * Created by hsenid on 5/6/16.
 */
public class UserEditServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String fname = request.getParameter("f_name");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String dob = request.getParameter("date2");
        String phone = request.getParameter("phonenumber");
        String country = request.getParameter("country");
        String group = request.getParameter("group");
        String username = request.getParameter("uname");
        String password = request.getParameter("password");
        String city_id=request.getParameter("city");


            response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database
            Connection con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/login_form", "root", "root");

            PreparedStatement ps = con.prepareStatement
                    ("UPDATE user SET fname=?,lname=?, email=?, dob=?, country=?,city_id=?,phone=?,password=?+\n" +
                            "                             WHERE username =?;");

            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, email);
            ps.setString(4, dob);
            ps.setString(5, country);
            ps.setString(6, city_id);
            ps.setString(7, phone);
            ps.setString(8, password);
            ps.setString(9, username);
            ps.execute();
            out.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
