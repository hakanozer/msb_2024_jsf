package org.works;

import lombok.Data;
import org.works.entities.Customer;
import org.works.services.CustomerService;
import org.works.utils.EntityManagerUtil;

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
    private List<Customer> customers = new ArrayList<>();

    public CustomerBean() {
        refreshData();
        //System.out.println("CustomerBean Call");
    }

    public void refreshData() {
        CustomerService service = new CustomerService();
        customers = service.customerAll();
    }

    public List<String> getUsers() {
        users.clear();
        users.add("Ali");
        users.add("Veli");
        users.add("Erkan");
        return users;
    }

    public String sendForm() {
        Customer c = new Customer();
        c.setName(name);
        c.setSurname(surname);
        c.setGender(gender);
        c.setCity(city);
        c.setUserName(user);
        CustomerService service = new CustomerService();
        service.customerSave(c);
        refreshData();
        return "index";
    }

    public String cancel() {
        return "index";
    }

}
