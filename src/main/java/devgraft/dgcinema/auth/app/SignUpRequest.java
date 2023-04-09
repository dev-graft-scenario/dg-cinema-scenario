package devgraft.dgcinema.auth.app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SignUpRequest {
    private String email;
    private String password;
    private String phone;
}
