import javax.swing.*;
import java.awt.*;

public class DashboardApp {
    private JFrame frame;
    private JPanel mainContent;
    private CardLayout cardLayout;

    // Colors based on your CSS
    private final Color BACKGROUND_COLOR = new Color(30, 30, 47);      // #1e1e2f
    private final Color SIDEBAR_COLOR = new Color(41, 41, 66);         // #292942
    private final Color MAIN_CONTENT_COLOR = new Color(47, 47, 68);    // #2f2f44
    private final Color BUTTON_COLOR = new Color(52, 50, 74);          // #34324a
    private final Color BUTTON_HOVER_COLOR = new Color(87, 85, 125);   // #57557d
    private final Color BORDER_COLOR = new Color(75, 75, 96);          // #4b4b60

    public DashboardApp() {
        try {
            // Set system look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.getContentPane().setBackground(BACKGROUND_COLOR);

        // Create sidebar
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(SIDEBAR_COLOR);
        sidebar.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        sidebar.setPreferredSize(new Dimension(200, 600));

        // Initialize CardLayout and mainContent FIRST
        cardLayout = new CardLayout();
        mainContent = new JPanel(cardLayout);
        mainContent.setBackground(MAIN_CONTENT_COLOR);
        mainContent.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER_COLOR, 2),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        mainContent.add(createContentPanel("General Info: Placeholder for CPU Info"), "General Info");
        mainContent.add(new CPUInfoPanel(), "CPU Info");
        mainContent.add(createContentPanel("Memory Info: Placeholder for Memory Info"), "Memory Info");
        mainContent.add(createContentPanel("Bus Info: Placeholder for Bus Info"), "Bus Info");

        // Create buttons//
        String[] buttonLabels = {"General Info", "CPU Info", "Memory Info", "PCI Info", "Bus Info"};
        for (String label : buttonLabels) {
            JButton button = createStyledButton(label);
            sidebar.add(button);
            sidebar.add(Box.createRigidArea(new Dimension(0, 15)));
        }



        // Layout setup
        frame.setLayout(new BorderLayout());
        frame.add(sidebar, BorderLayout.WEST);
        frame.add(mainContent, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    private JButton createStyledButton(String text) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                if (getModel().isPressed()) {
                    g2.setColor(BUTTON_HOVER_COLOR.darker());
                } else if (getModel().isRollover()) {
                    g2.setColor(BUTTON_HOVER_COLOR);
                } else {
                    g2.setColor(BUTTON_COLOR);
                }

                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                g2.setColor(BORDER_COLOR);
                g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);

                g2.setColor(Color.WHITE);
                FontMetrics fm = g2.getFontMetrics();
                int textX = (getWidth() - fm.stringWidth(text)) / 2;
                int textY = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;
                g2.drawString(text, textX, textY);
                g2.dispose();
            }
        };
//

        button.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(150, 40));
        button.setMaximumSize(new Dimension(150, 40));
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);

        // Add action listener
        button.addActionListener(e -> cardLayout.show(mainContent, text));

        return button;
    }

    private JPanel createContentPanel(String text) {
        JPanel panel = new JPanel();
        panel.setBackground(MAIN_CONTENT_COLOR);

        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        panel.add(label);
        return panel;
    }
    //

    public static void main(String[] args) {
        System.loadLibrary("sysinfo");

        SwingUtilities.invokeLater(() -> {
            new DashboardApp();
        });
    }
}