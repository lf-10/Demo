package com.itmadu_thread.entity;

/**
 * Created with IntelliJ IDEA.
 *
 * @classDesc: 功能描述（用户实体类）
 * @Auther: 李府
 * @Date: 2020/07/14/10:59
 * @Description:
 */
public class UserEntity {
    private String userId;
    private String userName;

    public UserEntity(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
