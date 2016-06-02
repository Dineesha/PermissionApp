package usermanager;

/**
 * Created by hsenid on 3/14/16.
 */

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import database.DBConListener;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class Login extends HttpServlet {
    final static Logger logger = Logger.getLogger(Login.class);

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {

       /* PooledDataSource pds=new PooledDataSource();


        try {
            pds.createDataSource();
        } catch (PropertyVetoException e) {
            logger.error("property To Exception thrown in Pooled data source");
        }*/
        BasicConfigurator.configure();
        response.setContentType("text/html");

        String username = request.getParameter("form-username"); // get the name entered by user's input
        String password = request.getParameter("form-password"); //get the password entered by user's input



        response.setContentType("text/html");
        PrintWriter out = response.getWriter();



        HttpSession session = request.getSession(false);
        if(session!=null)
           // session.setAttribute("name", username);

        try {

            if(DBConListener.validate(username, password)){
                try {
                    //loading drivers for mysql
                    Class.forName("com.mysql.jdbc.Driver");

                    //creating connection with the database
                    Connection con = DriverManager.getConnection
                            ("jdbc:mysql://localhost:3306/login_form", "root", "root");

                    PreparedStatement ps = con.prepareStatement
                            ("select group_name from tbl_group where group_id=(SELECT group_id from user where username=?) ");

                    ps.setString(1, username);
                    ResultSet rs= ps.executeQuery();
                    if(rs.next()) {
                        String userGroup = rs.getString(1);

                        request.setAttribute("Role", userGroup);
                        RequestDispatcher rd = request.getRequestDispatcher("success.jsp?name=" + username);
                        rd.forward(request, response);
                    }


                    out.close();


                } catch (ClassNotFoundException e) {


                    e.printStackTrace();
                }  catch (SQLException e) {
                    logger.error("query error");
                    e.printStackTrace();

                }


              //  request.setAttribute("username", "kk");

            }
            else{
                out.print("<p style=\"color:red\">Sorry username or password error1</p>");
                RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                rd.include(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

        out.close();
    }
}



