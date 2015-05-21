package as.app;

import as.input.Mouse;
import as.input.Keyboard;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Display
{
    private JFrame frame;
    private JPanel panel;
    private static Canvas canvas;
    private int width, height;
    private Keyboard keyboard;
    private Mouse mouse;

    public Display()
    {
        this.width = 1366;
        this.height = 768;
        this.keyboard = new Keyboard();
        this.mouse = new Mouse();
        createDisplay();
        this.panel.requestFocus();
    }

    private void createDisplay()
    {
        // Create the frame
        frame = new JFrame("Autumn Steel");
        frame.setSize(this.width, this.height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Create a JPanel
        panel = new JPanel();
        panel.addKeyListener(this.keyboard);
        frame.add(panel);
        panel.requestFocusInWindow();

        // Create the canvas
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(this.width, this.height));
        canvas.setMaximumSize(new Dimension(this.width, this.height));
        canvas.setMinimumSize(new Dimension(this.width, this.height));
        canvas.addMouseListener(this.mouse);
        canvas.addMouseMotionListener(this.mouse);

        // Add the canvas to the frame
        frame.add(canvas);
        frame.pack();
    }

    public static Canvas getCanvas()
    {
        return canvas;
    }
}