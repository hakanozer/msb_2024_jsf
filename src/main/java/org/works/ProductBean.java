package org.works;

import lombok.Data;

import javax.faces.bean.ManagedBean;

@ManagedBean
@Data
public class ProductBean {

    private String title;
    private String desc;

    public ProductBean() {
        setTitle("Product X");
        setDesc("Product Desc");
    }

}
