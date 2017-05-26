package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuari;

/**
 *
 * @author Eric
 */
public class PersistUsuari {

    private Connection con;

    /**
     * Constructor que obre la connexio.
     *
     * @param con
     */
    public PersistUsuari(Connection con) {
        this.con = con;
    }

    /**
     * Metode que afegeix un usuari a la BBDD.
     *
     * @param u
     * @return
     */
    public boolean afegir(Usuari u) {
        boolean afegit = false;
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO USUARIS VALUES(?,?,?)");
            ps.setString(1, u.getNif());
            ps.setString(2, u.getNom());
            ps.setString(3, u.getCognoms());
            afegit = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            afegit = false;
            Logger.getLogger(PersistUsuari.class.getName()).log(Level.SEVERE, null, ex);
        }
        return afegit;
    }

    /**
     * Metode que afegeix un conjunt d'usuaris a la BBDD.
     *
     * @param list
     * @return
     */
    public boolean afegirArray(List<Usuari> list) {
        boolean afegit = false;
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO USUARIS VALUES(?,?,?)");
            for (Usuari usuari : list) {
                ps.setString(1, usuari.getNif());
                ps.setString(2, usuari.getNom());
                ps.setString(3, usuari.getCognoms());
                afegit = ps.executeUpdate() > 0;
            }
        } catch (SQLException ex) {
            afegit = false;
            Logger.getLogger(PersistUsuari.class.getName()).log(Level.SEVERE, null, ex);
        }
        return afegit;
    }

    /**
     * Metode que esborra un usuari pel seu nif.
     *
     * @param nif
     * @return
     */
    public boolean esborrar(String nif) {
        boolean esborrat = false;
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM USUARIS WHERE NIF = ?");
            ps.setString(1, nif);
            esborrat = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            esborrat = false;
            Logger.getLogger(PersistUsuari.class.getName()).log(Level.SEVERE, null, ex);
        }
        return esborrat;

    }

    /**
     * Metode que modifica un usuari pel seu nif.
     *
     * @param u
     * @return
     */
    public boolean modificar(Usuari u) {
        boolean modificat = false;
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE USUARIS SET NOM = ?, COGNOM = ? WHERE NIF = ?");
            ps.setString(1, u.getNom());
            ps.setString(2, u.getCognoms());
            ps.setString(3, u.getNif());
            modificat = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            modificat = false;
        }
        return modificat;
    }

    /**
     * Metode que s'utilitza per cercar un usuari pel seu nif.
     *
     * @param nif
     * @return
     */
    public Usuari cerca(String nif) {
        Usuari u = null;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM USUARIS WHERE NIF = ?");
            ps.setString(1, nif);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = new Usuari(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersistUsuari.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

    /**
     * Metode que cerca tots els usuaris.
     *
     * @return
     */
    public List<Usuari> cercaTots() {
        List<Usuari> usuaris = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM usuaris");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                usuaris.add(new Usuari(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersistUsuari.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuaris;
    }
}
