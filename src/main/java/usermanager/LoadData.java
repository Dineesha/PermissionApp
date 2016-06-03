package usermanager;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by hsenid on 6/3/16.
 */
public class LoadData extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
                ServletException {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
                Class.forName("com.mysql.jdbc.Driver");

                //creating connection with the database
                Connection con = DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/login_form", "root", "root");



                PreparedStatement ps = con.prepareStatement("select * from user ");
                ResultSet rs = ps.executeQuery();


                JSONArray jsonArray = new JSONArray();
                while (rs.next()) {
                    int total_rows = rs.getMetaData().getColumnCount();
                    JSONObject obj = new JSONObject();
                    for (int i = 0; i < total_rows; i++) {
                        obj.put(rs.getMetaData().getColumnLabel(i + 1)
                                .toLowerCase(), rs.getObject(i + 1));
                        jsonArray.put(obj);
                        request.setAttribute("dataObj", obj);


                        FileWriter file = new FileWriter("/home/hsenid/Documents/PermissionAppGit/src/main/webapp/js/loaddata.json");
                        file.write("{\"total\":"+total_rows+",\"rows\":\n" +
                                "[" + obj.toString() + "]}");

                        file.close();

                    }
                }


                // logger.info(jsonArray);

                RequestDispatcher rd = request.getRequestDispatcher("/searchuser.jsp");
                rd.forward(request, response);
                //out.println(""+username+" is already in use");

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





