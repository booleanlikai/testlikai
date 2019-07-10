

import com.xiaoming.test.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;

import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.enmus.ExcelType;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-mybatis.xml"})
//@WebAppConfiguration("src/main/webapp")
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:spring.xml"})
public class basetest {

    @Test
    public void aaa() throws IOException {
        System.out.println("ssss");

//        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("2412312", "测试", "测试"),
//                CourseEntity.class, list);
        List<StudentEntity> lists = new ArrayList<StudentEntity>();
        for (int i = 0; i < 10; i++) {
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setBirthday(new Date());
            studentEntity.setId(i + "");
            studentEntity.setName("姓名" + i);
            studentEntity.setRegistrationDate(new Date());
            studentEntity.setSex(1);
            lists.add(studentEntity);
        }
        List<CourseEntity> list=new ArrayList<CourseEntity>();
        CourseEntity courseEntity=new CourseEntity();
        courseEntity.setName("数学课");
        courseEntity.setStudents(lists);
        courseEntity.setMathTeacher(new TeacherEntity("11","22"));
        list.add(courseEntity);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("2412312",  "测试",ExcelType.XSSF),
                CourseEntity.class, list);
//        FileOutputStream fos = new FileOutputStream("E:/Test.xlsx");
//
////        ExcelExportServer excelExportServer=new ExcelExportServer();
////        Workbook workbook=new HSSFWorkbook();
////        excelExportServer.createSheet(workbook,new ExportParams("计算机一班学生", "学生"),StudentEntity.class,list);
//        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生", "学生", ExcelType.XSSF),
//                StudentEntity.class, list);
        FileOutputStream fos = new FileOutputStream("E:/Test.xlsx");
        workbook.write(fos);
        fos.close();
    }

    @Test
    public void testeee(){
        //第一步创建workbook
        HSSFWorkbook wb = new HSSFWorkbook();

        //第二步创建sheet
        HSSFSheet sheet = wb.createSheet("测试");

        //第三步创建行row:添加表头0行
        HSSFRow row = sheet.createRow(0);
        HSSFCellStyle style = wb.createCellStyle();
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中


        //第四步创建单元格
        HSSFCell cell = row.createCell(0); //第一个单元格
        cell.setCellValue("姓名");
        cell.setCellStyle(style);



        cell = row.createCell(1);         //第二个单元格
        cell.setCellValue("年龄");
        cell.setCellStyle(style);


        //第五步插入数据

        for (int i = 0; i < 5; i++) {
            //创建行
            row = sheet.createRow(i+1);
            //创建单元格并且添加数据
            row.createCell(0).setCellValue("aa"+i);
            row.createCell(1).setCellValue(i);

        }

        //第六步将生成excel文件保存到指定路径下
        try {
            FileOutputStream fout = new FileOutputStream("E:/a.xls");
            wb.write(fout);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Excel文件生成成功...");
    }

    @Test
    public void testclone() throws CloneNotSupportedException {
        classA a=new classA();
        a.setAge("sss");
        a.setCode("ssss");
        a.setName("ssss");
        classB b=new classB();
        b.setAgeb("sss");
        b.setCodeb("sss");
        b.setNameb("sss");
        a.setClassB(b);

        classA aa= (classA) a.clone();
    }


}
