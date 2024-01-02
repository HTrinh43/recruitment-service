package vn.unigap.api.dto.in;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateJobDtoIn {
    @NotNull
    private Long id;
    @NotEmpty
    private String title;
    @NotNull
    private int employerId;
    @NotNull
    private int quantity;
    @NotEmpty
    private String description;
    @NotNull
    private String fieldIds;
    @NotNull
    private String provinceIds;
    @NotNull
    private int salary;
    @NotNull
    private Date expiredAt;

}
