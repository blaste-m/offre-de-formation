package org.ut3.miage.tpconceptionsi.utils.ue;

import org.springframework.stereotype.Component;
import org.ut3.miage.tpconceptionsi.models.UE;
import org.ut3.miage.tpconceptionsi.requests.UECreationRequest;

import java.util.HashSet;

@Component
public class UEFactory {

    public UE create(UECreationRequest request) {

        String name = request.name();
        int ects = request.ects();
        int cm = request.cm();
        int td = request.td();
        int tp = request.tp();

        return new UE(name, ects, cm, td, tp, new HashSet<>(), new HashSet<>());
    }
}
