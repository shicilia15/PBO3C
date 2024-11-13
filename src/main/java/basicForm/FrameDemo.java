 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basicForm;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author WINDOWS 10
 */
public class FrameDemo extends JFrame {
    public FrameDemo() {
    setTitle ("sil");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(300,200);
}

public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable(){
  @Override
    public void run() {
        new FrameDemo().setVisible(true);
              }
        });
    }       
}