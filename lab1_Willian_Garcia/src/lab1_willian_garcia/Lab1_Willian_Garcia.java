
package lab1_willian_garcia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Lab1_Willian_Garcia {
    public static Nodo tree;
    public static void main(String[] args) throws IOException {
        try {
            FileReader in =new FileReader("C:\\archivo.txt");
            BufferedReader br =new BufferedReader(in);
            String a=br.readLine();
             tree=new Nodo();
                while (a != null) {
                    tree.add(a.toUpperCase());
                    a=br.readLine();
                }
            in.close();
        System.out.println("lvl: ");
        tree.lvl(tree);
            System.out.println("Pre:");
            tree.pre(tree);
            System.out.println("");
        Win win2= new Win();
        win2.setLocationRelativeTo(null);
        win2.setResizable(false);
        win2.setTitle("Laboratorio #1");
        win2.setVisible(true);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error al abrir el archivo "+ex);
        }
    }
    

}

// avion, me da avioneta