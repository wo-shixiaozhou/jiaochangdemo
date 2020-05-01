package cn.onexiaomu.jiaochangdemo.user.service;

import cn.onexiaomu.jiaochangdemo.user.dao.UserDao;
import cn.onexiaomu.jiaochangdemo.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public UserEntity findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public void update(UserEntity userEntity) {
        userEntity.setCreatetime(new Date());
        userEntity.setStatus(1);
        userDao.updateUser(userEntity);
    }

    @Override
    public List<UserEntity> getAll(Map map) {
        return userDao.getAll(map);
    }

    @Override
    public void add(UserEntity userEntity) {
        userEntity.setCreatetime(new Date());
        userEntity.setStatus(1);
        userDao.add(userEntity);
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }
}
