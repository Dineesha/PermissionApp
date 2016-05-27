package yandextranslator;

import javax.servlet.http.HttpServlet;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hsenid on 5/17/16.
 */
public class CityCaller extends HttpServlet{
    private static final Logger LOGGER = LogManager.getLogger(CityCaller.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String countrygetter = request.getParameter("country");

        String sql = "select city_name from city where country=\'" + countrygetter + "\';";

        JsonObject jsonObj;
        JsonArray jsonArray = new JsonArray();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            con = Database.cpds.getConnection();
            st = con.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                jsonObj = new JsonObject();
                jsonObj.addProperty("city_name", rs.getString("city"));
                jsonArray.add(jsonObj);
            }
            out.println(jsonArray);

        } catch (Exception e) {
            LOGGER.error("Error  city");
        } finally {
            try {
                LOGGER.trace("Closing  connection..");
                con.close();
            } catch (SQLException e) {
                LOGGER.fatal("Error while closing connection..");
                e.printStackTrace();
            }
        }
    }
}
