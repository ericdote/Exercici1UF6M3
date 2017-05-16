package vista;

import java.util.List;
import javax.swing.JOptionPane;
import model.Usuari;

/**
 * Classe creada per mostrar missatges
 *
 * @author Eric
 */
public class VistaText {

    /**
     * Menu que es mostra per seleccionar una opcio
     */
    public void mostrarMenu() {
        System.out.println("Selecciona una opcio:\n"
                + "1- Afegir\n"
                + "2- Afegir(llista)\n"
                + "3- Esborrar"
                + "4- Modificar\n"
                + "5- Cercar per Nif\n"
                + "6- Cercar tots\n"
                + "7- Sortir");
    }

    /**
     * Metode per mostrar errors que li arriben per parametre
     *
     * @param missatge
     */
    public void error(String missatge) {
        System.err.println(missatge);
    }

    /**
     * Metode que mostra missatge quan es fa una accio be
     *
     * @param missatge accio que s'ha realitzat correctament
     */
    public void ok(String missatge) {
        JOptionPane.showMessageDialog(null, missatge);
    }

    /**
     * Metode que torna un valor introduit pel usuari.
     *
     * @param valor Li arriba lo que estem demanant en X moment.
     * @return
     */
    public String introduirDades(String valor) {
        return JOptionPane.showInputDialog(null, "Introdueix el " + valor);
    }

    /**
     * Metode que mostra un usuari.
     *
     * @param u
     */
    public void mostraUsuari(Usuari u) {
        JOptionPane.showMessageDialog(null, u);
    }

    /**
     * Metode que mostra tots els usuaris.
     *
     * @param list
     */
    public void mostraTotsUsuaris(List<Usuari> list) {
        for (Usuari usuari : list) {
            JOptionPane.showMessageDialog(null, "Mostrant l'usuari: " + usuari);
        }
    }

}
