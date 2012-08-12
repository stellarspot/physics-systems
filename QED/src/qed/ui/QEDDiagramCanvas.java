/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qed.ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;
import qed.node.QEDNode;

/**
 *
 * @author user
 */
public class QEDDiagramCanvas extends Canvas {

    int d = 50;
    int r = 200;
    int R = r + 10;
    private List<QEDNode[]> diagrams = new LinkedList<>();

    public void addDiagram(QEDNode[] diagram) {
        diagrams.add(diagram);
    }

    @Override
    public void paint(Graphics g) {
        //super.paint(grphcs);

        
        Graphics2D g2 = (Graphics2D) g;
        g2.translate(QEDDiagramFrame.WIDTH / 2, QEDDiagramFrame.HEIGHT / 2);
        g2.scale(1, -1);

        int n = 0;
        for (QEDNode[] diagram : diagrams) {
            draw(g2, n, diagram);
            n++;
        }

    }

    void draw(Graphics2D g, int n, QEDNode[] diagram) {
        int N = diagram.length;
        double angle = 2 * Math.PI / N;

        for (int i = 0; i < N; i++) {
            draw(g, diagram[i], i, angle);
        }

    }

    void draw(Graphics2D g, QEDNode node, int index, double angle) {

        int radius = 15;

        double x = r * Math.cos(index * angle);
        double y = r * Math.sin(index * angle);


        Color color = Color.BLACK;

        switch (node.getType()) {
            case BOSON_DRAIN:
            case BOSON_SOURCE:
                color = color.ORANGE;
                break;
            case FERMION_SOURCE:
            case FERMION_DRAIN:
                color = color.BLUE;
                break;
            case INTERACTION:
                color = Color.GREEN;
                break;
        }

        drawCircle(g, x, y, radius, color);
    }

    void drawCircle(Graphics2D g, double x, double y, double r, Color color) {
        int rr = (int) (2 * r);
        g.setColor(color);
        g.fillOval((int) (x - r), (int) (y - r), rr, rr);
        g.setColor(Color.BLACK);
        g.drawOval((int) (x - r), (int) (y - r), rr, rr);
    }
}
