package usermanager;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * Created by hsenid on 4/26/16.
 */
public class SearchServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(SearchServlet.class);

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
            ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database
            Connection con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/login_form", "root", "root");

            String username = request.getParameter("username");

            /*PreparedStatement ps = con.prepareStatement
                    ("SELECT * FROM user WHERE fname=username");*/
            //ps.execute();
            PreparedStatement ps = con.prepareStatement("select * from user where username LIKE ?");
            ps.setString(1,"%" +username+ "%");
            ResultSet rs = ps.executeQuery();

           /* if (!rs.next()) {
                //out.println(""+username+" is avaliable");

                request.setAttribute("errorMessage", "No results found!");
                RequestDispatcher rd = request.getRequestDispatcher("/searchuser.jsp");
                rd.include(request, response);
            }
            else{*/
                JSONArray jsonArray = new JSONArray();
                while (rs.next()) {
                    int total_rows = rs.getMetaData().getColumnCount();
                    JSONObject obj = new JSONObject();
                    for (int i = 0; i < total_rows; i++) {
                        obj.put(rs.getMetaData().getColumnLabel(i + 1)
                                .toLowerCase(), rs.getObject(i + 1));
                        jsonArray.put(obj);
                        request.setAttribute("dataObj",obj);

                        FileWriter file = new FileWriter("/home/hsenid/Documents/PermissionAppGit/src/main/webapp/js/searchdata.json");
                        file.write("{\"total\":"+total_rows+",\"rows\":\n" +
                                "[" + obj.toString() + "]}");

                        file.flush();
                        file.close();

                    }

                }
               // logger.info(jsonArray);

            request.setAttribute("errorMessage", "User already exists !");
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
           /* if (ps.execute()) {
                request.setAttribute("searchMessage", "1");
                RequestDispatcher rd = request.getRequestDispatcher("/searchuser.jsp");
                rd.include(request, response);

            } else if (searchName == null) {
                request.setAttribute("searchMessage", "2");
                RequestDispatcher rd = request.getRequestDispatcher("/searchuser.jsp");
                rd.include(request, response);

            } else {
                request.setAttribute("errorMessage", "No results found !");
                RequestDispatcher rd = request.getRequestDispatcher("/searchuser.jsp");
                try {
                    rd.include(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                    logger.error("Exception thrown  :\" ,e");
                } catch (IOException e) {
                    logger.error("Exception thrown  :\" , e");
                }
            }*/
        /*    out.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
*/


