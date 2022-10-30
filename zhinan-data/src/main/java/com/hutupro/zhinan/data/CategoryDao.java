package com.hutupro.zhinan.data;

import com.hutupro.zhinan.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author hutupro
 * @since 2022/10/7
 */
public interface CategoryDao extends CrudRepository<Category, String> {
    @Query(value = "select name, collection_name, info, weight from category where 1=1 order by weight desc ", nativeQuery = true)
    List<Category> getAll();

    int deleteByNameAndCollectionName(String name, String collectionName);
}
