package com.power.inventory.inventory.modules.supplier.service;

import java.util.List;

import com.power.inventory.inventory.modules.supplier.model.supplier;
    /*     供应商Service层接口     */
public interface SupplierService {
    /*     获取所有供应商的信息     */
        List<supplier> findAllSupplier(boolean b);

        int addSupplier(supplier supp);

        int deleteByPrimaryKey(Long id);


}
