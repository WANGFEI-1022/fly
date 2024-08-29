package com.wf.imaotai.mapper;

import com.wf.imaotai.entity.Log;
import com.wf.imaotai.model.request.LogRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogMapper {

    public List<Log> getList(LogRequest request);

    @Insert("INSERT INTO imaotai_log(user_id, mobile, content, create_time) " +
            "VALUES(#{userId}, #{mobile}, #{content}, #{createTime})")
    public int insetLog(Log log);
}
