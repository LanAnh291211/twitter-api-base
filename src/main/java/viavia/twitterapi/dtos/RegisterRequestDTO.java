package viavia.twitterapi.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterRequestDTO {
    private String firstName;
    private String email;
    private String password;
    private String picturePath;
}
