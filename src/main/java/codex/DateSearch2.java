package codex;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class DateSearch2 extends JPanel {

    public DateSearch2() {
        GridLayout layout = new GridLayout(5, 7);
        setLayout(layout);
        for (int i = 0; i < 5 * 7; ++i) {
            JTextField date = new JTextField("" + (i + 1));
            date.setHorizontalAlignment(SwingConstants.LEFT);
            date.setBorder(new LineBorder(Color.black, 3));
            add(date);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("OCTOBER");
            frame.add(new DateSearch2());
            frame.setSize(300, 300);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
