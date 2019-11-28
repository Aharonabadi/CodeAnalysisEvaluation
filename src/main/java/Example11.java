import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//False positive: sink is  SafeConnection which is safe.
@WebServlet(name = "simpleServlet", urlPatterns = { "/insider" }, loadOnStartup = 1)
public class Example11 extends HttpServlet {

  public static void main(String[] args) {

  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {
    Connection connection = null;
    rundoget(req, connection);
  }

  private void rundoget(HttpServletRequest req, Connection connection) {
    new Run1(req, connection).invoke();
  }


}