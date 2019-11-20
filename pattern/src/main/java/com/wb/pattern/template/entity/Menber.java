package com.wb.pattern.template.entity;

/**
 *  实体
 * @author wangbo
 * @since 2019/11/5 16:55
 */
public class Menber {
    private String userName;
    private String password;
    private Integer age;
    private String add;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }
}
