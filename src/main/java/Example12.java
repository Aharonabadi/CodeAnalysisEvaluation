import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.UUID;
import org.apache.commons.lang3.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//false positive: password is not a sensitive  data. It is just a name.
class Example12{
  private final Logger logger = LoggerFactory.getLogger(Example12.class);


  void f(){
    generateCertificateAndPass("" ,"");
  }

  private void generateCertificateAndPass(String keystoreName, String password) {
    String keyToolPath = Paths.get(System.getProperty("java.home"), "bin", "keytool").toString();
    String[] params =
        new String[] {
          keyToolPath, "-genkey", "-alias", "replserver", "-keyalg", "RSA", "-keystore", keystoreName, "-dname", "\"CN=author, OU=Whitesource, O=WS, L=Location, S=State, C=US\"", "-storepass", password, "-keypass",
          password
        };

    if (SystemUtils.IS_OS_LINUX) {
      params = new String[] {keyToolPath, "-genkey", "-alias", "replserver", "-keyalg", "RSA", "-keystore", keystoreName, "-dname", "CN=author, OU=Whitesource, O=WS, L=Location, S=State, C=US", "-storepass",
            password,
            "-keypass",
            password
          };
    }
    this.logger.debug("start execute command '{}'", params);
    }
}
