package com.guigu.instructional.system.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.guigu.instructional.po.DataDictionary;
import com.guigu.instructional.po.ExportExcelUtils;
import com.guigu.instructional.system.service.DataDictionaryService;
import com.mysql.jdbc.Field;

@Controller
@RequestMapping("/system/datadictionary/")
public class DataDictionaryController {

	@Resource(name="dataDictionaryServicrImpl")
	public DataDictionaryService dataDictionaryService;
	
	@RequestMapping("list.action")
	public String listDataDictionary(DataDictionary dataDictionary,Model model) {
		List<DataDictionary> list=dataDictionaryService.findDataDictionaryList(dataDictionary);
		model.addAttribute("list",list);
		return "system/datadictionary/datadictionary_list";
	}
	@RequestMapping("add.action")
	public String addDataDictionary(DataDictionary dataDictionary,Model model) {
		boolean result=dataDictionaryService.addDateDictionary(dataDictionary);
		if(result) {
			model.addAttribute("info","��ӳɹ�");
		}else {
			model.addAttribute("info","���ʧ��");
		}
		return this.listDataDictionary(null, model);
	}
	@RequestMapping("load.action")
	public String loadUpdate(Integer dataId,Model model) {
		DataDictionary dataDictionary=dataDictionaryService.findDataDictionary(dataId);
		model.addAttribute("dataDictionary",dataDictionary);
		return "system/datadictionary/datadictionary_update";
	}
	@RequestMapping("update.action")
	public String updateDataDictionary(DataDictionary dataDictionary,Model model) {
		boolean result=dataDictionaryService.updateDataDictionary(dataDictionary);
		if(result) {
			model.addAttribute("info","���³ɹ�");
		}else {
			model.addAttribute("info","����ʧ��");
		}
		return this.listDataDictionary(null, model);
	}
	
	@RequestMapping("delete.action")
	public String deleteDataDictionary(Integer dataId,Model model) {
		boolean result=dataDictionaryService.deleteDataDictionary(dataId);
		if(result) {
			model.addAttribute("info","ɾ���ɹ�");
		}else {
			model.addAttribute("info","ɾ��ʧ��");
		}
		return this.listDataDictionary(null, model);
	}
	@RequestMapping("downloadsql.action")
	public void download(HttpServletRequest request,HttpServletResponse response) throws Exception {  
		    
		    request.setCharacterEncoding("UTF-8");  
		    BufferedInputStream bis = null;  
		    BufferedOutputStream bos = null;  
		  
		    //��ȡ��Ŀ��Ŀ¼
		    String ctxPath = request.getSession().getServletContext().getRealPath("");  
		    System.out.println(ctxPath);
		    //��ȡ�����ļ�¶��
		    String downLoadPath = ctxPath+"/download/"+ "create_table.sql";  

		    //�����ļ��������
		    response.setContentType("application/octet-stream");  
		    response.setHeader("Content-disposition", "attachment; filename="+ new String("create_table.sql".getBytes("utf-8"), "ISO8859-1")); 

		    //��ȡ������
		    bis = new BufferedInputStream(new FileInputStream(downLoadPath));  
		    //�����
		    bos = new BufferedOutputStream(response.getOutputStream());  
		    byte[] buff = new byte[2048];  
		    int bytesRead;  
		    while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
		      bos.write(buff, 0, bytesRead);  
		    }  
		    //�ر���
		    bis.close();  
		    bos.close();  
		  }  
	@RequestMapping("downloadsql2.action")
	public void download2(HttpServletRequest request,HttpServletResponse response) throws Exception {  
		    
		    request.setCharacterEncoding("UTF-8");  
		    BufferedInputStream bis = null;  
		    BufferedOutputStream bos = null;  
		  
		    //��ȡ��Ŀ��Ŀ¼
		    String ctxPath = request.getSession().getServletContext().getRealPath("");  
		    System.out.println(ctxPath);
		    //��ȡ�����ļ�¶��
		    String downLoadPath = ctxPath+"/download/"+ "���ݹ�Ƚ������.pdm";  

		    //�����ļ��������
		    response.setContentType("application/octet-stream");  
		    response.setHeader("Content-disposition", "attachment; filename="+ new String("���ݹ�Ƚ������.pdm".getBytes("utf-8"), "ISO8859-1")); 

		    //��ȡ������
		    bis = new BufferedInputStream(new FileInputStream(downLoadPath));  
		    //�����
		    bos = new BufferedOutputStream(response.getOutputStream());  
		    byte[] buff = new byte[2048];  
		    int bytesRead;  
		    while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
		      bos.write(buff, 0, bytesRead);  
		    }  
		    //�ر���
		    bis.close();  
		    bos.close();  
		  }  
	
	  @RequestMapping("upload.action")
	  public String upload(Model model,HttpServletRequest request,@RequestParam("description") String description,@RequestParam("file") MultipartFile file) throws Exception {
	        System.out.println(description);
	        //����ļ���Ϊ�գ�д���ϴ�·��
	        if(!file.isEmpty()) {
	            //�ϴ��ļ�·��
	            String path = request.getServletContext().getRealPath("/upload/");
	            //�ϴ��ļ���
	            String filename = file.getOriginalFilename();
	            File filepath = new File(path,filename);
	            //�ж�·���Ƿ���ڣ���������ھʹ���һ��
	            if (!filepath.getParentFile().exists()) { 
	                filepath.getParentFile().mkdirs();
	            }
	            //���ϴ��ļ����浽һ��Ŀ���ļ�����
	            file.transferTo(new File(path + File.separator + filename));
	            return this.listDataDictionary(null, model);
	        } else {
	        	return "system/datadictionary/upload";
	        }

	     }
	  
	  @RequestMapping("export.action")
	  public ModelAndView exportExcel(HttpServletRequest request,HttpServletResponse response){  
	        try {  
	            DataDictionary dataDictionary=new DataDictionary();  
	            // ����û�����  
	            List<DataDictionary> datalist = dataDictionaryService.findDataDictionaryList(null);  
	            String title ="����ģ���";  
	            String[] rowsName=new String[]{"���","ID","����","����","����"};  
	            List<Object[]>  dataList = new ArrayList<Object[]>();  
	            Object[] objs = null;  
	            for (int i = 0; i < datalist.size(); i++) {  
	                DataDictionary data =datalist.get(i);  
	                objs = new Object[rowsName.length];  
	                objs[0] = i;  
	                objs[1] = data.getDataId();
	                objs[2] = data.getDataType();
	                objs[3] = data.getDataDesc();
	                objs[4] = data.getDataContent();
	                dataList.add(objs);  
	            }  
	            //   
	            ExportExcelUtils ex =new ExportExcelUtils(title, rowsName, dataList,response);  
	            ex.exportData();  
	              
	              
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	          
	        return null;  
	    }   
		   
}
	
