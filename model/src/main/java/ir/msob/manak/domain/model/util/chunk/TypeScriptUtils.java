package ir.msob.manak.domain.model.util.chunk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TypeScriptUtils implements FileStructureUtil {

    // detect export declarations at line start
    private static final Pattern EXPORT_DECL = Pattern.compile("(?m)^\\s*export\\s+(default\\s+)?(class|function|const|let|type|interface)\\b.*");

    @Override
    public String preprocessText(String text) {
        return text == null ? "" : text;
    }

    @Override
    public List<Section> splitIntoSections(String text) {
        if (text == null || text.isBlank()) return Collections.emptyList();

        List<Section> out = new ArrayList<>();
        Matcher m = EXPORT_DECL.matcher(text);

        List<Integer> starts = new ArrayList<>();
        while (m.find()) {
            starts.add(m.start());
        }

        if (starts.isEmpty()) {
            // fallback: whole file as single section with line 1
            out.add(new Section(text, 1));
            return out;
        }

        for (int i = 0; i < starts.size(); i++) {
            int s = starts.get(i);
            int e = (i + 1 < starts.size()) ? starts.get(i + 1) : text.length();
            String part = text.substring(s, e);
            int line = computeLineFromIndex(text, s);
            out.add(new Section(part, line));
        }

        // include any prefix before first export as a section without a line (optional)
        int first = starts.get(0);
        if (first > 0) {
            String prefix = text.substring(0, first);
            if (!prefix.isBlank()) {
                out.add(0, new Section(prefix, null));
            }
        }

        return out;
    }

    private int computeLineFromIndex(String text, int index) {
        if (index <= 0) return 1;
        int count = 0;
        for (int i = 0; i < Math.min(index, text.length()); i++) {
            if (text.charAt(i) == '\n') count++;
        }
        return count + 1;
    }
}
