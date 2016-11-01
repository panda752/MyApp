package fs.com.myapp;

import cn.bmob.v3.BmobObject;

/**
 * Created by Huaqin on 2016/10/31.
 */

public class Person extends BmobObject {
    private String name;
    private String desc;
    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
