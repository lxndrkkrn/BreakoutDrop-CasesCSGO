package org.example.breakoutdrop.Services.DomainServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.breakoutdrop.DTOs.Create.CreatePromoDTO;
import org.example.breakoutdrop.Entities.PromoCode;
import org.example.breakoutdrop.Entities.User;
import org.example.breakoutdrop.Errors.ClientHTTP.NotFound404;
import org.example.breakoutdrop.Repositories.PromoCodeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Slf4j
@RequiredArgsConstructor

public class PromoCodeService {

    private final PromoCodeRepository promoCodeRepository;

    @Transactional
    public PromoCode createPromo(CreatePromoDTO createPromoDTO) {
        log.info("Попытка создания промо-кода");
        try {
            PromoCode promoCode = new PromoCode();

            promoCode.setCode(createPromoDTO.code());
            promoCode.setFactor(createPromoDTO.factor());

            promoCodeRepository.save(promoCode);

            log.info("Промо-код успешно создан");
            return promoCode;
        } catch (Exception e) {
            log.error("Ошибка при создании промо-кода");
            throw e;
        }
    }

    @Transactional
    public void deletePromo(Long id) {
        log.info("Попытка удаления промо-кода");
        try {
            PromoCode promoCode = promoCodeRepository.findById(id).orElseThrow(() -> new NotFound404("Промо-код не найден"));

            promoCodeRepository.delete(promoCode);

            log.info("Промо-код успешно удалён");
        } catch (Exception e) {
            log.error("Ошибка при удалении промо-кода");
            throw e;
        }
    }

    public PromoCode findFirstByName(String name) {
        return promoCodeRepository.findFirstByName(name).orElseThrow(() -> new NotFound404("Промокод не найден"));
    }
}
