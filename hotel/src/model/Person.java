package model;

import java.io.Serializable;

public class Person implements Serializable {

    private String name;
    private String date;
    private String id;

    public Person() {
    }


    public Person(String name, String date, String id) {
        this.name = name;
        this.date = date;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return
                "Tên khách thuê: " + name + '\n' +
                        "Ngày sinh: " + date + "\n" +
                        "Chứng minh thư: " + id + "\n"
                ;
    }
}
