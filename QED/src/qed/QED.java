/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qed;

import qed.node.QEDDiagram;

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
        
        QEDDiagram.generateDiagrams(bosonSources, fermionSources, bosonDrains, fermionDrains, interactions);
        
        
        
    }
}
