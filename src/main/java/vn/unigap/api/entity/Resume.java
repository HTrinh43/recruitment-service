package vn.unigap.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="resume",schema = "job_db")
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long seeker_id;
    private String career_obj;
    private String title;
    private Integer salary;
    private String fields;
    private String provinces;
    private Date create_at= new Date();
    private Date updated_at= new Date();
}
