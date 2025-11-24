package org.ut3.miage.tpconceptionsi.utils.degree;

import org.ut3.miage.tpconceptionsi.enums.DegreeType;
import org.ut3.miage.tpconceptionsi.models.Degree;
import org.ut3.miage.tpconceptionsi.requests.DegreeCreationRequest;

public class DegreeFactory {

    public Degree create(DegreeCreationRequest request) {

        String name = request.name();
        DegreeType type = request.type();
        int maxEtu = request.maxEtu();

        return switch (type) {
            case BUT -> new BUTDegree().create(name, maxEtu);
            case MASTER -> new MasterDegree().create(name, maxEtu);
            case LICENCE -> new LicenceDegree().create(name, maxEtu);
            case LICENCE_PRO -> new LicenceProDegree().create(name, maxEtu);
        };
    }
}
