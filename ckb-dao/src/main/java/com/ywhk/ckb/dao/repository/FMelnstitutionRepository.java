package com.ywhk.ckb.dao.repository;import com.ywhk.ckb.dao.model.core.FMelnstitutionEntity;import org.springframework.data.jpa.repository.JpaRepository;public interface FMelnstitutionRepository extends JpaRepository<FMelnstitutionEntity, Integer> {    FMelnstitutionEntity findByFMeInstitutionID(Integer id);}