import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ColorChangePanel extends JFrame {

    public ColorChangePanel() {
        setTitle("Color Change Panel");
        setSize(300, 300); // Initial size, panel can be resized
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the custom JPanel
        ColorPanel panel = new ColorPanel();
        add(panel, BorderLayout.CENTER); // Add to center of JFrame's content pane

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ColorChangePanel::new);
    }
}

// Custom JPanel class to handle drawing and mouse events
class ColorPanel extends JPanel {
    private Color fillColor = Color.GREEN; // Default color on release

    public ColorPanel() {
        setPreferredSize(new Dimension(100, 100)); // Initial size as 100x100 pixels

        // Mouse event listeners
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                fillColor = Color.BLUE; // Set color to blue on press
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                fillColor = Color.GREEN; // Set color to green on release
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw a 10-pixel black border
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Draw the inner colored rectangle
        g2d.setColor(fillColor);
        g2d.fillRect(10, 10, getWidth() - 20, getHeight() - 20); // Adjust for 10-pixel border
    }
}
