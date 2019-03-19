package com.power.inventory.inventory.modules.supplier.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.power.inventory.inventory.modules.supplier.model.supplier;

import com.power.inventory.inventory.modules.supplier.dao.supplierMapper;

import java.util.List;


@Service
public class SupplierServiceImpl implements SupplierService {
    /*   供应商Service层接口的实现类   */
    @Autowired
    private supplierMapper suppliermapper;

    @Override
    public List<supplier> findAllSupplier(boolean b) {
        return suppliermapper.selectAllSupplier(b);
    }
    @Override
    public int addSupplier(supplier supp){
        return suppliermapper.insert(supp);
    }
    @Override
    public int deleteByPrimaryKey(Long id){
        return suppliermapper.deleteByPrimaryKey(id);
    }
}
