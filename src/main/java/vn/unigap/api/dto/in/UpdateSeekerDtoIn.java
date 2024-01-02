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
public class UpdateSeekerDtoIn {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String birthday;
    private String address;
    @NotNull
    private Integer provinceId;
}
