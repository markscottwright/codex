package codex;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class DateSearch extends JTable {
    final static String[] COLUMN_NAMES = { "SUNDAY", "MONDAY", "TUESDAY",
            "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY" };

    public DateSearch() {
        super(new String[][] { { "OCT 1", "2", "3", "4", "5", "6", "7" },
                { "8", "9", "10", "11", "12", "13", "14" } }, COLUMN_NAMES);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("OCTOBER");
            DateSearch table = new DateSearch();
            JScrollPane scrollPane = new JScrollPane(table);
            table.setFillsViewportHeight(true);
            frame.add(scrollPane);
            frame.setSize(300, 300);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
