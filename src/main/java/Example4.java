import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//false negative: missing dataflow using functions that came from external jars: Getter.getInput(req)
@WebServlet(name = "simpleServlet", urlPatterns = {"/insider"}, loadOnStartup = 1)
public class Example4 extends HttpServlet {
  public static void main(String[] args) {

  }
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {
    Connection connection = null;
    try {
      connection = DriverManager.getConnection("jdbc:mysql://localhost/DBPROD", "admin", "1234");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    String y = Getter.getInput(req);
    try {
      connection.createStatement().executeQuery(y);
    } catch (Exception e) {
    }
  }
}
