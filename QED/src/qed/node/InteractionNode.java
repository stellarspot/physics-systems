/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qed.node;

/**
 *
 * @author stellarspot
 */
public class InteractionNode extends QEDNode {

//    public InteractionNode(int id) {
//        super(id, 1, 2);
//        type = QEDNodeType.INTERACTION;
//    }
    public InteractionNode() {
        super(1, 2);
        type = QEDNodeType.INTERACTION;
    }
}
