/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qed;

import java.util.List;
import javax.swing.SwingUtilities;
import qed.node.QEDDiagram;
import qed.node.QEDNode;
import qed.ui.QEDDiagramCanvas;
import qed.ui.QEDDiagramFrame;

/**
 *
 * @author stellarspot
 */
public class QED {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int bosonSources = 1;
        int bosonDrains = 1;
        int fermionSources = 1;
        int fermionDrains = 1;
        
        int interactions = 2;
        
        final List<QEDNode[]> diagrams = QEDDiagram.generateDiagrams(bosonSources, fermionSources, bosonDrains, fermionDrains, interactions);

        //System.out.println("-----------------------");
        System.out.println("diagrams: " + diagrams.size());
        for(QEDNode[] d: diagrams){
            QEDDiagram.show(d);
        }
        
        
//        SwingUtilities.invokeLater(new Runnable() {
//
//            @Override
//            public void run() {
//              
//                QEDDiagramCanvas canvas = new QEDDiagramCanvas();
//                canvas.addDiagram(diagrams.get(0));
//                
//                QEDDiagramFrame frame = new QEDDiagramFrame(canvas);
//                
//            }
//        });
        
        
    }
}
