package com.emirhaneraslan.enocaproject.Model.Repository;

import com.emirhaneraslan.enocaproject.Model.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeEntity,Long> {

    public EmployeeEntity getById(Long id);
}
