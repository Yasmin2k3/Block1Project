import javax.swing.*;
import java.awt.*;

public class CPUInfoPanel extends JPanel {
    private final Color MAIN_CONTENT_COLOR = new Color(47, 47, 68);


    public CPUInfoPanel() {
        setLayout(new BorderLayout());
        setBackground(MAIN_CONTENT_COLOR);

        JPanel cpuInfoPanel = new JPanel();
        createCpuInfoPanel();
        add(createCpuInfoPanel(), BorderLayout.NORTH);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(new Color(41, 41, 66));
        tabbedPane.setForeground(Color.WHITE);
        tabbedPane.setFont(new Font("Segoe UI", Font.PLAIN, 14));

    }

    private JPanel createCpuInfoPanel(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(new Color(41, 41, 66));

        CPU cpuInfo = new CPU();
        CPUCachePage cpuCache = new CPUCachePage("CPU Load Area Chart");

        return panel;
    }

}