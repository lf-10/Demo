package com.itmadu_thread;

import com.itmadu_thread.entity.UserEntity;
import com.itmadu_thread.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;
class UserThread extends Thread{



    private List<UserEntity> listUser;
    public UserThread(List<UserEntity> listUser){
        this.listUser=listUser;

    }
    @Override
    public void run(){
        for (UserEntity userEntity: listUser) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("name"+getName()+userEntity.toString());
            //调用发送短信接口

        }
    }
}

/**
 * Created with IntelliJ IDEA.
 *
 * @classDesc: 功能描述（多线程分批处理数据）
 * @Auther: 李府
 * @Date: 2020/07/14/10:33
 * @Description:
 */
public class BatchThread {
    public static void main(String[] args) {
        //1、初始化用户
        List<UserEntity> initUser=initUser();
        //2、定义每一个线程最多跑多少数据
        int userCount=2;
        //3、计算每个线程数，并且计算每个线程跑那些数据
       List<List<UserEntity>>splitList= ListUtils.splitList(initUser, userCount);
        for (int i = 0; i < splitList.size() ; i++) {
            //每个线程跑多少数据
            List<UserEntity> list = splitList.get(i);
            UserThread userThread = new UserThread(list);
            userThread.start();

            System.out.println("i "+ i +  ":==="+list.toString());

        }
        //4、让子线程进行分批异步处理数据
    }
    public static List<UserEntity> initUser(){
        List<UserEntity> listUser = new ArrayList<UserEntity>();
        for (int i = 1; i <=11 ; i++) {
            listUser.add(new UserEntity("userId" + i, "userName" + i));
        }
        return listUser;
    }
}
