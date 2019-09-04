package codex;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class Main {
    public static void main(String[] args) {

        JEditorPane jEditorPane = new JEditorPane();
        jEditorPane.setEditable(false);

        // now add it to a scroll pane
        JScrollPane scrollPane = new JScrollPane(jEditorPane);

        var frame = new JFrame();
        frame.setSize(400, 400);
        frame.add(scrollPane);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static int getNumClassesOnClassPath() {
        return 0;
    }
}
