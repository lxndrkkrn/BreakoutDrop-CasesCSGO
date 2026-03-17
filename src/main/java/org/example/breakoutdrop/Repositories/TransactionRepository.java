package org.example.breakoutdrop.Repositories;

import jakarta.persistence.LockModeType;
import org.example.breakoutdrop.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
