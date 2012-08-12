/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qed.node;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author stellarspot
 */
public class QEDDiagram {

    BosonNode[] bosonSources;
    FermionNode[] fermionSources;
    BosonNode[] bosonDrains;
    FermionNode[] fermionDrains;
    InteractionNode[] interactions;

    public QEDDiagram(int bosonSources, int fermionSources, int bosonDrains, int fermionDrains, int interactions) {
        this.bosonSources = new BosonNode[bosonSources];
        this.bosonDrains = new BosonNode[bosonDrains];
        this.fermionSources = new FermionNode[fermionSources];
        this.fermionDrains = new FermionNode[fermionDrains];

        this.interactions = new InteractionNode[interactions];


    }

    public static List<QEDNode[]> generateDiagrams(int bosonSources, int fermionSources, int bosonDrains, int fermionDrains, int interactions) {


        int N = bosonSources + bosonDrains + fermionSources + fermionDrains + interactions;

        Stack<QEDNode[]> nodesStack = new Stack<QEDNode[]>();

        List<QEDNode[]> completed = new LinkedList<>();


//        QEDList<QEDNode> handled = new QEDList<>(N);
//        QEDList<QEDNode> unhandled = new QEDList<>(N);

        QEDNode[] nodes = new QEDNode[N];

        int k = 0;
        for (int i = 0; i < bosonSources; i++) {
            nodes[i + k] = new BosonNode(true);
        }
        k += bosonSources;
        for (int i = 0; i < bosonDrains; i++) {
            nodes[i + k] = new BosonNode(false);
        }
        k += bosonDrains;
        for (int i = 0; i < fermionSources; i++) {
            nodes[i + k] = new FermionNode(true);
        }
        k += fermionSources;

        for (int i = 0; i < fermionDrains; i++) {
            nodes[i + k] = new FermionNode(false);
        }
        k += fermionDrains;

        for (int i = 0; i < interactions; i++) {
            nodes[i + k] = new InteractionNode();
        }


        //System.out.println(unhandled);


        //QEDNode current = unhandled.remove();

        //System.out.println("current: " + current);
//        System.out.println("nodes: ");
//
//        for (QEDNode node : nodes) {
//            System.out.println("node: " + node);
//        }



        nodesStack.push(nodes);

        while (!nodesStack.isEmpty()) {
            nodes = nodesStack.pop();
            //show(nodes);

            boolean hasFreeLinks = false;

            for (int i = 0; i < N; i++) {
                QEDNode node1 = nodes[i];
                //System.out.println("node1 " + i + ") " + node1);
                if (!node1.hasFreeLinks()) {
                    //System.out.println("no free links: " + node1);
                    continue;
                }
                hasFreeLinks = true;

                for (int j = i + 1; j < N; j++) {
                    QEDNode node2 = nodes[j];
                    //System.out.println("node2: " + node2);
                    if (canBeConnected(node1, node2)) {
                        //System.out.println("can be connected: " + i + ", " + j);
                        QEDNode[] copy = copy(nodes);
                        connect(copy[i], i, copy[j], j);
                        nodesStack.push(copy);

                    }
                }
                //System.out.println("");

            }
            if (!hasFreeLinks) {
                //System.out.println("COMPLETED: ");
                //show(nodes);
                completed.add(nodes);
            }
        }

        //System.out.println("-----------------------");
//        System.out.println("completed: " + completed.size());
//        for(QEDNode[] d: completed){
//            show(d);
//        }
        
        return completed;
    }

    static boolean canBeConnected(QEDNode node1, QEDNode node2) {
        return node1.hasFreeBosonLinks() && node2.hasFreeBosonLinks()
                || node1.hasFreeFermionLinks() && node2.hasFreeFermionLinks();
    }

    static void connect(QEDNode node1, int index1, QEDNode node2, int index2) {
        if (node1.hasFreeBosonLinks() && node2.hasFreeBosonLinks()) {
            node1.addBoson(index2);
            node2.addBoson(index1);
        } else if (node1.hasFreeFermionLinks() && node2.hasFreeFermionLinks()) {
            node1.addFermion(index2);
            node2.addFermion(index1);
        } else {
            throw new RuntimeException();
        }
    }

    static QEDNode[] copy(QEDNode[] nodes) {
        QEDNode[] copy = new QEDNode[nodes.length];

        for (int i = 0; i < nodes.length; i++) {
            copy[i] = nodes[i].copy();
        }
        return copy;
    }

    public static void show(QEDNode[] nodes) {
        System.out.println("Diagram:");
        for (int i = 0; i < nodes.length; i++) {
            System.out.println(i + ") " + nodes[i]);
        }
        System.out.println();

    }
//    class QEDItem {
//
//        QEDList<QEDNode> handled;
//        QEDList<QEDNode> unhandled;
//        QEDNode current;
//        QEDNode next;
//    }
}
