/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basicForm;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author WINDOWS 10
 */
public class Spotlight extends JPanel {
    private final int RADIUS = 50;
    private Image image;
    private int iw;
    private int ih;
    private int ix;
    private int iy;
    private boolean mouseIn;

    public Spotlight() {
        initComponents();
    }

    private void initComponents() {
        loadImage();
        
        iw = image.getWidth(null);
        ih = image.getHeight(null);

        addMouseMotionListener((MouseMotionListener) new MyMouseAdapter());
        addMouseListener((MouseListener) new MyMouseAdapter());
    }

    private void loadImage() {
        image = new ImageIcon("C:\\Users\\WINDOWS 10\\Documents\\NetBeansProjects\\pv1\\src\\main\\java\\images\\penguin.jfif").getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        int midX = (getWidth() - iw) / 2;
        int midY = (getHeight() - ih) / 2;

        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D bigr = bi.createGraphics();

        if (mouseIn) {
            bigr.setPaint(Color.white);
            bigr.fillOval(ix - RADIUS, iy - RADIUS, RADIUS * 2, RADIUS * 2);
            bigr.setComposite(AlphaComposite.SrcAtop);
            bigr.drawImage(image, midX, midY, iw, ih, this);
        }

        bigr.setComposite(AlphaComposite.SrcOver.derive(0.1f));
        bigr.drawImage(image, midX, midY, iw, ih, this);
        bigr.dispose();

        g2d.drawImage(bi, 0, 0, getWidth(), getHeight(), this);
        g2d.dispose();
    }

    private class MyMouseAdapter extends MouseAdapter {

        @Override
        public void mouseExited(MouseEvent e) {
            mouseIn = false;
            repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            mouseIn = true;
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            ix = e.getX();
            iy = e.getY();
            repaint();
        }
    }
}
