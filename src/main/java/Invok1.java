import java.sql.Connection;

public class Invok1 {

  public void run(Connection connection, String y){
    try {
      connection.createStatement().executeQuery(y);
    } catch (Exception e) {
    }
  }

}
