package codex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import org.junit.Test;

import codex.Fmt.InputLine;
import codex.Fmt.OutputBuffer;

public class Fmt2Test {
    String lorumIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent at eros eget ex fringilla dictum vel a massa. Morbi pulvinar sem nisl, mattis elementum neque consequat et. Sed id sagittis ipsum, in lobortis turpis. Integer mauris justo, feugiat nec odio vel, bibendum interdum sem. Proin feugiat sagittis consequat. Cras non rutrum purus. Vestibulum elementum, mauris quis mattis efficitur, mi libero consectetur tortor, vel lacinia nisl nunc ut tellus. Phasellus non diam consequat, consectetur tortor at, accumsan ex. Vestibulum gravida arcu et nulla dignissim commodo. Nullam at mi et metus consectetur bibendum eu sit amet tortor. Donec aliquam dignissim dolor, sed mollis libero lobortis a. Integer in est eleifend, congue mauris vitae, commodo tellus. Aliquam interdum lectus nisl, non volutpat nulla viverra ac. Phasellus suscipit lorem sed tellus vestibulum fermentum. Phasellus consequat, sem nec vestibulum condimentum, orci nunc tempus mi, a hendrerit lorem neque id mi.\r\n"
            + "\r\n"
            + "\r\n"
            + "Suspendisse accumsan quis felis ac posuere. Maecenas ac dictum dui, aliquet mattis ligula. Curabitur in consectetur leo, vitae cursus metus. Sed aliquam nunc maximus est rutrum, malesuada rutrum libero luctus. Proin vel elit libero. Aliquam erat volutpat. Nam nibh odio, vestibulum in erat ac, hendrerit mattis tortor. Morbi fermentum facilisis turpis ac gravida. Nam at purus justo.\r\n"
            + "\r\n"
            + "Maecenas quis porttitor risus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Mauris a gravida mi. Maecenas suscipit mi vitae suscipit eleifend. Suspendisse a eros quis lorem molestie commodo quis sit amet nulla. Pellentesque accumsan quam eu auctor scelerisque. Donec tincidunt vel augue vitae tristique. Cras eu euismod enim, a aliquet ligula.\r\n"
            + "\r\n"
            + "Quisque sit amet accumsan ex. In cursus interdum varius. Cras eu rhoncus libero. Integer in pharetra dolor. Mauris nec finibus augue, in pulvinar enim. Sed id rhoncus diam, vitae bibendum ipsum. Curabitur tempor posuere hendrerit. Maecenas elementum sodales justo, vel blandit massa volutpat id. Nunc sit amet est in lectus maximus malesuada eu vel sapien. Duis rutrum gravida dolor, at condimentum justo. Nunc euismod nunc vitae magna mollis, at iaculis ante fringilla. Proin imperdiet finibus risus, non imperdiet justo interdum et. Vestibulum tristique nec diam a commodo. Aenean viverra leo at tellus luctus, sed suscipit dui dictum. Nam nisl erat, consectetur at laoreet quis, dapibus ac nunc.\r\n"
            + "\r\n"
            + "Curabitur elit lectus, lacinia a hendrerit et, accumsan quis mi. Nullam vestibulum ligula scelerisque, facilisis ipsum sed, dignissim arcu. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Curabitur mauris nulla, pulvinar porta tincidunt id, elementum at est. Vivamus rhoncus orci quam, ut elementum justo sagittis vel. Sed bibendum leo sed lacus sollicitudin, id vestibulum massa rhoncus. Aliquam erat volutpat. Proin ultrices dolor quis ante cursus pretium. Ut vel scelerisque magna, a placerat lectus.\r\n"
            + "\r\n"
            + "Generated 5 paragraphs, 455 words, 3083 bytes of Lorem Ipsum";

    @Test
    public void test() throws IOException {
        StringWriter outString = new StringWriter();
        OutputBuffer outLine = new Fmt.OutputBuffer(new PrintWriter(outString),
                40, false);
        outLine.add(new Fmt.WordWithTrailingSpaces("mark", 1));
        outLine.add(new Fmt.WordWithTrailingSpaces("mark", 1));
        outLine.add(new Fmt.WordWithTrailingSpaces("mark", 1));
        outLine.add(new Fmt.WordWithTrailingSpaces("mark", 1));
        for (int i = 0; i < 100; ++i)
            outLine.add(new Fmt.WordWithTrailingSpaces("mark", 1));
        outLine.newParagraph();
        outLine.setIndent(4);
        outLine.add(new Fmt.WordWithTrailingSpaces("mark", 1));
        for (int i = 0; i < 100; ++i)
            outLine.add(new Fmt.WordWithTrailingSpaces("mark", 1));
        System.out.println(outString.toString());
    }

    @Test
    public void testCanParseLine() throws Exception {
        InputLine inputLine = new Fmt.InputLine(
                "hello world this is mark and I am great");
        for (var word : inputLine)
            System.out.println(word.getWord() + ":" + word.getSpaces(false));
    }

    @Test
    public void testLoremIpsum() throws Exception {
        StringWriter outString = new StringWriter();
        new Fmt().format(new BufferedReader(new StringReader(lorumIpsum)),
                new PrintWriter(outString));
        System.out.println("--");
        System.out.print(outString.toString());
        System.out.println("--");
    }
}
