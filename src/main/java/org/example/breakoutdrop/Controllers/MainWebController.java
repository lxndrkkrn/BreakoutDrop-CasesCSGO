package org.example.breakoutdrop.Controllers;

import lombok.RequiredArgsConstructor;
import org.example.breakoutdrop.Services.ApplicationServices.*;
import org.example.breakoutdrop.Services.DomainServices.CaseService;
import org.example.breakoutdrop.Services.DomainServices.SkinService;
import org.example.breakoutdrop.Services.DomainServices.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/breakout-drop")
@RequiredArgsConstructor

public class MainWebController {

    private final OpenCaseService openCaseService;
    private final ReplenishmentOfBalanceService replenishmentOfBalanceService;
    private final SalesService salesService;
    private final UpgradeService upgradeService;
    private final UseOfTheContractService useOfTheContractService;
    private final WithdrawSkinService withdrawSkinService;

    private final UserService userService;
    private final SkinService skinService;
    private final CaseService caseService;

}
