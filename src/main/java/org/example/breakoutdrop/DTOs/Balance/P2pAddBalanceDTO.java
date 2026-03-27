package org.example.breakoutdrop.DTOs.Balance;

import org.example.breakoutdrop.Entities.PromoCode;

import java.math.BigDecimal;

public record P2pAddBalanceDTO(
        BigDecimal deltaBalance,
        String promoCode
) { }
