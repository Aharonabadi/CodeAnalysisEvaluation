import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Base64;
import javax.servlet.http.HttpServletRequest;

public class Run extends RunUtils{

  private Connection connection;

  public Run(HttpServletRequest req, Connection connection) {
    super(req);
    this.connection = connection;
  }

  public void invoke() {
    try {
      connection = DriverManager.getConnection("jdbc:mysql://localhost/DBPROD", "admin", "1234");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    String y = getString();
    try {
      connection.createStatement().executeQuery(y);
    } catch (Exception e) {
    }
  }
  String getString() {
    String x = req.getParameter("x");
    return new String(Base64.getDecoder().decode(x));
  }

}
