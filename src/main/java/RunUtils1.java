import java.util.Base64;
import javax.servlet.http.HttpServletRequest;

public class RunUtils1 {

  private HttpServletRequest req;

  public RunUtils1() {
    this.req = null;
  }

  String getString() {
    String x = req.getParameter("x");
    return new String(Base64.getDecoder().decode(x));
  }

  public void invoke(){

  }
}
