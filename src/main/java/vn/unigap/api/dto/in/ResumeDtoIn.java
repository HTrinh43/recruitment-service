package vn.unigap.api.dto.in;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResumeDtoIn {
    @NotNull
    private Long seekerId;
    @NotNull
    private String careerObj;
    @NotNull
    private String title;
    @NotNull
    private Integer salary;
    @NotNull
    private String fieldIds;
    @NotNull
    private String provinceIds;
}
