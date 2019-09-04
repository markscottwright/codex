package codex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

import com.vladsch.flexmark.ast.Heading;
import com.vladsch.flexmark.ext.definition.DefinitionExtension;
import com.vladsch.flexmark.ext.definition.DefinitionItem;
import com.vladsch.flexmark.ext.definition.DefinitionList;
import com.vladsch.flexmark.ext.definition.DefinitionTerm;
import com.vladsch.flexmark.ext.wikilink.WikiLink;
import com.vladsch.flexmark.ext.wikilink.WikiLinkExtension;
import com.vladsch.flexmark.ext.wikilink.WikiNode;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.Parser.Builder;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import com.vladsch.flexmark.util.data.MutableDataSet;

public class MarkdownParsingTest {
    @Test
    public void test() throws FileNotFoundException, IOException {
        MutableDataHolder options = new MutableDataSet().set(Parser.EXTENSIONS,
                Arrays.asList(DefinitionExtension.create(),
                        WikiLinkExtension.create()));

        Builder builder = Parser.builder(options);
        builder.set(WikiLinkExtension.ALLOW_INLINES, true);
        Parser build = builder.build();

        Document document = build.parseReader(
                new FileReader(new File("projectdoc/designnotes.md")));
        for (Heading h = (Heading) document
                .getChildOfType(Heading.class); h != null; h = (Heading) h
                        .getNextAny(Heading.class)) {
            System.out.println(h.getLevel() + ":" + h.getText().toString());
        }

        document.getChildren().forEach(c -> {
            if (c instanceof DefinitionList) {
                ((DefinitionList) c).getChildren().forEach(d -> {
                    if (d instanceof DefinitionTerm)
                        System.out.print(((DefinitionTerm) d).getChars());
                    else
                        System.out.println(
                                "  " + ((DefinitionItem) d).getChars());
                });
            }
        });

        document.getChildren().forEach(c -> {
            if (c instanceof WikiNode) {
                System.out.println(((WikiLink) c).getLink());
            }
        });
    }

}
