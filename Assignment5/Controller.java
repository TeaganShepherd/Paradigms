
import java.awt.Graphics;
import java.io.IOException;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
import javax.swing.SwingUtilities;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


class Controller implements MouseListener, KeyListener
{
    Model model;
    View view;

    Controller() throws IOException, Exception {
        model = new Model();
        view = new View(this);
        //new Timer(50, view).start();
    }

    public void update(Graphics g) {
        model.update(g);
    }

    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
		if (SwingUtilities.isLeftMouseButton(e)) {
            model = new Model(x,y);
			// Gets here is left mouse button was clicked
		} else if (SwingUtilities.isRightMouseButton(e))  {
            model.updateScene(view.getWidth(),view.getHeight());
			// Gets here if right mouse button was clicked
        }
        view.repaint();
    }

    public void mouseReleased(MouseEvent e) {    }
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) {    }
    public void mouseClicked(MouseEvent e) {    }

    public void keyTyped(KeyEvent e){   
       if(e.getKeyChar() == 'h'){
            System.out.println("Hello world!");
       }
       else if(e.getKeyChar() == 'n'){
            System.out.println("-------------------------------------");
            System.out.println("Number of Robbers Captured: " + RobberCar.getCapCount()+"\nNumber of robbers escaped: " + RobberCar.getEscapeCount());
            System.out.println("-------------------------------------");
       }
       else if(e.getKeyChar() == 'r'){
        model.initialize();
        System.out.println("-------------------------------------");
        System.out.println("Initializing.....");
        System.out.println("-------------------------------------");
        view.repaint();
        }
        else if(e.getKeyChar() == 's'){
            Thread run = new Thread(new SpriteMover(model,view));
            run.start();
            System.out.println("-------------------------------------");
            System.out.println("Threading.....");
            System.out.println("-------------------------------------");
            
        }

    }
    public void keyPressed(KeyEvent e){   
        //System.out.println("Here 2");
    }
    public void keyReleased(KeyEvent e){   
        //System.out.println("Here 3");
    }

    public static void main(String[] args) throws Exception {
        //  Use the following line to determine which directory your program
        //  is being executed from, since that is where the image files will
        //  need to be.
        //System.out.println("cwd=" + System.getProperty("user.dir"));
        new Controller();
    }
}

