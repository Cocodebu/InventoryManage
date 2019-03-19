package com.power.inventory.inventory.modules.Linkman.service;

import com.power.inventory.inventory.modules.Linkman.dao.LinkmanMapper;

import com.power.inventory.inventory.modules.Linkman.model.Linkman;

import com.power.inventory.inventory.modules.supplier.model.supplier;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Service
public class LinkmanServiceImpl implements LinkmanService {

    @Autowired
    private LinkmanMapper linkmanmapper;
    @Autowired
    HttpServletRequest request;

    @Override
    public List<Linkman> findAllLinkman(){

        return linkmanmapper.selectAllLinkman();
    }

    @Override
    public List<Linkman> getlinkmanByForeignId(Long sysSupplierId){

        return linkmanmapper.selectByForeignKey(sysSupplierId);
    }
    @Override

    public int addLinkman(Linkman linkman){

        return linkmanmapper.insert(linkman);
    }
//    @Override
//    public int deleteLinkmanById(Long id){
//        return linkmanmapper.deleteByPrimaryKey(id);
//    }

    @Override
    public int deleteLinkmanByName(String name){
        return linkmanmapper.deleteByName(name);
    }
    @Override
    public List<Linkman> findLinkmanByName(String name){
        return linkmanmapper.selectLinkmanByName(name);
    }
}
