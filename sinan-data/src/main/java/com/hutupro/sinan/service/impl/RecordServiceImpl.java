package com.hutupro.sinan.service.impl;

import com.hutupro.sinan.data.RecordDao;
import com.hutupro.sinan.model.Record;
import com.hutupro.sinan.service.RecordService;
import org.springframework.stereotype.Service;

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
}
