package com.wf.imaotai.service.impl;

import com.github.pagehelper.PageHelper;
import com.wf.imaotai.entity.Log;
import com.wf.imaotai.entity.User;
import com.wf.imaotai.mapper.LogMapper;
import com.wf.imaotai.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    public LogMapper logMapper;

    @Override
    public List<Log> list() {
        PageHelper.startPage(1, 10);
        List<Log> logs = logMapper.getList();
        return logs;
    }

    @Override
    public int record(User user, String content) {
        return 0;
    }
}
