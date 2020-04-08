package com.hp.docker_base.controller;

import com.alibaba.fastjson.JSON;
import com.hp.docker_base.bean.StaffDto;
import com.hp.docker_base.bean.StaffDto2;
import com.hp.docker_base.bean.constrains.group.MiniValidation;
import com.hp.docker_base.bean.constrains.group.UpdateValidation;
import com.hp.docker_base.util.ValidateUtils;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;

@RestController
@RequestMapping("/staff")
public class TestController {



    //请求参数
    //http://localhost:8083/staff/update?staffJsonStr={"number":"456","jobNumber":"","name":"王力宏","gender":2,"officePhone":"","phone":"15903199184","idNumber":"410822199105061234","photoUrl":"http://127.0.01/upload/00000051/5e8c3a40e9553b1fbce5c5a3.png","organizationCode":"7","organizationName":"中国机械工业集团有限公司总部","departmentCode":"000000510015","departmentName":"档案部","positionCode":"5e8ad17ea15c550ecc5472d8","positionName":"人事主管","postCode":"5e746d3b40f36c3930abd42a","postName":"职员","workStatus":1,"smartCardNumber":null,"foreignCode":null,"birthday":"1991-05-02","email":"247213@qq.com","isTakeOver":1,"hiredate":"2020-04-07","politicsStatus":1,"sort":1,"fieldCheck":"f9d1825064c9ca65dee178e73ada226f","registerMode":"ACCC"}
    /**
     * 这里有错误，需要接着修改
     * @return
     */
    @PostMapping("/new")
    public HashMap<String, Object> addUserInfo(@RequestParam(value = "staffJsonStr") String staffJsonStr) {

        StaffDto staffDto = JSON.parseObject(staffJsonStr, StaffDto.class);
        //校验参数
        ValidateUtils.validateGroup(staffDto, MiniValidation.class);//后面的MiniValidation.class只是为了分组校验

        // TODO: 2020/4/8  插入员工操作

        HashMap<String,Object> ret = new HashMap<>();
        ret.put("0","校验通过");
        return  ret;
    }


    /**
     * 这里有错误，需要接着修改
     * @return
     */
    @PostMapping("/update")
    public HashMap<String, Object> updateUserInfo(@RequestParam(value = "staffJsonStr") String staffJsonStr) {

        StaffDto staffDto = JSON.parseObject(staffJsonStr, StaffDto.class);
        //校验参数
        ValidateUtils.validateGroup(staffDto, UpdateValidation.class);//后面的MiniValidation.class只是为了分组校验

        // TODO: 2020/4/8  更新员工操作

        HashMap<String,Object> ret = new HashMap<>();
        ret.put("0","校验通过");
        return  ret;
    }


    //http://localhost:8083/staff/validated
    //{"number":"123","jobNumber":"","name":"王力宏","gender":2,"officePhone":"","phone":"15903199184","idNumber":"410822199105061234","photoUrl":"http://127.0.01/upload/00000051/5e8c3a40e9553b1fbce5c5a3.png","organizationCode":"7","organizationName":"中国机械工业集团有限公司总部","departmentCode":"000000510015","departmentName":"档案部","positionCode":"5e8ad17ea15c550ecc5472d8","positionName":"人事主管","postCode":"5e746d3b40f36c3930abd42a","postName":"职员","workStatus":1,"smartCardNumber":null,"foreignCode":null,"birthday":"1991-05-02","email":"247213@qq.com","isTakeOver":1,"hiredate":"2020-04-07","politicsStatus":1,"sort":1,"fieldCheck":"f9d1825064c9ca65dee178e73ada226f","registerMode":"ACc"}
    /**
     * 这里有错误，需要接着修改
     * @return
     */
    @PostMapping("/validated")
    public HashMap<String, Object> testUserInfo(@RequestBody @Validated StaffDto2 staffDto2) {


        HashMap<String,Object> ret = new HashMap<>();
        ret.put("0","校验通过");
        return  ret;
    }


}
