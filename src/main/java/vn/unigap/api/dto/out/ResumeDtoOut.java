package vn.unigap.api.dto.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.unigap.api.entity.Resume;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResumeDtoOut {
    private Long id;
    private Long seekerId;
    private String seekerName;
    private String careerObj;
    private String title;
    private Integer salary;
    private String fields;
    private String provinces;

    public static ResumeDtoOut from(Resume resume){
        return ResumeDtoOut.builder()
                .id(resume.getId())
                .seekerId(resume.getSeeker_id())
                .careerObj(resume.getCareer_obj())
                .title(resume.getTitle())
                .seekerName("Default name")
                .salary(resume.getSalary())
                .fields(resume.getFields())
                .provinces(resume.getProvinces())
                .build();
    }
}
