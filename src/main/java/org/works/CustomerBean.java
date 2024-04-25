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

    private Long cid;
    private String name;
    private String surname;
    private String gender;
    private String city;
    private String user;
    private List<String> users = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();

    CustomerService service = null;
    public CustomerBean() {
        service = new CustomerService();
        refreshData();
        //System.out.println("CustomerBean Call");
    }

    public void refreshData() {
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
        service.customerSave(c);
        refreshData();
        return "index";
    }

    public String cancel() {
        return "index";
    }

    // Delete fnc
    public void delete(Long cid) {
        service.deleteCustomer(cid);
        refreshData();
    }

    public String update(Long cid) {
        Customer c = service.singleCustomer(cid);
        setCid(c.getCid());
        setName(c.getName());
        setSurname(c.getSurname());
        setGender(c.getGender());
        setCity(c.getCity());
        setUser(c.getUserName());
        return "customerUpdate";
    }

    public String updateSave() {
        Customer c = new Customer();
        c.setCid(cid);
        c.setName(name);
        c.setSurname(surname);
        c.setGender(gender);
        c.setCity(city);
        c.setUserName(user);
        service.customerUpdate(c);
        refreshData();
        return "customer";
    }

    public void reset() {
        setCid(-1l);
        setName("");
        setSurname("");
        setGender("");
        setCity("");
        setUser("");
    }

}
