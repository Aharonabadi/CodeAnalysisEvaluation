import javax.script.*;

//false negative: https://www.owasp.org/index.php/Code_injection_in_Java
public class Example1 {
	public static void main(String[] args) {
		try {
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("JavaScript");
			System.out.println(args[0]);
			engine.eval("print('"+ args[0] + "')");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}