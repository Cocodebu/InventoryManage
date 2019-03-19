package com.power.inventory.inventory.modules.Linkman.Protocal;

public class LinkmanDataResquest {
    private String name;

    private Long tel;

    private String email;

    private String address;

    private Boolean mainLinkman;

    private Long supplierId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getMainLinkman() {
        return mainLinkman;
    }

    public void setMainLinkman(Boolean mainLinkman) {
        this.mainLinkman = mainLinkman;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
}
