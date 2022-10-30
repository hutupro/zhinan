package com.hutupro.zhinan.service.impl;

import com.hutupro.zhinan.data.RecordDao;
import com.hutupro.zhinan.model.Record;
import com.hutupro.zhinan.service.RecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hutupro
 * @since 2022/10/5
 */
@Service
public class RecordServiceImpl implements RecordService {
    @Resource
    private RecordDao recordDao;

    public List<Record> findAll() {
        return recordDao.getAll();
    }

    @Transactional
    public Integer deleteById(int id) {
        Integer value =  recordDao.deleteById(id);
        //deleteById可能返回null
        return value == null ? 1 : value;
    }

    public int save(Record record) {
        Record save = recordDao.save(record);
        return save == null? 0 : 1;
    }
}
