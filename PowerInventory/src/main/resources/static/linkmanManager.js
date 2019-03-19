var AddLinkmanStatusEnum={
    ADD_LINKMAN_SUCCESS:0,             //添加联系人成功
    LINKMAN_NAME_NULL:1,               //联系人姓名空
    LINKMAN_TEL_NULL:2,                //联系人电话空
    LINKMAN_EMAIL_NULL:3,              //联系人邮箱空
    LINKMAN_ADDRESS_NULL:4,            //联系人地址空
    LINKMAN_MAINLINK_NULL:5,           //首要联系人空
    LINKMAN_SUPPLIER_ID_NULL:6,        //联系人的供应商编号空
    LINKMAN_EXIST_ERR:7,               //联系人已存在
    ADD_LINKMAN_FAIL:8                 //添加失败

}

function showAlert(sts) {

    switch (sts) {
        case AddLinkmanStatusEnum.LINKMAN_EXIST_ERR:
            $("#alertMsg").html("联系人已存在");
            break;
        case AddLinkmanStatusEnum.ADD_LINKMAN_FAIL:
            $("#alertMsg").html("添加联系人失败");
            break;
        case AddLinkmanStatusEnum.ADD_LINKMAN_SUCCESS:
            $("#alertMsg").html("添加联系人成功");
            break;
        case AddLinkmanStatusEnum.LINKMAN_NAME_NULL:
            $("#alertMsg").html("用户名不能为空");
            break;
        case AddLinkmanStatusEnum.LINKMAN_TEL_NULL:
            $("#alertMsg").html("电话不能为空");
            break;
        case AddLinkmanStatusEnum.LINKMAN_EMAIL_NULL:
            $("#alertMsg").html("邮箱不能为空");
            break;
        case AddLinkmanStatusEnum.LINKMAN_ADDRESS_NULL:
            $("#alertMsg").html("地址不能为空");
            break;
        case AddLinkmanStatusEnum.LINKMAN_MAINLINK_NULL:
            $("#alertMsg").html("首要联系人不能为空");
            break;
        case AddLinkmanStatusEnum.LINKMAN_SUPPLIER_ID_NULL:
            $("#alertMsg").html("所属供应商编号不能为空");
            break;
    }

    $("#alertDialog").show();
}

function hideAlert() {
    $("#alertDialog").hide();
}

function getLinkman() {
    var linkman=new Object();
    linkman.name=$('#linkmanName').val();
    linkman.tel=$('#linkmanTel').val();
    linkman.email=$('#linkmanEmail').val();
    linkman.address=$('#linkmanAddress').val();
    linkman.mainLinkman=$('#mainLinkman').val();
    linkman.supplierId=$('#supplierId').val();

    if(!linkman.name || linkman.name=="") {
        showAlert(AddLinkmanStatusEnum.LINKMAN_NAME_NULL);
        document.getElementById('linkmanName').focus();
        return null;

    }
    else if(!linkman.tel || linkman.tel==""){
        showAlert(AddLinkmanStatusEnum.LINKMAN_TEL_NULL);
        document.getElementById('linkmanTel').focus();
        return null;

    }
    else if (!linkman.email || linkman.email==""){
        showAlert(AddLinkmanStatusEnum.LINKMAN_EMAIL_NULL);
        document.getElementById("linkmanEmail").focus();
        return null;

    }
    else if (!linkman.address || linkman.address==""){
        showAlert(AddLinkmanStatusEnum.LINKMAN_ADDRESS_NULL);
        document.getElementById("linkmanAddress").focus();
        return null;

    }
    else if (!linkman.mainLinkman || linkman.mainLinkman==""){
        showAlert(AddLinkmanStatusEnum.LINKMAN_MAINLINK_NULL);
        document.getElementById("mainLinkman").focus();
        return null;

    }
    else if (!linkman.supplierId || linkman.supplierId==""){
        showAlert(AddLinkmanStatusEnum.LINKMAN_SUPPLIER_ID_NULL);
        document.getElementById("supplierId").focus();
        return null;

    }
    return linkman;
}
function AjaxRequest(url, jsondata,successCallBack,failCallBack){

    var rn = false;
    $.ajax({
        type : "POST",
        url : url,// 获取自己系统后台用户信息接口
        data :JSON.stringify(jsondata),
        contentType : "application/json;charset=utf-8",
        dataType : "json",
        success : function(result) {
            if(typeof successCallBack=='function'){
                successCallBack(result);
                rn = true;
            }
        },
        error : function(data){
            if(typeof failCallBack=='function'){
                failCallBack(data);
                rn = false;
            }
        }

    });
    return rn;
    
}
function check() {
    var linkman = getLinkman();
    if(linkman != null) {
        AjaxRequest("/addLinkman", linkman,LinkmanSubmitSuccess, LinkmanSubmitFail);
    }
    
}
function LinkmanSubmitSuccess(data) {
    if (data.result == 0) {
        $("#addModal").modal('hide');
        var url="/linkmanManager";
        window.location(url);
    }
    else {
            if(data.result == -2){
                showAlert(AddLinkmanStatusEnum.LINKMAN_EXIST_ERR);
            }else{
                showAlert(AddLinkmanStatusEnum.ADD_LINKMAN_FAIL);
            }
    }
}

function LinkmanSubmitFail(data) {

}