package com.ujiuye.test;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Demo {
    //创建sheet表
    public static void main1(String[] args) throws Exception {
       XSSFWorkbook xw = new XSSFWorkbook();
       XSSFSheet sheet= xw.createSheet();
        XSSFRow row = sheet.createRow(2);
        XSSFCell cell =row.createCell(2);
        cell.setCellValue("测试");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\ibm\\Desktop\\demo.xlsx");
        xw.write(fos);
    }
//读取
    public static void main2(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("C:\\Users\\ibm\\Desktop\\demo.xlsx");
        XSSFWorkbook xw  = new XSSFWorkbook(fis);
        XSSFSheet sheet = xw.getSheetAt(0);
        XSSFRow row = sheet.getRow(2);
        XSSFCell cell = row.getCell(2);
        String value = cell.getStringCellValue();
        System.out.print(value);

    }

    public static void main3(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("C:\\Users\\ibm\\Desktop\\demo.xlsx");
        Workbook sheets = WorkbookFactory.create(fis);
        Sheet sheet = sheets.getSheetAt(0);
        Row row = sheet.getRow(2);
        Cell cell = row.getCell(2);
        String value = cell.getStringCellValue();
        System.out.println(value);
    }

    public static void main(String[] args) throws Exception {
        String filePath="C:\\Users\\ibm\\Desktop\\demo.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        //物理行数
        int rows = sheet.getPhysicalNumberOfRows();
        for (int i = 0 ; i<rows;i++){
            XSSFRow row = sheet.getRow(i);
            //当前行的单元格的数量
            int cells = row.getPhysicalNumberOfCells();
            for (int j = 0 ;  j < cells ; j++){
                XSSFCell cell = row.getCell(j);
                cell.setCellType(CellType.STRING);
                String value = cell.getStringCellValue();
                System.out.print(value +"   ");
            }
            System.out.println();
        }

    }
}
