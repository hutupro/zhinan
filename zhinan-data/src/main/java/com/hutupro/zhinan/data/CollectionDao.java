package com.hutupro.zhinan.data;

import com.hutupro.zhinan.model.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author hutupro
 * @since 2022/10/7
 */
public interface CollectionDao extends CrudRepository<Collection, String> {
    @Query(value = "select name, info, weight from collection where 1=1 order by weight desc", nativeQuery = true)
    List<Collection> getAll();
}
