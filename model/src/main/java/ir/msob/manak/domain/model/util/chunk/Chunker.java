package ir.msob.manak.domain.model.util.chunk;

import lombok.SneakyThrows;
import org.springframework.core.io.InputStreamResource;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Chunker {

    public enum FileType {
        MARKDOWN,
        XML,
        POM, // alias for XML
        JAVA,
        YAML,
        PROPERTIES,
        TYPESCRIPT,
        JSON,
        GENERIC
    }

    @SneakyThrows
    public static List<ChunkFile> chunk(InputStreamResource res, FileType fileType, int chunkSize, int overlap) {
        return chunk(res.getContentAsByteArray(), fileType, chunkSize, overlap);
    }

    public static List<ChunkFile> chunk(byte[] bytes, FileType fileType, int chunkSize, int overlap) {
        return chunk(new String(bytes, StandardCharsets.UTF_8), fileType, chunkSize, overlap);
    }

    public static List<ChunkFile> chunk(String text, FileType fileType, int chunkSize, int overlap) {
        if (chunkSize <= 0)
            throw new IllegalArgumentException("chunkSize must be > 0");
        if (overlap < 0)
            throw new IllegalArgumentException("overlap cannot be negative");

        FileStructureUtil util = getUtilFor(fileType);

        String cleaned = util.preprocessText(text); // now returns original text (no normalization)
        List<Section> sections = util.splitIntoSections(cleaned);

        List<ChunkFile> output = new ArrayList<>();
        long index = 0L;

        boolean lineBased = isLineBased(fileType);

        for (Section section : sections) {
            if (lineBased) {
                List<StringHolder> holders = splitByLinesWithLineNumbers(section.getText(), chunkSize, overlap);
                for (StringHolder sh : holders) {
                    Integer chunkStartLine = section.getStartLine() == null ? null
                            : section.getStartLine() + sh.getRelativeStartLine(); // 1-based
                    Integer chunkEndLine = section.getStartLine() == null ? null
                            : section.getStartLine() + sh.getRelativeEndLine();

                    output.add(ChunkFile.builder()
                            .text(sh.getText())
                            .index(index++)
                            .startLine(chunkStartLine)
                            .endLine(chunkEndLine)
                            .build());
                }
            } else {
                // word-based splitting without line numbers
                List<String> chunks = splitByWords(section.getText(), chunkSize, overlap);
                for (String c : chunks) {
                    output.add(ChunkFile.builder()
                            .text(c)
                            .index(index++)
                            .startLine(null)
                            .endLine(null)
                            .build());
                }
            }
        }

        return output;
    }

    private static boolean isLineBased(FileType fileType) {
        return switch (fileType) {
            case JAVA, TYPESCRIPT, XML, POM, JSON -> true;
            default -> false;
        };
    }

    private static FileStructureUtil getUtilFor(FileType fileType) {
        return switch (fileType) {
            case MARKDOWN -> new MarkdownUtils();
            case XML, POM -> new XmlUtils();
            case JAVA -> new JavaUtils();
            case YAML, PROPERTIES -> new ConfigUtils();
            case TYPESCRIPT -> new TypeScriptUtils();
            case JSON -> new JsonUtils();
            default -> new GenericUtils();
        };
    }

    private static List<String> splitByWords(String text, int chunkSize, int overlap) {
        String[] words = text.trim().split("\\s+");
        List<String> chunks = new ArrayList<>();
        if (words.length == 0) return chunks;

        int step = Math.max(1, chunkSize - overlap);

        for (int start = 0; start < words.length; start += step) {
            int end = Math.min(words.length, start + chunkSize);
            chunks.add(String.join(" ", java.util.Arrays.copyOfRange(words, start, end)));
            if (end >= words.length) break;
        }

        return chunks;
    }

    private static class StringHolder {
        private final String text;
        private final int relativeStartLine; // 0-based relative to section
        private final int relativeEndLine;   // 0-based relative to section

        public StringHolder(String text, int relativeStartLine, int relativeEndLine) {
            this.text = text;
            this.relativeStartLine = relativeStartLine;
            this.relativeEndLine = relativeEndLine;
        }

        public String getText() {
            return text;
        }

        public int getRelativeStartLine() {
            return relativeStartLine;
        }

        public int getRelativeEndLine() {
            return relativeEndLine;
        }
    }

    private static List<StringHolder> splitByLinesWithLineNumbers(String sectionText, int chunkLines, int overlapLines) {
        String[] lines = sectionText.split("\\R", -1); // keep trailing empty lines
        List<StringHolder> out = new ArrayList<>();
        if (lines.length == 0) return out;

        int step = Math.max(1, chunkLines - overlapLines);

        for (int start = 0; start < lines.length; start += step) {
            int end = Math.min(lines.length, start + chunkLines);
            StringBuilder sb = new StringBuilder();
            for (int i = start; i < end; i++) {
                sb.append(lines[i]);
                if (i < end - 1) sb.append("\n");
            }
            out.add(new StringHolder(sb.toString(), start, end - 1));
            if (end >= lines.length) break;
        }
        return out;
    }
}
