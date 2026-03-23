package org.example.breakoutdrop.Controllers.System;

import lombok.RequiredArgsConstructor;
import org.example.breakoutdrop.DTOs.Create.CreateCaseDTO;
import org.example.breakoutdrop.Entities.Case;
import org.example.breakoutdrop.Services.ApplicationServices.OpenCaseService;
import org.example.breakoutdrop.Services.DomainServices.CaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@CrossOrigin("*")
@RequestMapping("/breakout-drop/case")
@RequiredArgsConstructor

public class CaseController {

    private final CaseService caseService;
    private final OpenCaseService openCaseService;

    @PostMapping()
    public ResponseEntity<?> createCase(@RequestBody CreateCaseDTO createCaseDTO) {
        Case newCase = caseService.createCase(createCaseDTO);

        return ResponseEntity.ok(newCase);
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteCase(@RequestBody Long id) {
        Case newCase = caseService.deleteCase(id);

        return ResponseEntity.accepted().build();
    }

    @PatchMapping("/set-price/{id}")
    public ResponseEntity<?> setPriceCase(@PathVariable Long id, @RequestBody BigDecimal price) {
        caseService.setPriceToCase(id, price);

        return ResponseEntity.accepted().build();
    }

    @PatchMapping("/set-name/{id}")
    public ResponseEntity<?> setNameCase(@PathVariable Long id, @RequestBody String name) {
        caseService.setNameToCase(id, name);

        return ResponseEntity.accepted().build();
    }

}
