package controlador;

import java.sql.Connection;
import java.util.List;
import model.Usuari;
import persistencia.PersistUsuari;
import vista.VistaText;

/**
 *
 * @author Eric
 */
public class GestioUsuaris {
    
    private final PersistUsuari persist;
    private final VistaText vt;

    public GestioUsuaris(Connection conexio) {
        this.persist = new PersistUsuari(conexio);
        this.vt = new VistaText();
    }
    /**
     * Metode que retorna si s'ha afegit o no l'usuari.
     * @param u
     * @return 
     */
    public boolean afegir(Usuari u){
        return persist.afegir(u);
    }
    /**
     * Metode que retorna si s'ha afegit l'array d'usuaris.
     * @param list
     * @return 
     */
    public boolean afegirArray(List<Usuari> list){
        return persist.afegirArray(list);
    }
    /**
     * Metode que retorna si s'ha esborrat o no l'usuari.
     * @param nif
     * @return 
     */
    public boolean esborrar(String nif){
        return persist.esborrar(nif);
    }
    /**
     * Metode que retorna si s'ha modificat o no l'usuari.
     * @param u
     * @return 
     */
    public boolean modificar(Usuari u){
        return persist.modificar(u);
    }
    /**
     * Metode que retorna si s'ha trobat o no l'usuari.
     * @param nif
     * @return 
     */
    public Usuari cerca(String nif){
        return persist.cerca(nif);
    }
    /**
     * Metode que retorna si s'han trobat o no usuaris.
     * @return 
     */
    public List<Usuari> cercaTots(){
        return persist.cercaTots();
    }
    

    
    
    
}
