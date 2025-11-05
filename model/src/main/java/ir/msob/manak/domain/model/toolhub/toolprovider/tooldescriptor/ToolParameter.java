package ir.msob.manak.domain.model.toolhub.toolprovider.tooldescriptor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.List;
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
    @NotNull
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
     * Can be any Object type depending on {@link #type}.
     * <p>
     * Example:
     * - For a string parameter: "defaultValue" = "N/A"
     * - For a number parameter: "defaultValue" = 0
     */
    private Object defaultValue;

    /**
     * A list of example values that illustrate how this parameter
     * might appear in actual request or response data.
     * <p>
     * This field is primarily used for documentation and example payload
     * generation (e.g., in OpenAPI specifications or tool descriptors).
     * Each item in the list represents a possible example value for this parameter.
     * </p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * examples = ["John Doe"]
     * examples = [1, 2, 3]
     * examples = ["application/json", "text/plain"]
     * </pre>
     */
    @Singular
    private List<Object> examples;

    /**
     * Indicates whether this parameter is required in the context where it is used.
     * <p>
     * Example:
     * required = true → must be present in the request or input data.
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
     * type = "OBJECT"
     * properties = {
     * "name": { type = "STRING" },
     * "age":  { type = "NUMBER" }
     * }
     */
    @Singular
    private Map<String, ToolParameter> properties;

    /**
     * The minimum numeric value allowed for NUMBER type parameters.
     * <p>
     * Example:
     * type = "NUMBER"
     * minimum = 0 → Only non-negative numbers are valid.
     */
    private Long minimum;

    /**
     * The maximum numeric value allowed for NUMBER type parameters.
     * <p>
     * Example:
     * type = "NUMBER"
     * maximum = 100 → Value must be less than or equal to 100.
     */
    private Long maximum;

    /**
     * The minimum length of the value for STRING type parameters.
     * <p>
     * Example:
     * type = "STRING"
     * minLength = 3 → String must contain at least 3 characters.
     */
    private Integer minLength;

    /**
     * The maximum length of the value for STRING type parameters.
     * <p>
     * Example:
     * type = "STRING"
     * maxLength = 255 → String must contain at most 255 characters.
     */
    private Integer maxLength;

    /**
     * A regular expression pattern the STRING value must match.
     * <p>
     * Example:
     * pattern = "^[A-Za-z0-9_-]+$" → Allows only alphanumeric characters, underscores, and hyphens.
     */
    private String pattern;

    /**
     * A list of allowed constant values for the parameter.
     * Similar to an enumeration.
     * <p>
     * Example:
     * enumValues = ["ASC", "DESC"]
     */
    @Singular
    private List<Object> enumValues;

    /**
     * Indicates whether the parameter value can be null.
     * <p>
     * Example:
     * nullable = true → null values are accepted as valid input.
     */
    private Boolean nullable;

    /**
     * Enumeration defining supported parameter types.
     * Used to represent the structural nature of a parameter.
     */
    public enum ToolParameterType {
        STRING, NUMBER, BOOLEAN, OBJECT, ARRAY
    }
}
