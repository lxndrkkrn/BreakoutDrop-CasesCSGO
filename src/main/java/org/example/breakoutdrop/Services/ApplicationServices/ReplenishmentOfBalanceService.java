package org.example.breakoutdrop.Services.ApplicationServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.breakoutdrop.Entities.User;
import org.example.breakoutdrop.Services.DomainServices.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Slf4j
@RequiredArgsConstructor

public class ReplenishmentOfBalanceService {

    private final CaseService caseService;
    private final UserService userService;
    private final SkinService skinService;
    private final InventoryService inventoryService;
    private final TransactionService transactionService;

    @Transactional
    public void p2pAddBalance(Long id, BigDecimal deltaBalance) {
        log.info("Попытка пополнения баланса");
        try {
            User user = userService.findUserById(id);

            transactionService.processDeposit(id, deltaBalance);
            userService.addBalanceToUser(id, deltaBalance);

            log.info("Баланс успешно пополнен");
        } catch (Exception e) {
            log.error("Ошибка при пополнении баланса");
            throw e;
        }
    }

}
