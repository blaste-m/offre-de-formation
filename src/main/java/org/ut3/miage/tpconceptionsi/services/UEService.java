package org.ut3.miage.tpconceptionsi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ut3.miage.tpconceptionsi.models.Degree;
import org.ut3.miage.tpconceptionsi.models.DegreeId;
import org.ut3.miage.tpconceptionsi.models.UE;
import org.ut3.miage.tpconceptionsi.parsers.UEArgumentParser;
import org.ut3.miage.tpconceptionsi.repositories.DegreeRepository;
import org.ut3.miage.tpconceptionsi.repositories.UERepository;
import org.ut3.miage.tpconceptionsi.requests.UECreationRequest;
import org.ut3.miage.tpconceptionsi.utils.ue.UEFactory;
import org.ut3.miage.tpconceptionsi.validators.UECreationValidator;

@Service
@RequiredArgsConstructor
public class UEService {

    private final UERepository ueRepository;
    private final DegreeRepository degreeRepository;
    private final UEFactory ueFactory = new UEFactory();
    private final UEArgumentParser parser = new UEArgumentParser();
    private final UECreationValidator validator = new UECreationValidator();

    @Transactional
    public UE createUE(Degree degree, String... args) {
        UECreationRequest request = parser.parseCreateUE(args);
        validator.validate(request);

        if (degree == null)
            throw new IllegalArgumentException(
                    "Error: no degree selected. Please select a degree before creating the UE"
            );

        Degree managedDegree = degreeRepository.findById(
                new DegreeId(degree.getName(), degree.getYear())).orElseThrow();

        UE ue = ueRepository.findById(request.name()).orElse(null);

        if (ue != null)
            throw new IllegalArgumentException(
                    "Error: the UE " + request.name() + " already exists" +
                            "\nUse the command ASSIGN UE to associate it with the degree"
            );

        ue = ueFactory.create(request);
        ue.addDegree(managedDegree);

        return ue;
    }

}