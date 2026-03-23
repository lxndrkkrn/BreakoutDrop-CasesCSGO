package org.example.breakoutdrop.Controllers.Game;

import lombok.RequiredArgsConstructor;
import org.example.breakoutdrop.DTOs.Open.OpeningContractDTO;
import org.example.breakoutdrop.Entities.Skin;
import org.example.breakoutdrop.Services.ApplicationServices.UseOfTheContractService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/breakout-drop/contract")
@RequiredArgsConstructor

public class ContractController {

    private final UseOfTheContractService useOfTheContractService;

    @PostMapping()
    public ResponseEntity<?> useOfTheContract(@RequestBody OpeningContractDTO openingContractDTO) {
        Skin wonSkin = useOfTheContractService.useOfTheContract(openingContractDTO);

        return ResponseEntity.ok(wonSkin);
    }

}
