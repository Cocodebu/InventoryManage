package com.power.inventory.inventory.modules.supplier.controller;

import com.alibaba.fastjson.JSON;
import com.power.inventory.inventory.modules.supplier.model.supplier;
import com.power.inventory.inventory.modules.supplier.service.SupplierService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import javax.servlet.http.HttpServletRequest;

import java.util.List;



@Controller
    public class SupplierController {

        @Autowired
        private SupplierService supplierService;
        @Autowired
        HttpServletRequest request;

        @RequestMapping(value = "/supplierManager" , produces = {"application/json;charset=UTF-8"})
        public String findAllsupplier(Model model) {
            boolean b=true;
            List<supplier> suppliers=supplierService.findAllSupplier(b);
//            String supp= JSON.toJSONString(suppliers);
//            return supp;
            model.addAttribute("suppliers",suppliers);
            return "supplierManager";
        }

    @PostMapping(value = "/addSupplier", produces = {"application/json;charset=UTF-8"})
    public String addSupplier(){
        supplier supp=new supplier();

//            添加供应商编号
        String id=request.getParameter("supplierId");
        if(id== null ||"".equals(id)) {
            id = "0";
        }
        long supplierId=Long.valueOf(id);
        supp.setId(supplierId);

//            添加供应商姓名
        String supplierName=request.getParameter("supplierName");
        if(supplierName== null ||"".equals(supplierName)) {
            supplierName = "0";
        }
        supp.setName(supplierName);

//            添加供应商备注
        String supplierRemark=request.getParameter("supplierRemark");
        if(supplierRemark== null ||"".equals(supplierRemark)) {
            supplierRemark = "0";
        }
        supp.setRemark(supplierRemark);
        String supplierOnOff=request.getParameter("supplierOnOff");
        if(supplierOnOff== null ||"".equals(supplierOnOff)) {
            supplierOnOff = "false";
        }
        Boolean onOff=Boolean.parseBoolean(supplierOnOff);
        supp.setOnOff(onOff);
        supplierService.addSupplier(supp);
        return "redirect:/supplierManager";
    }
    @PostMapping(value = "/deleteSupplier", produces = {"application/json;charset=UTF-8"})
    public String deleteByPrimaryKey(){
        String SupplierId=request.getParameter("SupplierId");
        if(SupplierId== null ||"".equals(SupplierId)) {
            SupplierId = "0";
        }
        long suppId=Long.valueOf(SupplierId);
        supplierService.deleteByPrimaryKey(suppId);
        return "redirect:/supplierManager";
    }

}
