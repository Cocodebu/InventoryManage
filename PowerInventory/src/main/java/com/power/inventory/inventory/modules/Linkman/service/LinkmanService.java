package com.power.inventory.inventory.modules.Linkman.service;

import com.power.inventory.inventory.modules.Linkman.model.Linkman;
import com.power.inventory.inventory.modules.supplier.model.supplier;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface LinkmanService {
    List<Linkman> findAllLinkman();

     List<Linkman> getlinkmanByForeignId(Long sysSupplierId);

      int addLinkman(Linkman linkman);

//      int deleteLinkmanById(Long id);

      int deleteLinkmanByName(String name);

      List<Linkman> findLinkmanByName(String name);
}

