package org.example.breakoutdrop.Repositories;

import jakarta.persistence.LockModeType;
import org.example.breakoutdrop.Entities.SystemWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SystemWalletRepository extends JpaRepository<SystemWallet, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE) // Тот самый Senior-level замок
    @Query("select w from SystemWallet w where w.id = 1")
    Optional<SystemWallet> findWithLock();

}
