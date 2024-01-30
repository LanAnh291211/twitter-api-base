package viavia.twitterapi.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDTO {
    private Integer userId;
    private String firstName;
    private String email;
    private String picturePath;
}
