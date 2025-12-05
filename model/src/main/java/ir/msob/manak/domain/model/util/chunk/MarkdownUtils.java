package ir.msob.manak.domain.model.util.chunk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkdownUtils {

    private static final Pattern FRONTMATTER =
            Pattern.compile("^---\\s*$(.*?)^---\\s*$", Pattern.MULTILINE | Pattern.DOTALL);

    public static String stripFrontMatter(String content) {
        Matcher m = FRONTMATTER.matcher(content);
        if (m.find()) {
            return content.substring(m.end()).trim();
        }
        return content.trim();
    }

    public static List<String> splitIntoSections(String text) {
        if (text == null || text.isBlank())
            return Collections.emptyList();

        String[] parts = text.split("\n(?=#+ )"); // split before any heading
        List<String> out = new ArrayList<>();

        for (String p : parts) {
            String trimmed = p.trim();
            if (!trimmed.isEmpty())
                out.add(trimmed);
        }
        return out;
    }
}
