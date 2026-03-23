package org.example.breakoutdrop.Controllers.User;

import lombok.RequiredArgsConstructor;
import org.example.breakoutdrop.Services.ApplicationServices.OpenCaseService;
import org.example.breakoutdrop.Services.ApplicationServices.ReplenishmentOfBalanceService;
import org.example.breakoutdrop.Services.DomainServices.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@CrossOrigin("*")
@RequestMapping("/breakout-drop/balance")
@RequiredArgsConstructor

public class BalanceController {

    private final OpenCaseService openCaseService;
    private final UserService userService;
    private ReplenishmentOfBalanceService replenishmentOfBalanceService;

    @PatchMapping("/set-balance/{id}")
    public ResponseEntity<?> setBalance(@PathVariable Long id, @RequestBody BigDecimal balance) {
        userService.setBalanceToUser(id, balance);

        return ResponseEntity.accepted().build();
    }

    @PostMapping("/add-balance/{id}")
    public ResponseEntity<?> addBalance(@PathVariable Long id, @RequestBody BigDecimal balance) {
        userService.addBalanceToUser(id, balance);

        return ResponseEntity.accepted().build();
    }

    @PostMapping("/take-balance/{id}")
    public ResponseEntity<?> takeBalance(@PathVariable Long id, @RequestBody BigDecimal balance) {
        userService.takeBalanceToUser(id, balance);

        return ResponseEntity.accepted().build();
    }

    @PostMapping("/p2p-add-balance/{id}")
    public ResponseEntity<?> p2pAddBalance(@PathVariable Long id, @RequestBody BigDecimal balance) {
        replenishmentOfBalanceService.p2pAddBalance(id, balance);

        return ResponseEntity.accepted().build();
    }

}
