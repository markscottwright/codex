package codex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

/**
 * A simple implementation of the Unix command fmt.
 */
public class Fmt {
    private int maxLength = 75;
    private boolean coalesceSpaces = false;

    static public class WordWithTrailingSpaces {

        public WordWithTrailingSpaces(String word, int spaces) {
            this.word = word;
            this.spaces = spaces;
        }

        final private String word;
        final private int spaces;

        public String getWord() {
            return word;
        }

        public int getSpaces(boolean coalesceSpaces) {
            // always return at least one
            if (!coalesceSpaces)
                return spaces == 0 ? 1 : spaces;
            else if (word.endsWith("!") || word.endsWith(".")
                    || word.endsWith("?"))
                return 2;
            else
                return 1;
        }
    }

    static public class WordIterator
            implements Iterator<WordWithTrailingSpaces> {

        final private String inputLine;
        private int position;

        public WordIterator(String inputLine, int initialPosition) {
            this.inputLine = inputLine;
            this.position = initialPosition;
        }

        @Override
        public boolean hasNext() {
            return position < inputLine.length();
        }

        @Override
        public WordWithTrailingSpaces next() {
            int trailingSpacesLen = 0;
            int wordStart = position;
            int wordEnd = position;
            while (position < inputLine.length()
                    && inputLine.charAt(position) != ' ') {
                wordEnd++;
                position++;
            }
            while (position < inputLine.length()
                    && inputLine.charAt(position) == ' ') {
                trailingSpacesLen++;
                position++;
            }
            return new WordWithTrailingSpaces(
                    inputLine.substring(wordStart, wordEnd), trailingSpacesLen);
        }
    }

    static public class InputLine implements Iterable<WordWithTrailingSpaces> {

        final private String line;

        public InputLine(String line) {
            this.line = line.stripTrailing();
        }

        public boolean isEmpty() {
            return line.length() == 0;
        }

        public int numLeadingSpaces() {
            int i = 0;
            while (i < line.length() && line.charAt(i) == ' ')
                i++;
            return i;
        }

        @Override
        public Iterator<WordWithTrailingSpaces> iterator() {
            return new WordIterator(line, numLeadingSpaces());
        }
    }

    static public class OutputBuffer {

        final private PrintWriter out;
        final private int maxLength;
        final private boolean coalesceSpaces;

        private int linePosition = 0;
        private int indent = 0;
        private int pendingSpaces = 0;
        private boolean noOutputYet = true;

        public OutputBuffer(PrintWriter out, int maxLength,
                boolean coalesceSpaces) {
            this.out = out;
            this.coalesceSpaces = coalesceSpaces;
            this.linePosition = 0;
            this.maxLength = maxLength;
            noOutputYet = true;
        }

        public void newParagraph() {
            if (linePosition != 0)
                out.println();
            indent = 0;
            pendingSpaces = 0;
            linePosition = 0;
        }

        public void add(WordWithTrailingSpaces word) {
            if (linePosition == 0) {
                if (!noOutputYet)
                    out.println();
                printSpaces(indent);
                linePosition = indent + word.getWord().length();
                out.print(word.getWord());
                noOutputYet = false;
                pendingSpaces = word.getSpaces(coalesceSpaces);
            } else {
                if (linePosition + pendingSpaces
                        + word.getWord().length() < maxLength) {
                    printSpaces(pendingSpaces);
                    out.print(word.getWord());
                    noOutputYet = false;
                    linePosition += pendingSpaces + word.getWord().length();
                    pendingSpaces = word.getSpaces(coalesceSpaces);
                } else {
                    out.println();
                    printSpaces(indent);
                    out.print(word.getWord());
                    noOutputYet = false;
                    linePosition = indent + word.getWord().length();
                    pendingSpaces = word.getSpaces(coalesceSpaces);
                }
            }
        }

        private void printSpaces(int numSpaces) {
            for (int i = 0; i < numSpaces; ++i)
                out.print(' ');
        }

        public void setIndent(int indent) {
            this.indent = indent;
        }

    }

    void format(BufferedReader in, PrintWriter out) throws IOException {
        int indent = Integer.MAX_VALUE;
        var outputLine = new OutputBuffer(out, maxLength, coalesceSpaces);
        InputLine inputLine;
        while ((inputLine = nextLine(in)) != null) {

            // flush and start new paragraph
            if (inputLine.isEmpty()) {
                outputLine.newParagraph();
            }

            int currentIndent = inputLine.numLeadingSpaces();
            if (currentIndent != indent) {
                indent = currentIndent;
                outputLine.newParagraph();
                outputLine.setIndent(indent);
            }

            for (WordWithTrailingSpaces word : inputLine) {
                outputLine.add(word);
            }
        }

        outputLine.newParagraph();
    }

    private InputLine nextLine(BufferedReader in) throws IOException {
        var line = in.readLine();
        if (line == null)
            return null;
        return new InputLine(line);
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public void setCoalesceSpaces(boolean coalesceSpaces) {
        this.coalesceSpaces = coalesceSpaces;
    }
}
