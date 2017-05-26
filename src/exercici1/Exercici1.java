package exercici1;

import controlador.Control;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import persistencia.ConfigConnexio;

/**
 *
 * @author Eric
 */
public class Exercici1 {


    public static void main(String[] args) throws FileNotFoundException, IOException {
        Properties p = new Properties();
        ConfigConnexio cc = new ConfigConnexio();
        Control con = new Control(cc.getCon());
        con.seleccionaOpcio();
    }
    
}
