package com.ujiuye.controller;

import com.ujiuye.bean.User;
import com.ujiuye.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService service;

    @RequestMapping("/saveUser")
    public void saveUser(User user) {
        service.saveUser(user);

    }
@RequestMapping("/userList")
    public ModelAndView getUserList() {
        List<User> userList = service.userList();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("userList");
        mav.addObject("userList", userList);
        return mav;
    }
    @RequestMapping("/excelImport")
    public String excelImport(@RequestParam MultipartFile excel) throws IOException {
        InputStream is = excel.getInputStream();
        XSSFWorkbook wb = new XSSFWorkbook(is);
        XSSFSheet sheet = wb.getSheetAt(0);
        int rows = sheet.getPhysicalNumberOfRows();
        for (int i=1;i<rows;i++){
            XSSFRow row = sheet.getRow(i);
            XSSFCell cell = row.getCell(0);
            cell.setCellType(CellType.STRING);
            String name = cell.getStringCellValue();

            XSSFCell cel1Name = row.getCell(1);
            cel1Name.setCellType(CellType.STRING);
            String sex = cel1Name.getStringCellValue();

            XSSFCell cel12 = row.getCell(2);
            Date birthday = cel12.getDateCellValue();

            User user = new User();
            user.setSex(name);
            user.setName(sex);
            user.setBirthday(birthday);

            service.saveUser(user);

        }
        return "redirect:userList";
    }

    @RequestMapping("/exp")
    @ResponseBody
    public String exp(){
        List<User> userList = service.userList();
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet();
        for(int i=0;i<userList.size();i++){
            XSSFRow row=sheet.createRow(i);
            row.createCell(0).setCellValue(userList.get(i).getId());
            row.createCell(1).setCellValue(userList.get(i).getName());
            row.createCell(2).setCellValue(userList.get(i).getSex());
            row.createCell(3).setCellValue(userList.get(i).getBirthday());
        }
        try {
            FileOutputStream fos =new FileOutputStream("C:\\Users\\ibm\\Desktop\\user.xlsx");
            wb.write(fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "ok";
    }
}
