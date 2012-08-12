/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qed.node;

import java.util.Arrays;
import qed.utils.Copyable;

/**
 *
 * @author stellarspot
 */
public class QEDNode implements Copyable<QEDNode> {

    //protected int id;
    // bosons
    protected int bosonsMaxNumber;
    protected int bosonsNumber;
    protected int[] bosons;
    // fermions
    protected int fermionsMaxNumber;
    protected int fermionsNumber;
    protected int[] fermions;
    protected QEDNodeType type = QEDNodeType.UNKNOWN;

    //public QEDNode(int id, int bosonsMaxNumber, int fermionsMaxNumber) {
    private QEDNode() {
    }

    public QEDNode(int bosonsMaxNumber, int fermionsMaxNumber) {
        //this.id = id;
        this.bosonsMaxNumber = bosonsMaxNumber;
        this.fermionsMaxNumber = fermionsMaxNumber;
        bosons = new int[bosonsMaxNumber];
        fermions = new int[fermionsMaxNumber];
    }

    public boolean hasFreeBosonLinks() {
        return bosonsNumber < bosonsMaxNumber;
    }

    public boolean hasFreeFermionLinks() {
        return fermionsNumber < fermionsMaxNumber;
    }

    public boolean hasFreeLinks() {
        return hasFreeBosonLinks() || hasFreeFermionLinks();
    }

    public void addBoson(int index) {
        bosons[bosonsNumber++] = index;
    }

    public void addFermion(int index) {
        fermions[fermionsNumber++] = index;
    }

    @Override
    public QEDNode copy() {
        QEDNode copy = new QEDNode();
        copy.type = type;

        // bosons
        copy.bosonsMaxNumber = bosonsMaxNumber;
        copy.bosonsNumber = bosonsNumber;
        copy.bosons = Arrays.copyOf(bosons, bosonsMaxNumber);
        // fermions
        copy.fermionsMaxNumber = fermionsMaxNumber;
        copy.fermionsNumber = fermionsNumber;
        copy.fermions = Arrays.copyOf(fermions, fermionsMaxNumber);

        return copy;
    }

    @Override
    public String toString() {
        //return type + " " + id;
        String res = "bosons " + bosonsNumber + " of " + bosonsMaxNumber + ": [";
        for (int i = 0; i < bosonsNumber; i++) {
            res += bosons[i] + " ";
        }

        res += "] fermions " + fermionsNumber + " of " + fermionsMaxNumber +  ": [";
        for (int i = 0; i < fermionsNumber; i++) {
            res += fermions[i] + " ";
        }
        res += "]";

        return type + " " + res;
    }
}
