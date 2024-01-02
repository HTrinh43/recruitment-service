package vn.unigap.api.dto.in;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PageSeekerDtoIn {
    @NotNull
    @Min(value = 1)
    private Integer page = 1;

    @NotNull
    @Min(value = 1)
    @Max(value = 500)
    private Integer pageSize = 10;

    @NotNull
    private Integer provinceId = -1;
}
