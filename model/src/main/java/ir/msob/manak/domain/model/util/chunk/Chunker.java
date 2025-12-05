package ir.msob.manak.domain.model.util.chunk;

import lombok.SneakyThrows;
import org.springframework.core.io.InputStreamResource;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Chunker {

    private static String preprocessText(String text, FileType fileType) {
        return switch (fileType) {
            case MARKDOWN -> MarkdownUtils.stripFrontMatter(text);
        };
    }

    private static List<String> extractSections(String text, FileType fileType) {
        return switch (fileType) {
            case MARKDOWN -> MarkdownUtils.splitIntoSections(text);
        };
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

        String cleaned = preprocessText(text, fileType);
        List<String> sections = extractSections(cleaned, fileType);

        List<ChunkFile> output = new ArrayList<>();
        long index = 0L;

        for (String section : sections) {
            List<String> sectionChunks = splitByWords(section, chunkSize, overlap);
            for (String chunk : sectionChunks)
                output.add(new ChunkFile(chunk, index++));
        }

        return output;
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

    public enum FileType {
        MARKDOWN
    }
}
