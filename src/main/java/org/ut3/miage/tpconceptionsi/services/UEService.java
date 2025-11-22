package org.ut3.miage.tpconceptionsi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ut3.miage.tpconceptionsi.models.UE;
import org.ut3.miage.tpconceptionsi.repositories.UERepository;
import org.ut3.miage.tpconceptionsi.utils.UEFactory;

@Service
@RequiredArgsConstructor
public class UEService {

    private final UERepository ueRepository;

    public String createUE(String... args) {

        try {
            UE ue = new UEFactory().create(args);
            ueRepository.save(ue);
            return "UE created: " + ue.getNom();
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        } catch (Exception e) {
            return "Error while creating UE: " + e.getMessage();
        }

    }


}
