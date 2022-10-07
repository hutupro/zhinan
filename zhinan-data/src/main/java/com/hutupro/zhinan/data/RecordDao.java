package com.hutupro.zhinan.data;

import com.hutupro.zhinan.model.Record;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author hutupro
 * @since 2022/10/5
 */
public interface RecordDao extends CrudRepository<Record, Integer> {
    @Query(value = "select id, title, info, category, link, tag, weight, collection from Record where 1=1 order by weight desc", nativeQuery = true)
    List<Record> getAll();
}
