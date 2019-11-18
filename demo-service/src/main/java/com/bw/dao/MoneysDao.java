package com.bw.dao;

import com.bw.entity.Moneys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MoneysDao extends JpaRepository<Moneys,String>, JpaSpecificationExecutor<Moneys> {
    @Modifying
    @Query(nativeQuery = true,value="delete from moneys where id in (?1)")
    int deleteAllByIds(String[] ids);
}
