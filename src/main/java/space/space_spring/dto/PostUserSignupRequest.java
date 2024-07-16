package space.space_spring.dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostUserSignupRequest {

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식에 맞지 않습니다.")     // 이메일 정규표현식 확인 필요함
    private String email;

    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}$",
            message = "8~16글자의 영문 대/소문자, 숫자, 특수문자가 포함되어야 합니다."
    )
    private String password;

    @Length(min = 1, max = 10, message = "이름은 10자이내의 문자열이어야 합니다.")
    private String userName;
}
