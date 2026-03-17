package org.example.breakoutdrop.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "system_wallet")

public class SystemWallet {

    @Id
    private Long id = 1L;

    @NotNull
    private BigDecimal totalProfit = BigDecimal.ZERO;

    @NotNull
    private BigDecimal prizePool = new BigDecimal("1000");

}
