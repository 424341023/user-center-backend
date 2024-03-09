package com.java.usercenterbackend.mapper;

import com.java.usercenterbackend.model.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author sunshine
* @description 针对表【user(用户)】的数据库操作Mapper
* @createDate 2024-03-09 11:52:57
* @Entity com.java.usercenterbackend.model.domain.User
*/

@Mapper
public interface UserMapper extends BaseMapper<User> {

}




