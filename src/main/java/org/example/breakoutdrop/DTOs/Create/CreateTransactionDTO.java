package org.example.breakoutdrop.DTOs.Create;

import org.example.breakoutdrop.Enums.TransactionType;

import java.math.BigDecimal;

public record CreateTransactionDTO(
        Long userId,
        TransactionType transactionType,
        BigDecimal amount
) { }
