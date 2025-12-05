package ir.msob.manak.domain.model.util.chunk;

import java.util.List;

public interface FileStructureUtil {
    /**
     * Preprocess the raw content. In this variant we DO NOT change line counts:
     * This implementation should normally return the original text unchanged.
     */
    String preprocessText(String text);

    /**
     * Split the (preprocessed) text into logical sections.
     * Each Section contains the section text and the starting line number (1-based) or null.
     */
    List<Section> splitIntoSections(String preprocessedText);
}
