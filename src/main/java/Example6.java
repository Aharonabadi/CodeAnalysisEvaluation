import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Base64;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//false negative: missing data flow using static variables
@WebServlet(name = "simpleServlet", urlPatterns = {"/insider"}, loadOnStartup = 1)
public class Example6 extends HttpServlet {
  public static Connection connection = null;
  public static String y;
  public static void main(String[] args) { }
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {
    connection = null;
    try {
      connection = DriverManager.getConnection("jdbc:mysql://localhost/DBPROD", "admin", "1234");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    String x = req.getParameter("x");
    y = new String(Base64.getDecoder().decode(x));
    try {
      invok();
    } catch (Exception e) {
    }
  }
  private void invok() throws SQLException {
    Example6.connection.createStatement().executeQuery(Example6.y);
  }

  private void CI(HttpServletRequest req) {
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("JavaScript");
    try {
      engine.eval("print('" + req.getParameter("something_eval") + "')");
    } catch (ScriptException e) {
      e.printStackTrace();
    }
  }


}
