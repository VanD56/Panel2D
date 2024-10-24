package view;

import conrol.Controler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;

public class MyPanel extends JPanel {
  private Controler controler;

    public MyPanel(Controler c) {
      controler = c;
      addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {

          super.mousePressed(e);
          controler.mousePressed(e.getPoint());
          repaint();
        }
      });
      addMouseMotionListener(new MouseMotionAdapter() {
        @Override
        public void mouseDragged(MouseEvent e) {
          super.mouseDragged(e);
          controler.mouseDragged(e.getPoint());
          repaint();
        }
      });
    }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    ArrayList<RectangularShape> shapes = controler.translate();
    if(shapes!=null) {
      for (RectangularShape x :shapes)
        g2.draw(x);
    }
  }
}
