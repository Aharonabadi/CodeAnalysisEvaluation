public class Invok {

  public void run(){
    try {
      Example7.connection.createStatement().executeQuery(Example7.y);
    } catch (Exception e) {
    }
  }

}
