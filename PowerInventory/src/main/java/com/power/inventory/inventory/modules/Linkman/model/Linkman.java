package com.power.inventory.inventory.modules.Linkman.model;

import com.power.inventory.inventory.modules.supplier.model.supplier;

public class Linkman {
    private Long id;

    private String name;

    private Long tel;

    private String email;

    private String address;

    private Boolean mainLinkman;

    private Long sysSupplierId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Boolean getMainLinkman() {
        return mainLinkman;
    }

    public void setMainLinkman(Boolean mainLinkman) {
        this.mainLinkman = mainLinkman;
    }

    public Long getSysSupplierId() {
        return sysSupplierId;
    }

    public void setSysSupplierId(Long sysSupplierId) {
        this.sysSupplierId = sysSupplierId;
    }
}