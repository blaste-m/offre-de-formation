package org.ut3.miage.tpconceptionsi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ut3.miage.tpconceptionsi.models.UE;
import org.ut3.miage.tpconceptionsi.models.Year;
import org.ut3.miage.tpconceptionsi.parsers.UEArgumentParser;
import org.ut3.miage.tpconceptionsi.repositories.UERepository;
import org.ut3.miage.tpconceptionsi.repositories.YearRepository;
import org.ut3.miage.tpconceptionsi.requests.UECreationRequest;
import org.ut3.miage.tpconceptionsi.utils.ue.UEFactory;
import org.ut3.miage.tpconceptionsi.validators.UECreationValidator;

@Service
@RequiredArgsConstructor
public class UEService {

    private final UERepository ueRepository;
    private final YearRepository yearRepository;
    private final UEFactory ueFactory = new UEFactory();
    private final UEArgumentParser parser = new UEArgumentParser();
    private final UECreationValidator validator = new UECreationValidator();

    @Transactional
    public UE createUE(Year y, String... args) {
        UECreationRequest request = parser.parseCreateUE(args);
        validator.validate(request);

        if (y == null)
            throw new IllegalArgumentException(
                    "No degree or year selected. Please select a degree or year before creating a UE"
            );

        Year year = yearRepository.findById(y.getId()).get();

        UE ue = ueRepository.findById(request.name()).orElse(null);

        // L'UE existe déjà et est déjà associée à l'année
        if (year.getUes().contains(ue)) {
            throw new IllegalArgumentException(
                    "UE " + ue.getName() + " is already associated with year "
                            + year.getId().getYear() + " of degree " + year.getDegree().getName()
            );
        }

        // L'UE existe déjà mais n'est pas encore associée à l'année
        if (ue != null && ueRepository.existsById(ue.getName())) {
            year.getUes().add(ue);
            ue.getYears().add(year);
            return ue;
        }

        ue = ueRepository.save(ueFactory.create(request));

        year.getUes().add(ue);
        ue.getYears().add(year);

        return ue;
    }

}