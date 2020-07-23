/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrosimples;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.Tela;

/**
 *
 * @author Leandror
 */
public class CadastroSimples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
               try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            //UIManager.setInstalledLookAndFeels(UIManager.getSystemLookAndFeelClassName());
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        
        
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }
    
}
