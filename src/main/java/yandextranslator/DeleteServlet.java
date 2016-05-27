package yandextranslator;

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
 * Created by hsenid on 4/29/16.
 */
public class DeleteServlet extends HttpServlet {
    public void doPost(HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {

       /* String userCheck[] = request.getParameterValues("userCheck");

        if (userCheck != null) {

            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.include(request, response);

        } else {

            RequestDispatcher rd = request.getRequestDispatcher("/success.jsp");
            rd.include(request, response);
        }*/
        String username = request.getParameter("val");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database
            Connection con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/login_form", "root", "root");

            PreparedStatement ps = con.prepareStatement
                    ("DELETE * FROM user where username=?");

            ps.setString(1,username);
            ps.execute();
            out.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
