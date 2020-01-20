package com.mofit.orch.endpoints;

import com.mofit.mainmofitapiservice.models.LoginUserRequest;
import com.mofit.mainmofitapiservice.models.SignUserResponse;
import com.mofit.mainmofitapiservice.models.SignupUserRequest;
import com.mofit.orch.services.api.IUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/users")
//@PreAuthorize("hasAuthority('CITY_MODULE: READ')")
public class UserController {

    private IUserService userService;

    @Autowired
    public UserController(final IUserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Creates new User")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public SignUserResponse createNewUser(@RequestBody @Valid SignupUserRequest request) {
        return userService.createNewUser(request);
    }

    @ApiOperation(value = "Login User")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public SignUserResponse loginUser(@RequestBody @Valid LoginUserRequest loginUserRequest) {
        return userService.loginUser(loginUserRequest);
    }

}