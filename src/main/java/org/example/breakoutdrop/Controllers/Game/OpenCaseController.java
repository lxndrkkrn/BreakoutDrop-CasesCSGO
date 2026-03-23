package org.example.breakoutdrop.Controllers.Game;

import lombok.RequiredArgsConstructor;
import org.example.breakoutdrop.DTOs.Open.OpeningCaseDTO;
import org.example.breakoutdrop.Entities.Skin;
import org.example.breakoutdrop.Services.ApplicationServices.OpenCaseService;
import org.example.breakoutdrop.Services.DomainServices.CaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/breakout-drop/case")
@RequiredArgsConstructor

public class OpenCaseController {

    private final CaseService caseService;
    private final OpenCaseService openCaseService;

    @PostMapping("/{caseId}")
    public ResponseEntity<?> openCase(@PathVariable Long caseId, @RequestBody Long userId) {
        OpeningCaseDTO openingCaseDTO = new OpeningCaseDTO(userId, caseId);
        Skin wonSkin = openCaseService.userOpeningCase(openingCaseDTO);

        return ResponseEntity.ok(wonSkin);
    }

}
