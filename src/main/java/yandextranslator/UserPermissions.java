package yandextranslator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserPermissions extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(UserPermissions.class);

    ArrayList<String> permissions = new ArrayList<String>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {



        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        permissions = getPermissionList(request.getParameter("username"));
        out.println(permissions);
    }

    public ArrayList<String> getPermissionList(String userName) throws ServletException {

        Connection con = null;
        ResultSet rs = null;
        PreparedStatement st = null;
        ArrayList<String> arrayList = new ArrayList<String>();

        String groupQuery = "SELECT permission_name FROM permission \n" + "WHERE permission_id IN\n" +
                "(SELECT permissionpermission_id FROM group_permission\n" + " WHERE groupgroup_id IN\n" +
                " (SELECT groupgroup_id FROM user_group\n" + "  WHERE username=\'" + userName + "\'))";

        try {

            con = Database.cpds.getConnection();
            st = con.prepareStatement(groupQuery);
            rs = st.executeQuery();

            while (rs.next()) {
                arrayList.add(rs.getString("name"));

            }

        } catch (SQLException ex) {
            LOGGER.error("Error in sql query");

        } finally {
            try {

                con.close();
            } catch (SQLException e) {
                LOGGER.fatal("Error while closing connection..", e);
            }
            try {

                rs.close();
            } catch (SQLException ex) {

            }
        }
        return arrayList;
    }
}
