/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qed.node;

/**
 *
 * @author stellarspot
 */
public class BosonNode extends QEDNode {

//    public BosonNode(int id, boolean source) {
//        super(id, 0, 1);
//        this.type = source? QEDNodeType.BOSON_SOURCE : QEDNodeType.BOSON_DRAIN;
//        this.id += source? QEDNodeType.BOSON_SOURCE_ID : QEDNodeType.BOSON_DRAIN_ID;
//    }
    public BosonNode(boolean source) {
        super(1, 0);
        this.type = source? QEDNodeType.BOSON_SOURCE : QEDNodeType.BOSON_DRAIN;
    }


}
