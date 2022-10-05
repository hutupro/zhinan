package com.hutupro.sinan.data;

import com.hutupro.sinan.model.Record;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hutupro
 * @since 2022/10/5
 */
public interface RecordDao extends CrudRepository<Record, Integer> {
    @Query(value = "select id, title, info, category, link, tag, weight, collection from Record where 1=1", nativeQuery = true)
    List<Record> getAll();
}
