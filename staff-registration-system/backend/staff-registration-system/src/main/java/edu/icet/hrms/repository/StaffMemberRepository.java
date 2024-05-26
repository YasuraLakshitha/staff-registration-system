package edu.icet.hrms.repository;

import edu.icet.hrms.entity.StaffMemberEntity;
import org.springframework.data.repository.CrudRepository;

public interface StaffMemberRepository extends CrudRepository<StaffMemberEntity,String> {}
