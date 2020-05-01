package cn.onexiaomu.jiaochangdemo.user.dao;

import cn.onexiaomu.jiaochangdemo.user.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {
    List<UserEntity> getAll(@Param("content")Map map);
    void add(UserEntity userEntity);
    void delete(Integer id);
    UserEntity findById(Integer id);
    void updateUser(UserEntity userEntity);
}
