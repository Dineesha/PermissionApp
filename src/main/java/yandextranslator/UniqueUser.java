package yandextranslator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by hsenid on 5/19/16.
 */
public class UniqueUser {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database
            Connection con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/login_form", "root", "root");

            String searchName = request.getParameter("form-searchname");

            /*PreparedStatement ps = con.prepareStatement
                    ("SELECT * FROM user WHERE fname=searchName");*/
            //ps.execute();
            PreparedStatement ps = con.prepareStatement("select * from user where fname=?");
            ps.setString(1,searchName);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                //out.println(""+searchName+" is avaliable");
                request.setAttribute("errorMessage", "No results found!");
                RequestDispatcher rd = request.getRequestDispatcher("/searchuser.jsp");
                rd.include(request, response);
            }
            else{
                request.setAttribute("errorMessage", "User already exists !");
                RequestDispatcher rd = request.getRequestDispatcher("/searchuser.jsp");
                rd.include(request, response);
                //out.println(""+searchName+" is already in use");
            }
            out.println();

        } catch (Exception ex) {
            out.println("Error ->" + ex.getMessage());
        } finally {
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}

