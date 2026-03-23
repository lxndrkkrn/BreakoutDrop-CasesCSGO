package org.example.breakoutdrop.Controllers.System;

import lombok.RequiredArgsConstructor;
import org.example.breakoutdrop.DTOs.Create.CreateSkinDTO;
import org.example.breakoutdrop.Entities.Skin;
import org.example.breakoutdrop.Services.DomainServices.SkinService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/breakout-drop/skin")
@RequiredArgsConstructor

public class SkinController {

    private final SkinService skinService;

    @PostMapping("/create")
    public ResponseEntity<?> createSkin(@RequestBody CreateSkinDTO createSkinDTO) {
        Skin skin = skinService.createSkin(createSkinDTO);

        return ResponseEntity.ok(skin);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteSkin(@RequestBody Long id) {
        skinService.deleteSkin(id);

        return ResponseEntity.accepted().build();
    }

    @PatchMapping("/add-to-cases/{id}")
    public ResponseEntity<?> addSkinInCases(@PathVariable Long id, @RequestBody List<Long> caseIds) {
        skinService.addSkinInCases(id, caseIds);

        return ResponseEntity.accepted().build();
    }

    @PatchMapping("/remove-from-cases/{id}")
    public ResponseEntity<?> removeSkinInCases(@PathVariable Long id, @RequestBody List<Long> caseIds) {
        skinService.removeSkinInCase(id, caseIds);

        return ResponseEntity.accepted().build();
    }

    @PatchMapping("/set-chance/{id}")
    public ResponseEntity<?> setChance(@PathVariable Long id, @RequestBody Double chance) {
        skinService.setChance(id, chance);

        return ResponseEntity.accepted().build();
    }

    @PatchMapping("/set-price/{id}")
    public ResponseEntity<?> setPrice(@PathVariable Long id, @RequestBody BigDecimal price) {
        skinService.setPrice(id, price);

        return ResponseEntity.accepted().build();
    }

}
