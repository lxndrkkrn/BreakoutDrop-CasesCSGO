package org.example.breakoutdrop.Services.ApplicationServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.breakoutdrop.DTOs.Balance.P2pAddBalanceDTO;
import org.example.breakoutdrop.Entities.PromoCode;
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
    private final PromoCodeService promoCodeService;

    @Transactional
    public void p2pAddBalance(Long id, P2pAddBalanceDTO p2pAddBalanceDTO) {
        log.info("Попытка пополнения баланса для пользователя {}", id);
        try {
            BigDecimal deltaBalance = p2pAddBalanceDTO.deltaBalance();
            BigDecimal factor = BigDecimal.ONE;

            if (p2pAddBalanceDTO.promoCode() != null && !p2pAddBalanceDTO.promoCode().isBlank()) {
                PromoCode promo = promoCodeService.findFirstByName(p2pAddBalanceDTO.promoCode());
                factor = promo.getFactor();
            }

            transactionService.processDeposit(id, deltaBalance);
            userService.addBalanceToUser(id, deltaBalance.multiply(factor));

            log.info("Баланс успешно пополнен с множителем {}", factor);
        } catch (Exception e) {
            log.error("Ошибка при пополнении баланса: {}", e.getMessage());
            throw e;
        }
    }


}
