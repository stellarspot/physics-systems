/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qed.node;

/**
 *
 * @author stellarspot
 */
public class FermionNode extends QEDNode{

//    public FermionNode(int id, boolean source) {
//        super(id, 0,1);
//        this.type = source? QEDNodeType.FERMION_SOURCE : QEDNodeType.FERMION_DRAIN;
//        this.id += source? QEDNodeType.FERMION_SOURCE_ID : QEDNodeType.FERMION_DRAIN_ID;
//    }
    public FermionNode(boolean source) {
        super(0,1);
        this.type = source? QEDNodeType.FERMION_SOURCE : QEDNodeType.FERMION_DRAIN;
    }
    
}
