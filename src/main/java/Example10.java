import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//OK :Inter injection using polymorphism
@WebServlet(name = "simpleServlet", urlPatterns = { "/insider" }, loadOnStartup = 1)
public class Example10 extends HttpServlet {

  public static void main(String[] args) {

  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {
    Connection connection = null;
    rundoget(req, connection);
  }

  private void rundoget(HttpServletRequest req, Connection connection) {
    new Run(req, connection).invoke();
  }


}