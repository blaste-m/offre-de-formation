package org.ut3.miage.tpconceptionsi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ut3.miage.tpconceptionsi.models.UE;
import org.ut3.miage.tpconceptionsi.repositories.UERepository;
import org.ut3.miage.tpconceptionsi.utils.ue.UEFactory;

@Service
@RequiredArgsConstructor
public class UEService {

    private final UERepository ueRepository;

    public String createUE(String... args) {
        return null;
    }

}
