package org.works;

import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "customerBean")
@SessionScoped
@Data
public class CustomerBean {

    private String name;
    private String surname;
    private String gender;
    private String city;
    private String user;
    private List<String> users = new ArrayList<>();

    public List<String> getUsers() {
        users.add("Ali");
        users.add("Veli");
        users.add("Erkan");
        return users;
    }

}
