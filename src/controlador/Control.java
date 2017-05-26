package controlador;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Usuari;
import vista.VistaText;

/**
 *
 * @author Eric
 */
public class Control {

    private final VistaText vt;
    private final GestioUsuaris gu;

    public Control(Connection conexio) {
        this.vt = new VistaText();
        this.gu = new GestioUsuaris(conexio);
    }

    /**
     * Metode utilitzat per seleccionar quina operacio vol fer l'usuari.
     */
    public void seleccionaOpcio() {
        int opcio = 0;
        boolean sortir = false;
        do {
            vt.mostrarMenu();
            opcio = Integer.parseInt(JOptionPane.showInputDialog(null, "Introdueix la opcio que vols realitzar"));
            if (getOpcio(opcio)) {
                sortir = opcionsMenu(opcio);
            } else {
                vt.error("Selecciona una opcio valida!");
            }
        } while (!sortir);
    }

    /**
     * Metode que controla que l'opcio sigui correcta.
     *
     * @param numero
     * @return
     */
    public boolean getOpcio(int numero) {
        boolean correcte = false;
        if (numero <= 7 && numero >= 1) {
            correcte = true;
        }
        return correcte;
    }

    /**
     * Metode que executa les diferents operacions i crida al VistaText per
     * informar si s'ha realitzat be o no l'operacio.
     *
     * @param opcio
     * @return
     */
    public boolean opcionsMenu(int opcio) {
        String nif;
        boolean ok = false, sortir = false;
        switch (opcio) {
            case 1:
                afegir();
                break;
            case 2:
                afegirArray();
                break;
            case 3:
                eliminar();
                break;
            case 4:
                modificar();
                break;
            case 5:
                cerca();
                break;
            case 6:
                cercaTots();
                break;
            case 7:
                sortir = true;
                break;
        }
        return sortir;
    }
    /**
     * Metode per cercar tots els usuaris
     */
    private void cercaTots() {
        List<Usuari> list = gu.cercaTots();
        if (list != null) {
            vt.mostraTotsUsuaris(list);
        } else {
            vt.error("No hi han usuaris.");
        }
    }
    /**
     * Metode per cerca un usuari pel seu nif
     */
    private void cerca() {
        String nif;
        Usuari u = new Usuari();
        nif = vt.introduirDades("nif");
        u = gu.cerca(nif);
        if (u != null) {
            vt.mostraUsuari(u);
        } else {
            vt.error("No existeix l'usuari");
        }
    }
    /**
     * Metode per modificar un usuari
     */
    private void modificar() {
        boolean ok;
        Usuari u = new Usuari();
        u.setNif(vt.introduirDades("nif per modificar"));
        u.setNom(vt.introduirDades("nom"));
        u.setCognoms(vt.introduirDades("cognom"));
        ok = gu.modificar(u);
        if (ok) {
            vt.ok("Usuari modificar correctament");
        } else {
            vt.error("No s'ha pogut modificar l'usuari");
        }
    }
    /**
     * Metode per eliminar un usuari
     */
    private void eliminar() {
        String nif;
        boolean ok;
        nif = vt.introduirDades("nif");
        ok = gu.esborrar(nif);
        if (ok) {
            vt.ok("Usuari eliminat correctament");
        } else {
            vt.error("No s'ha pogut eliminar l'usuari");
        }
    }
    /**
     * Metode per afegir un array d'usuaris
     */
    private void afegirArray() {
        boolean ok;
        Usuari u;
        int num = vt.seleccionarNumUsuaris();
        List<Usuari> usuaris = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            u = new Usuari();
            u.setNif(vt.introduirDades("nif"));
            u.setNom(vt.introduirDades("nom"));
            u.setCognoms(vt.introduirDades("cognom"));
            usuaris.add(u);
        }
        ok = gu.afegirArray(usuaris);
        if (ok) {
            vt.ok("Usuaris afegits correctament");
        } else {
            vt.error("No s'ha pogut afegir els usuaris");
        }
    }
    /**
     * Metode per afegir un usuari
     */
    private void afegir() {
        boolean ok;
        Usuari u = new Usuari();
        u.setNif(vt.introduirDades("nif"));
        u.setNom(vt.introduirDades("nom"));
        u.setCognoms(vt.introduirDades("cognom"));
        ok = gu.afegir(u);
        if (ok) {
            vt.ok("Usuari afegit correctament");
        } else {
            vt.error("No s'ha pogut afegir l'usuari");
        }
    }
}
