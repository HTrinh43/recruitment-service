package vn.unigap.api.dto.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.unigap.api.entity.Seeker;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeekerDtoOut {
    private Long id;
    private String birthday;
    private String address;
    private Integer provinceId;
    private String provinceName;

    public static SeekerDtoOut from(Seeker seeker){
        return SeekerDtoOut.builder()
                .id(seeker.getId())
                .birthday(seeker.getBirthday())
                .address(seeker.getAddress())
                .provinceId(seeker.getProvince())
                .build();
    }
}
