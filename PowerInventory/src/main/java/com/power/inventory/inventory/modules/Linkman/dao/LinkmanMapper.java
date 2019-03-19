package com.power.inventory.inventory.modules.Linkman.dao;

import com.power.inventory.inventory.modules.Linkman.model.Linkman;
import com.power.inventory.inventory.modules.supplier.model.supplier;

import java.util.List;

public interface LinkmanMapper {
    int deleteByPrimaryKey(Long id);
//按联系人名字删除
    int deleteByName(String name);
//添加联系人
    int insert(Linkman record);
//    通过名字查找联系人
    List<Linkman> selectLinkmanByName(String name);

    int insertSelective(Linkman record);

    Linkman selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Linkman record);

    int updateByPrimaryKey(Linkman record);
//通过供应商编号查找
    List<Linkman> selectByForeignKey(Long sysSupplierId);

    List<Linkman> selectAllLinkman();

}