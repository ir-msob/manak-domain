package ir.msob.manak.domain.model.workflow.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataRequirement implements Serializable {
    private List<ResourceContent> resourceContents = new ArrayList<>();
    private List<ResourceOverview> resourceOverviews = new ArrayList<>();
}
