/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qed.node;

/**
 *
 * @author stellarspot
 */
public enum QEDNodeType {

    BOSON_SOURCE,
    FERMION_SOURCE,
    BOSON_DRAIN,
    FERMION_DRAIN,
    INTERACTION,
    UNKNOWN;
    protected static final int BOSON_SOURCE_ID = 1000;
    protected static final int BOSON_DRAIN_ID = 2000;
    protected static final int FERMION_SOURCE_ID = 3000;
    protected static final int FERMION_DRAIN_ID = 4000;

    @Override
    public String toString() {
        switch (this) {
            case BOSON_SOURCE:
                return "Bs";
            case BOSON_DRAIN:
                return "Bd";
            case FERMION_SOURCE:
                return "Fs";
            case FERMION_DRAIN:
                return "Fd";
            case INTERACTION:
                return "In";
            default:
                return "UNKNOWN";
        }
    }
}
