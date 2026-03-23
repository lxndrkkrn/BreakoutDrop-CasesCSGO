package org.example.breakoutdrop.Controllers.Game;

import lombok.RequiredArgsConstructor;
import org.example.breakoutdrop.DTOs.Open.OpeningUpgradeDTO;
import org.example.breakoutdrop.Entities.Skin;
import org.example.breakoutdrop.Services.ApplicationServices.UpgradeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/breakout-drop/upgrade")
@RequiredArgsConstructor

public class UpgradeController {

    private final UpgradeService upgradeService;

    @PostMapping()
    public ResponseEntity<?> upgradeSkin(@RequestBody OpeningUpgradeDTO openingUpgradeDTO) {
        Skin wonSkin = upgradeService.upgradeSkin(openingUpgradeDTO);

        return ResponseEntity.ok(wonSkin);
    }

}
