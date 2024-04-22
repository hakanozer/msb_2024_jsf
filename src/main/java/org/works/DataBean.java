package org.works;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "dataBean")
public class DataBean {

    private String siteTitle;

    public DataBean() {
        System.out.println("DataBean Call");
    }

    public String getSiteTitle() {
        return "App Title";
    }

    public void setSiteTitle(String siteTitle) {
        this.siteTitle = siteTitle;
    }

    // send button
    public void sendFnc(ActionEvent event) {
        setSiteTitle("new Title");
        System.out.println("sendFnc call");
    }
}
