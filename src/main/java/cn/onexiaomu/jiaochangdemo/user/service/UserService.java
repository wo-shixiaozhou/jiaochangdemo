package cn.onexiaomu.jiaochangdemo.user.service;

import cn.onexiaomu.jiaochangdemo.user.entity.UserEntity;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<UserEntity> getAll(Map map);
    void add(UserEntity userEntity);
    void delete(Integer id);
    UserEntity findById(Integer id);
    void update(UserEntity userEntity);
}
