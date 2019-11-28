import java.sql.Connection;
import java.util.Base64;
import javax.servlet.http.HttpServletRequest;

public class Run1 extends RunUtils{

  private Connection connection;

  public Run1(HttpServletRequest req, Connection connection) {
    super(req);
    this.connection = new CreateConn().invoke();//remove the data flow. req do not flow to the sink
  }

  public void invoke() {
//    try {
//      connection = DriverManager.getConnection("jdbc:mysql://localhost/DBPROD", "admin", "1234");
//    } catch (SQLException e) {
//      e.printStackTrace();
//    }
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

  private class CreateConn {

    public SafeConnection invoke() {
      return new SafeConnection();
    }
  }
}
