package ir.msob.manak.domain.model.util.chunk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JavaUtils implements FileStructureUtil {

    @Override
    public String preprocessText(String text) {
        // no normalization — return original
        return text == null ? "" : text;
    }

    @Override
    public List<Section> splitIntoSections(String text) {
        if (text == null || text.isBlank()) return Collections.emptyList();

        String[] lines = text.split("\\R", -1); // keep trailing empty lines
        List<Section> sections = new ArrayList<>();

        int sectionStartLine = 1;
        StringBuilder sb = new StringBuilder();
        boolean first = true;

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            boolean isDeclaration = line.matches("\\s*(public|protected|private)?\\s*(class|interface|enum)\\b.*");
            if (isDeclaration && !first) {
                // close previous section
                sections.add(new Section(sb.toString(), sectionStartLine));
                sb = new StringBuilder();
                sectionStartLine = i + 1; // 1-based
            }
            if (sb.length() > 0) sb.append("\n");
            sb.append(line);
            first = false;
        }
        if (sb.length() > 0) {
            sections.add(new Section(sb.toString(), sectionStartLine));
        }

        return sections;
    }
}
