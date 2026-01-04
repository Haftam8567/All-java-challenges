import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class BouncingTextApplet extends Applet implements Runnable {

    private Thread thread;
    private int x = 0; // Starting x position
    private String text = "Java Applet"; // Generic text
    private boolean running = false;

    // Called once when the applet is initialized
    public void init() {
        setSize(400, 200); // Set applet size
        setBackground(Color.CYAN); // Set background color
    }

    // Called when the applet starts (or resumes)
    public void start() {
        if (thread == null) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    // Called when the applet stops (e.g., window minimized)
    public void stop() {
        running = false;
        thread = null;
    }

    // The animation loop
    public void run() {
        while (running) {
            x += 10; // Move text to the right

            // Reset position if it goes beyond the right edge
            if (x > getWidth()) {
                x = 0;
            }

            repaint(); // Request screen redraw

            try {
                Thread.sleep(100); // Pause for 100 ms
            } catch (InterruptedException e) {
                // Just ignore
            }
        }
    }

    // Draw the text
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString(text, x, 100);
    }
}
