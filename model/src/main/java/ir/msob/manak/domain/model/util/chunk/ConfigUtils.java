package ir.msob.manak.domain.model.util.chunk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConfigUtils implements FileStructureUtil {

    @Override
    public String preprocessText(String text) {
        return text == null ? "" : text;
    }

    @Override
    public List<Section> splitIntoSections(String text) {
        if (text == null || text.isBlank()) return Collections.emptyList();

        // split by blank lines into groups; we won't provide line numbers for these (null)
        String[] parts = text.split("(?m)\\n\\s*\\n");
        List<Section> out = new ArrayList<>();
        for (String p : parts) {
            if (!p.isBlank()) {
                out.add(new Section(p, null));
            }
        }
        if (out.isEmpty()) out.add(new Section(text, null));
        return out;
    }
}
