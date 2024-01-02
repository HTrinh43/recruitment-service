package vn.unigap.api.dto.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.unigap.api.entity.Job;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobDtoOut {
    private Long id;
    private String title;
    private int employerId;
    private int quantity;
    private String description;
    private String fields;
    private String provinces;
    private int salary;
    private Date expiredAt;
    private String employerName;

    public static JobDtoOut from(Job j){
        return JobDtoOut.builder()
                .id(j.getId())
                .title(j.getTitle())
                .employerId(j.getEmployer_id())
                .quantity(j.getQuantity())
                .description(j.getDescription())
                .fields(j.getFields())
                .provinces(j.getProvinces())
                .salary(j.getSalary())
                .expiredAt(j.getExpired_at())
                .build();
    }
}
