package ir.msob.manak.domain.model.util.chunk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlUtils implements FileStructureUtil {

    // find tag openings like <tag ...> or </tag ...>
    private static final Pattern TAG_START = Pattern.compile("(?=<\\/?[A-Za-z_][\\w:\\-\\.]*\\b)");

    @Override
    public String preprocessText(String text) {
        return text == null ? "" : text;
    }

    @Override
    public List<Section> splitIntoSections(String text) {
        if (text == null || text.isBlank()) return Collections.emptyList();

        List<Section> out = new ArrayList<>();
        Matcher m = TAG_START.matcher(text);

        List<Integer> starts = new ArrayList<>();
        while (m.find()) {
            starts.add(m.start());
        }

        if (starts.isEmpty()) {
            out.add(new Section(text, computeLineFromIndex(text, 0)));
            return out;
        }

        for (int i = 0; i < starts.size(); i++) {
            int start = starts.get(i);
            int end = (i + 1 < starts.size()) ? starts.get(i + 1) : text.length();
            String part = text.substring(start, end);
            int line = computeLineFromIndex(text, start);
            out.add(new Section(part, line));
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
