import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CPUInfoPanel extends JPanel {
    private final Color MAIN_CONTENT_COLOR = new Color(47, 47, 68);


    public CPUInfoPanel() {
        setLayout(new BorderLayout());
        setBackground(MAIN_CONTENT_COLOR);

        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
        containerPanel.setBackground(MAIN_CONTENT_COLOR);

        containerPanel.add(createTextPanel());
        containerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        containerPanel.add(createCpuInfoPanel());

        add(containerPanel, BorderLayout.NORTH);

    }

    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.BOLD, 20));
        return label;
    }

    private JPanel createTextPanel(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.setBackground(new Color(41, 41, 66));

        cpuInfo cpuName = new cpuInfo();
        cpuName.read();
        panel.add(createStyledLabel(cpuName.getModel()));

        return panel;
    }

    private JPanel createCpuInfoPanel(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.setBackground(new Color(41, 41, 66));

        CPUCachePage cpuCache = new CPUCachePage();
        panel.add(cpuCache);

        return panel;
    }
}
