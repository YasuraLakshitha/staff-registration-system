package edu.icet.hrms.service.specialization;

import edu.icet.hrms.entity.SpecializationEntity;
import edu.icet.hrms.repository.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class SpecializationServiceImpl implements SpecializationService{
    @Autowired
    SpecializationRepository repository;

    @Override
    public ArrayList<SpecializationEntity> retrieve() {
        Iterable<SpecializationEntity> allAreas = repository.findAll();
        ArrayList<SpecializationEntity> specializations = new ArrayList<>();
        allAreas.forEach(specializationArea -> {
            specializations.add(specializationArea);
        });
        return specializations;
    }
}
