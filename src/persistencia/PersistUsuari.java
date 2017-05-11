
package persistencia;

import java.sql.Connection;
import java.util.List;
import model.Usuari;

/**
 *
 * @author Eric
 */
public class PersistUsuari {
    private Connection con;
    private ConfigConnexio conBBDD;

    public PersistUsuari(Connection con, ConfigConnexio conBBDD) {
        this.con = con;
        this.conBBDD = conBBDD;
    }
    
    private boolean afegir(Usuari u){
        
    }
    
    private boolean afegirArray(List<Usuari> list){
        
    }
    
    private boolean esborrar(String nif){
        
    }
    
    private boolean modificar(Usuari u){
        
    }
    
    private Usuari cerca(String nif){
        
    }
    
    private List<Usuari> cercaTots(){
        
    }
}
