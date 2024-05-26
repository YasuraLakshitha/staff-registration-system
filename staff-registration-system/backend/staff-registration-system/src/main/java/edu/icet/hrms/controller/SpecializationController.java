package edu.icet.hrms.controller;

import edu.icet.hrms.entity.SpecializationEntity;
import edu.icet.hrms.service.specialization.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
@CrossOrigin
public class SpecializationController {
    @Autowired
    SpecializationService service;

    @GetMapping("/category")
    private ArrayList<SpecializationEntity> retrieve(){
        return service.retrieve();
    }
}
