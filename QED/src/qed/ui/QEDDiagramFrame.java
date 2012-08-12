/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qed.ui;

import java.awt.BorderLayout;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import qed.node.QEDNode;

/**
 *
 * @author user
 */
public class QEDDiagramFrame extends JFrame{
    
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
            

    
//    public void addDiagram(List<>){
//        
//    }

    public QEDDiagramFrame(QEDDiagramCanvas canvas) {
        setTitle("Diagrams");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(canvas, BorderLayout.CENTER);
        
        getContentPane().add(panel);
        
        setVisible(true);
    }
    
}
