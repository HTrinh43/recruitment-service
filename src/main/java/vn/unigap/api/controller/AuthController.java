package vn.unigap.api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.unigap.api.dto.in.AuthLoginDtoIn;
import vn.unigap.api.dto.out.AuthLoginDtoOut;
import vn.unigap.api.service.AuthService;

@RestController
@RequestMapping(value = "/auth", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Auth", description = "Auth")
public class AuthController extends AbstractResponseController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthLoginDtoIn loginDtoIn) {
        return responseEntity(() -> {
            return this.authService.login(loginDtoIn);
        }, 201, false);
    }

    private static class ResponseLogin extends vn.unigap.api.common.response.ApiResponse<AuthLoginDtoOut> {
    }

}