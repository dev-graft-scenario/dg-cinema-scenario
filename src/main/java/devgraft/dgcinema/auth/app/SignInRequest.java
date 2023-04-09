package devgraft.dgcinema.auth.app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SignInRequest {
    private String email;
    private String password;
}
