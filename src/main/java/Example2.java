import javax.script.*;
import java.io.*;

//false negative: https://www.owasp.org/index.php/Code_injection_in_Java
public class Example2 {
	public static void main(String[] args) {
		try {
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("JavaScript");
			engine.eval(new java.io.FileReader("resources/" + args[0] + ".js"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
