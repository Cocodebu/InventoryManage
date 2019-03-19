package com.power.inventory.inventory.modules.Linkman.controller;

import com.alibaba.fastjson.JSON;
import com.power.inventory.inventory.modules.Linkman.Protocal.LinkmanDataResponse;
import com.power.inventory.inventory.modules.Linkman.Protocal.LinkmanDataResquest;
import com.power.inventory.inventory.modules.Linkman.model.Linkman;
import com.power.inventory.inventory.modules.Linkman.service.LinkmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.lang.Boolean;

@Controller
public class LinkmanController {

    private static int ADD_LINKMAN_SUCCESS = 0;
    private static int ADD_LINKMAN_ERR = -1;
    private static int LINKMAN_EXIST_ERR = -2;

    @Autowired
    private LinkmanService linkmanService;
    @Autowired
    HttpServletRequest request;
    HttpServletResponse response;



//查找所有联系人

    @RequestMapping(value = "/linkmanManager",produces = {"application/json;charset=UTF-8"})
    public String findAllLinkman(Model model){
        List<Linkman> linkman=linkmanService.findAllLinkman();
        model.addAttribute("linkmans",linkman);
        return "linkmanManager";
    }
//按供应商编号查询联系人
    @PostMapping(value = "/linkmanManager" , produces = {"application/json;charset=UTF-8"})
    public String getlinkmanByForeignId(Model model){
        String num=request.getParameter("supplierId");
        if(num== null ||"".equals(num)) {
            num = "0";
        }
        int a=Integer.parseInt(num);
        Long sysSupplierId = new Long((long)a);
        List<Linkman> linkman=linkmanService.getlinkmanByForeignId(sysSupplierId);
        model.addAttribute("linkmans",linkman);
        return "linkmanManager";
    }
//添加联系人

    @PostMapping(value = "/addLinkman" )
    @ResponseBody
    public String addLinkman(Model model,
                             @RequestBody LinkmanDataResquest linkman){
        int rn=ADD_LINKMAN_SUCCESS;
        List<Linkman> linkmancheck=linkmanService.findLinkmanByName(linkman.getName());
        if(linkmancheck!=null&&linkmancheck.size()>0){
            rn = LINKMAN_EXIST_ERR;
        }
        else{
            Linkman linkmanRecord=new Linkman();
            linkmanRecord.setName(linkman.getName());
            linkmanRecord.setTel(linkman.getTel());
            linkmanRecord.setEmail(linkman.getEmail());
            linkmanRecord.setAddress(linkman.getAddress());
            linkmanRecord.setMainLinkman(linkman.getMainLinkman());
            linkmanRecord.setSysSupplierId(linkman.getSupplierId());
            try{
                linkmanService.addLinkman(linkmanRecord);
            }
            catch (Exception e){
                rn = ADD_LINKMAN_ERR;
            }
        }
        LinkmanDataResponse rsp=new LinkmanDataResponse();
        if(rn>=0){
            rsp.setResult(ADD_LINKMAN_SUCCESS);
        }
        else {
            rsp.setResult(rn);
        }
        String jsonStr = JSON.toJSONString(rsp);
        return jsonStr;


    }
//    删除联系人

    @PostMapping(value = "/deleteLinkman" , produces = {"application/json;charset=UTF-8"})
    public String deleteLinkmanByName(Model model){
        String m=request.getParameter("linkmanName");
        if(m== null ||"".equals(m)) {
            m = "0";
        }

       linkmanService.deleteLinkmanByName(m);
       return "redirect:/linkmanManager";
    }
}
