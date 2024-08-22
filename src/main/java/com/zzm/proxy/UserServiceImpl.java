package com.zzm.proxy;

/**
 * @Author:zzm
 * @Date:2024/8/21 20:29
 */
public class UserServiceImpl implements IUserService {
    @Override
    public void add(String name) {
        System.out.println("添加用户" + name);
    }
}
