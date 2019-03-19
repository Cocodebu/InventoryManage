package com.power.inventory.inventory.modules.supplier.dao;
import java.util.List;
import com.power.inventory.inventory.modules.supplier.model.supplier;

public interface supplierMapper {
    int deleteByPrimaryKey(Long id);

    int insert(supplier record);

    int insertSelective(supplier record);

    supplier selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(supplier record);

    int updateByPrimaryKey(supplier record);

    //这个方式我自己加的
    List<supplier> selectAllSupplier(boolean b);


}
