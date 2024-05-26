package edu.icet.hrms.service.staff;

import edu.icet.hrms.dto.StaffMember;
import java.util.ArrayList;

public interface StaffService {
    StaffMember persist(StaffMember member);
    StaffMember retrieve(String memberId);
    StaffMember update(StaffMember member);
    void remove(String staffMemberId);
    ArrayList<StaffMember> retrieve();
}
