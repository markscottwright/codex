package codex;

import javax.swing.JEditorPane;
import javax.swing.JScrollPane;

public class NotedEditor extends JScrollPane {
    final private JEditorPane editor;

    public NotedEditor(Main main) {
        super();
        this.editor = new JEditorPane();
        add(this.editor);
    }

}
