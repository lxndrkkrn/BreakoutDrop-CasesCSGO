package org.example.breakoutdrop.Repositories;

import org.example.breakoutdrop.Entities.Inventory;
import org.example.breakoutdrop.Entities.PromoCode;
import org.example.breakoutdrop.Entities.Skin;
import org.example.breakoutdrop.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PromoCodeRepository extends JpaRepository<PromoCode, Long> {

    Optional<PromoCode> findFirstByName(String name);

}
