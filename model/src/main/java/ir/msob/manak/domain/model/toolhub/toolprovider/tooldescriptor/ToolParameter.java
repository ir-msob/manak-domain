package ir.msob.manak.domain.model.toolhub.toolprovider.tooldescriptor;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;
import java.util.Map;

/**
 * Represents a parameter definition used to describe complex JSON structures.
 * <p>
 * This model is inspired by JSON Schema and OpenAPI parameter structures,
 * allowing it to represent any nested or hierarchical data definition that
 * can be understood both by humans and AI systems.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToolParameter implements Serializable {

    /**
     * The data type of the parameter.
     * Supported values: STRING, NUMBER, BOOLEAN, OBJECT, ARRAY.
     * <p>
     * Example:
     * - "STRING"  → A single string value
     * - "ARRAY"   → A list of values (defined by "items")
     * - "OBJECT"  → A structured value (defined by "properties")
     */
    @NotBlank
    private ToolParameterType type;

    /**
     * A human-readable description of what this parameter represents.
     * Helps both developers and AI models understand the semantic meaning
     * of the field.
     */
    @NotBlank
    private String description;

    /**
     * The default value to use when the parameter is not provided.
     */
    private Serializable defaultValue;

    /**
     * An example value illustrating how this parameter might look in real data.
     */
    private Serializable example;

    /**
     * Indicates whether this parameter is required in the context where it is used.
     */
    private boolean required;

    /**
     * Describes the structure or type of each item in an array.
     * <p>
     * Used only when type = "ARRAY".
     * Example:
     * type = "ARRAY"
     * items = { type = "STRING" }
     * represents a list of strings.
     */
    private ToolParameter items;

    /**
     * Describes the properties of an object when type = "OBJECT".
     * Each key in this map represents a field name, and the corresponding value
     * is another ToolParameter defining that field’s structure.
     * <p>
     * Example:
     * type = "object"
     * properties = {
     * "name": { type = "STRING" },
     * "age": { type = "NUMBER" }
     * }
     */
    @Singular
    private Map<String, ToolParameter> properties;

    public enum ToolParameterType {
        STRING, NUMBER, BOOLEAN, OBJECT, ARRAY
    }
}
