package com.ywhk.ckb.dao.repository;import com.ywhk.ckb.dao.model.core.GroupEntity;import org.springframework.data.jpa.repository.JpaRepository;public interface GroupRepostory extends JpaRepository<GroupEntity, Integer> {    GroupEntity findByFGROUPID(Integer id);}