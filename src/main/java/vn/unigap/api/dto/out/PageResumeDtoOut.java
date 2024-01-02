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
public class PageResumeDtoOut {
    private Long id;
    private Long seekerId;
    private String seekerName;
    private String careerObj;
    private String title;
    private Integer salary;

    public static PageResumeDtoOut from(Resume resume){
        return PageResumeDtoOut.builder()
                .id(resume.getId())
                .seekerId(resume.getSeeker_id())
                .careerObj(resume.getCareer_obj())
                .title(resume.getTitle())
                .seekerName("Default name")
                .salary(resume.getSalary())
                .build();
    }
}
