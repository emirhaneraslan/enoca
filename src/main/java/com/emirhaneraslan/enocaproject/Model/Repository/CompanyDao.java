package com.emirhaneraslan.enocaproject.Model.Repository;

import com.emirhaneraslan.enocaproject.Model.Entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDao extends JpaRepository<CompanyEntity,CompanyDao> {

    public CompanyEntity findById(Long id);
}
