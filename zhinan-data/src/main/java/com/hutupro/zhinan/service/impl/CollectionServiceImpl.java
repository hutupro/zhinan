package com.hutupro.zhinan.service.impl;

import com.hutupro.zhinan.data.CollectionDao;
import com.hutupro.zhinan.model.Collection;
import com.hutupro.zhinan.service.CollectionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hutupro
 * @since 2022/10/7
 */
@Service
public class CollectionServiceImpl implements CollectionService {
    @Resource
    private CollectionDao collectionDao;

    @Transactional
    public int deleteByName(String name) {
        return collectionDao.deleteByName(name);
    }

    public int save(Collection collection) {
        Collection save = collectionDao.save(collection);
        return save == null? 0 : 1;
    }

    public List<Collection> findAll() {
        return collectionDao.getAll();
    }
}
