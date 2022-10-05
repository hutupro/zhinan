package com.hutupro.sinan.service;

import com.hutupro.sinan.model.Record;

import java.util.List;

/**
 * @author hutupro
 * @since 2022/10/5
 */
public interface RecordService {
    List<Record> findAll();
}
