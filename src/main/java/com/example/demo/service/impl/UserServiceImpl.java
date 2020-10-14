package com.example.demo.service.impl;

import com.example.demo.bean.User;
import com.example.demo.dao.IUserDao;
import com.example.demo.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl  implements IUserService {

    @Resource
    private IUserDao iuserDao;

    @Override
    public List<User> findUserByName(String name) {
        // TODO Auto-generated method stub
        return iuserDao.findUserByName(name);
    }

    @Override
    public User findUserById(int id) {
        // TODO Auto-generated method stub
        return iuserDao.findUserById(id);
    }

    @Override
    public void insertUser(User user) {
        iuserDao.insertUser(user);

    }

    @Override
    public void deleteUser(int id) {
        iuserDao.deleteUser(id);

    }

    @Override
    public void updateUser(User user) {
        System.out.println("pppppppppppppppppppppppppp");
        iuserDao.updateUser(user);

    }



}
