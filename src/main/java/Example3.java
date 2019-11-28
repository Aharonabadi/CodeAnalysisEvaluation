import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Base64;
import javax.script.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//OK :Intra injection
//NOT GOOD: line numbers are not good.
//false negative: missing the CI(req) The code in CI allows a user to inject arbitrary Javascript into Java's script engine.
@WebServlet(name = "simpleServlet", urlPatterns = {"/insider"}, loadOnStartup = 1)
public class Example3 extends HttpServlet {

  public static void main(String[] args) {

  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {
    Connection connection = null;
    try {
      /*










       */
      connection = DriverManager.getConnection("jdbc:mysql://localhost/DBPROD", "admin", "1234");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    String x = req.getParameter("x");
    String y = new String(Base64.getDecoder().decode(x));
    try {
      connection.createStatement().executeQuery(y);
    } catch (Exception e) {
    }
    CI(req);
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
