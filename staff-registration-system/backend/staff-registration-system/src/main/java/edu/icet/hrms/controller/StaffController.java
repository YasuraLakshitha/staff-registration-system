package edu.icet.hrms.controller;

import edu.icet.hrms.dto.StaffMember;
import edu.icet.hrms.service.staff.StaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@CrossOrigin
public class StaffController {

    private static final Logger log = LoggerFactory.getLogger(StaffController.class);
    @Autowired
    private StaffService service;

    @GetMapping("/members")
    private ArrayList<StaffMember> retrieve(){
       return service.retrieve();
    }

    @GetMapping("/member")
    private StaffMember retrieve(@RequestParam String memberId){
       return service.retrieve(memberId);
    }

    @PostMapping("/member")
    private StaffMember persist(@RequestBody StaffMember member){
        return service.persist(member);
    }

    @PatchMapping("/member")
    private StaffMember update(@RequestBody StaffMember member){
        return service.update(member);
    }

    @DeleteMapping("/member")
    private void remove(@RequestParam String id){
        service.remove(id);
    }
}
