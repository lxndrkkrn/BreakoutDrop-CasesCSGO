package org.example.breakoutdrop.Controllers.User;

import lombok.RequiredArgsConstructor;
import org.example.breakoutdrop.DTOs.Sell.SellAllSkinsDTO;
import org.example.breakoutdrop.DTOs.Sell.SellSkinDTO;
import org.example.breakoutdrop.DTOs.Sell.WithdrawSkinDTO;
import org.example.breakoutdrop.Services.ApplicationServices.SalesService;
import org.example.breakoutdrop.Services.ApplicationServices.WithdrawSkinService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/breakout-drop/sale")
@RequiredArgsConstructor

public class SaleController {

    private final SalesService salesService;
    private final WithdrawSkinService withdrawSkinService;

    @PostMapping("/skin")
    public ResponseEntity<?> sellSkin(@RequestBody SellSkinDTO sellSkinDTO) {
        salesService.sellSkin(sellSkinDTO);

        return ResponseEntity.accepted().build();
    }

    @PostMapping("/skin/all-skins")
    public ResponseEntity<?> sellAllSkin(@RequestBody SellAllSkinsDTO sellAllSkinsDTO) {
        salesService.sellAllSkins(sellAllSkinsDTO);

        return ResponseEntity.accepted().build();
    }

    @PostMapping("/skin/withdraw")
    public ResponseEntity<?> withdrawSkin(@RequestBody WithdrawSkinDTO withdrawSkinDTO) {
        withdrawSkinService.withdrawSkin(withdrawSkinDTO);

        return ResponseEntity.accepted().build();
    }

}
