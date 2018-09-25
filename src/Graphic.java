import javax.swing.*;
import java.awt.*;

public class Graphic extends JFrame {


    public Graphic(int hauteur, int largeur, int nbrMines) {

        setSize(250, 250);
        setLocation(100, 100);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Mines.rendering(hauteur, largeur, nbrMines);

        setLayout(new FlowLayout());

        add(new Label(String.valueOf("Hauteur de la grille: " + hauteur)));
        add(new Label(String.valueOf("Largeur de la grille: " + largeur)));
        add(new Label(String.valueOf("Nombre de mines: " + nbrMines)));

        setVisible(true);
    }
}
