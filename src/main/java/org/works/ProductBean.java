package org.works;

import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@Data
@ViewScoped
public class ProductBean {

    private String title;
    private String desc;
    private String tc = "";
    private String enTc = "";

    private String phone = "";
    private String enPhone = "";

    public ProductBean() {
        setTitle("Product X");
        setDesc("Product Desc");
    }

    public String getEnTc() {
        if ( tc.equals("12345") ) {
            enTc = "True";
        }else {
            enTc = "False";
        }
        if (tc.equals("")) {
            enTc = "";
        }
        return enTc;
    }

    public String getEnPhone() {
        if (phone.equals("123456")) {
            enPhone = "Valid";
        }else {
            enPhone = "Not Valid";
        }
        System.out.println(phone);
        return enPhone;
    }
}
