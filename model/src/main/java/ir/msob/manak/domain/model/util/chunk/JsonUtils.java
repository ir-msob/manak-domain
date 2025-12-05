package ir.msob.manak.domain.model.util.chunk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JsonUtils implements FileStructureUtil {

    @Override
    public String preprocessText(String text) {
        return text == null ? "" : text;
    }

    @Override
    public List<Section> splitIntoSections(String text) {
        if (text == null || text.isBlank()) return Collections.emptyList();

        String t = text.trim();
        List<Section> out = new ArrayList<>();

        if (t.startsWith("{") && t.endsWith("}")) {
            // crude parse to find top-level key/value boundaries
            int depth = 0;
            int last = indexOfFirstNonWhitespace(text, 0) + 1; // after '{'
            if (last <= 0) last = 1;
            for (int i = 1; i < text.length() - 1; i++) {
                char c = text.charAt(i);
                if (c == '{' || c == '[') depth++;
                else if (c == '}' || c == ']') depth--;
                else if (c == ',' && depth == 0) {
                    String part = text.substring(last, i).trim();
                    if (!part.isEmpty()) {
                        int startChar = last;
                        int startLine = computeLineFromIndex(text, startChar);
                        out.add(new Section(part, startLine));
                    }
                    last = i + 1;
                }
            }
            String lastPart = text.substring(last, text.length() - 1).trim();
            if (!lastPart.isEmpty()) {
                int startLine = computeLineFromIndex(text, last);
                out.add(new Section(lastPart, startLine));
            }
            if (out.isEmpty()) out.add(new Section(text, 1));
            return out;
        }

        if (t.startsWith("[") && t.endsWith("]")) {
            int depth = 0;
            int last = indexOfFirstNonWhitespace(text, 0) + 1;
            for (int i = 1; i < text.length() - 1; i++) {
                char c = text.charAt(i);
                if (c == '{' || c == '[') depth++;
                else if (c == '}' || c == ']') depth--;
                else if (c == ',' && depth == 0) {
                    String part = text.substring(last, i).trim();
                    if (!part.isEmpty()) {
                        int startLine = computeLineFromIndex(text, last);
                        out.add(new Section(part, startLine));
                    }
                    last = i + 1;
                }
            }
            String lastPart = text.substring(last, text.length() - 1).trim();
            if (!lastPart.isEmpty()) {
                int startLine = computeLineFromIndex(text, last);
                out.add(new Section(lastPart, startLine));
            }
            if (out.isEmpty()) out.add(new Section(text, 1));
            return out;
        }

        // fallback
        return Collections.singletonList(new Section(text, 1));
    }

    private int computeLineFromIndex(String text, int index) {
        if (index <= 0) return 1;
        int count = 0;
        for (int i = 0; i < Math.min(index, text.length()); i++) {
            if (text.charAt(i) == '\n') count++;
        }
        return count + 1;
    }

    private int indexOfFirstNonWhitespace(String s, int from) {
        int i = from;
        while (i < s.length() && Character.isWhitespace(s.charAt(i))) i++;
        return i >= s.length() ? s.length() : i;
    }
}
