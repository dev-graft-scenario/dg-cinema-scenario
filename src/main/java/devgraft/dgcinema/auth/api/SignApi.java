package devgraft.dgcinema.auth.api;

import devgraft.dgcinema.auth.app.SignInRequest;
import devgraft.dgcinema.auth.app.SignUpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RequestMapping("users")
@RestController
public class SignApi {

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("sign-up")
    void signUp(@RequestBody final SignUpRequest request) {

    }

    @PostMapping("sign-in")
    void signIn(@RequestBody final SignInRequest request, final HttpServletResponse response) {
    }
}
