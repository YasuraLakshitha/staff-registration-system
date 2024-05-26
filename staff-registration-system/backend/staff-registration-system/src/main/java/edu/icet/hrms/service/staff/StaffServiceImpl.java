package edu.icet.hrms.service.staff;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.hrms.dto.StaffMember;
import edu.icet.hrms.entity.StaffMemberEntity;
import edu.icet.hrms.repository.StaffMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private StaffMemberRepository repository;

    @Override
    public StaffMember persist(StaffMember member) {
        StaffMemberEntity staffEntity = repository.save(mapper.convertValue(member, StaffMemberEntity.class));
        return mapper.convertValue(staffEntity, StaffMember.class);
    }

    @Override
    public StaffMember retrieve(String memberId) {
        Optional<StaffMemberEntity> memberEntity = repository.findById(memberId);
        return mapper.convertValue(memberEntity.get(),StaffMember.class);
    }

    @Override
    public StaffMember update(StaffMember member) {
        return this.persist(member);
    }

    @Override
    public void remove(String staffMemberId) {
        repository.deleteById(staffMemberId);
    }

    @Override
    public ArrayList<StaffMember> retrieve() {
        Iterable<StaffMemberEntity> staffMemberEntities = repository.findAll();
        ArrayList<StaffMember> staffMemberArrayList = new ArrayList<>();
        staffMemberEntities.forEach(staffMemberEntity -> {
            if (staffMemberEntity.isActive())
                staffMemberArrayList.add(mapper.convertValue(staffMemberEntity,StaffMember.class));
        });
        return staffMemberArrayList;
    }
}
