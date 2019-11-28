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

//false negative: missing the CI(req) The code in CI allows a user to inject arbitrary Javascript into Java's script engine.
@WebServlet(name = "simpleServlet", urlPatterns = { "/insider" }, loadOnStartup = 1)
public class Example5 extends HttpServlet {

  public static void main(String[] args) {

  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {
    CI(req);
  }

  private void CI(HttpServletRequest req) {
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("JavaScript");
    try {
      engine.eval("print('" + req.getParameter("something_eval")+ "')");
    } catch (ScriptException e) {
      e.printStackTrace();
    }
  }
}
