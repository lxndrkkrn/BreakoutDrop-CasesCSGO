package org.example.breakoutdrop.Controllers.User;

import lombok.RequiredArgsConstructor;
import org.example.breakoutdrop.DTOs.Create.CreateUserDTO;
import org.example.breakoutdrop.Entities.User;
import org.example.breakoutdrop.Services.ApplicationServices.OpenCaseService;
import org.example.breakoutdrop.Services.DomainServices.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/breakout-drop/user")
@RequiredArgsConstructor

public class UserController {

    private final OpenCaseService openCaseService;
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody CreateUserDTO createUserDTO) {
        User user = userService.createUser(createUserDTO);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestBody Long id) {
        userService.deleteUser(id);

        return ResponseEntity.accepted().build();
    }

    @PatchMapping("/change-tradeURL/{id}")
    public ResponseEntity<?> changeTradeURL(@PathVariable Long id, @RequestBody String tradeURL) {
        userService.changeTradeURL(id, tradeURL);

        return ResponseEntity.accepted().build();
    }

    @PatchMapping("/change-password/{id}")
    public ResponseEntity<?> changePassword(@PathVariable Long id, @RequestBody String password) {
        userService.changePassword(id, password);

        return ResponseEntity.accepted().build();
    }

    @PatchMapping("/change-Email/{id}")
    public ResponseEntity<?> changeEmail(@PathVariable Long id, @RequestBody String email) {
        userService.changeEmail(id, email);

        return ResponseEntity.accepted().build();
    }

}
