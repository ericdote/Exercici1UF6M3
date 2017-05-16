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
        Usuari u = new Usuari();
        String nif;
        boolean ok, sortir = false;
        switch (opcio) {
            case 1:
                u.setNif(vt.introduirDades("nif"));
                u.setNom(vt.introduirDades("nom"));
                u.setCognoms(vt.introduirDades("cognom"));
                ok = gu.afegir(u);
                if (ok) {
                    vt.ok("Usuari afegit correctament");
                } else {
                    vt.error("No s'ha pogut afegir l'usuari");
                }
                break;
            case 2:
                List<Usuari> usuaris = new ArrayList<>();
                while (!u.getNif().equals("")) {
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
                break;
            case 3:
                nif = vt.introduirDades("nif");
                ok = gu.esborrar(nif);
                if (ok) {
                    vt.ok("Usuari eliminat correctament");
                } else {
                    vt.error("No s'ha pogut eliminar l'usuari");
                }
                break;
            case 4:
                u.setNif(vt.introduirDades("nif"));
                u.setNom(vt.introduirDades("nom"));
                u.setCognoms(vt.introduirDades("cognom"));
                ok = gu.afegir(u);
                if (ok) {
                    vt.ok("Usuari modificar correctament");
                } else {
                    vt.error("No s'ha pogut modificar l'usuari");
                }
                break;
            case 5:
                nif = vt.introduirDades("nif");
                u = gu.cerca(nif);
                if (u != null) {
                    vt.mostraUsuari(u);
                } else {
                    vt.error("No existeix l'usuari");
                }
                break;
            case 6:
                List<Usuari> list = gu.cercaTots();
                if (list != null) {
                    vt.mostraTotsUsuaris(list);
                } else {
                    vt.error("No hi han usuaris.");
                }
                break;
            case 7:
                sortir = true;
                break;
        }
        return sortir;
    }
}
