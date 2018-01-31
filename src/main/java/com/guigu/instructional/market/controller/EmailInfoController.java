package com.guigu.instructional.market.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guigu.instructional.market.mapper.EmailInfoStaffMapper;
import com.guigu.instructional.market.service.EmailInfoService;
import com.guigu.instructional.po.EmailInfo;
import com.guigu.instructional.po.EmailInfoStaff;
import com.guigu.instructional.po.MessageInfoStaffVO;
import com.guigu.instructional.po.TemplateInfo;
import com.guigu.instructional.system.service.StaffInfoService;

@Controller
@RequestMapping("/marketactive/emailinfo")
public class EmailInfoController {

	@Resource(name="staffInfoServiceImpl")
    private StaffInfoService staffInfoService;
	
	@Resource(name="emailInfoServiceImpl")
	private EmailInfoService emailInfoService ;
	
	@Resource(name="emailInfoStaffMapper")
	private EmailInfoStaffMapper emailInfoStaffMapper;
	
//	@Resource(name="templateinfoServiceImpl")
//	private TemplateinfoService templateinfoService;
	
	@RequestMapping("list.action")
	public String list(MessageInfoStaffVO messageInfoStaffVO,Model model) {
		List<EmailInfoStaff> list =emailInfoStaffMapper.findEmailInfoStaffList(messageInfoStaffVO);
		System.out.println(list);
	    model.addAttribute("list", list);
	    return "marketactive/emailinfo/emailinfo_list";
	}
	
	@RequestMapping("query.action")
	public String query(MessageInfoStaffVO messageInfoStaffVO,Model model) {
		List<EmailInfoStaff> list = emailInfoStaffMapper.queryEmailInfoStaff(messageInfoStaffVO);
		model.addAttribute("list", list);
	    return "marketactive/emailinfo/emailinfo_list";
	}
	
	@RequestMapping("look.action")
    public String lookEmailInfo(Integer emailId,Model model) {
		EmailInfo emailInfo =emailInfoService.getEmailInfo(emailId);
        model.addAttribute("emailInfo", emailInfo);
        return "marketactive/emailinfo/emailinfo_show";
    }
	
	@RequestMapping("delete.action")
    public String deleteEmailInfo(EmailInfo emailInfo,Model model) {
        //״̬Ϊ"0"��Ч
		emailInfo.setEmailState("0");
        boolean result =emailInfoService.updateEmailInfo(emailInfo);
        if(result) {
            model.addAttribute("info", "ɾ���ɹ�");
        }else {
            model.addAttribute("info", "ɾ��ʧ��");
        }
        return this.list(null, model);
    }
	
	@RequestMapping("send.action")
	public  String addEmailInfo( EmailInfo emailInfo,Model model) {
		
		//״̬Ϊ��1����Ч
		emailInfo.setEmailState("1");
		boolean result = emailInfoService.sendEmailInfo(emailInfo);
		if(result) {
			model.addAttribute("info", "���ͳɹ�");
		}else {
			model.addAttribute("info", "����ʧ��");
		}
		return this.list(null, model);
	}
	
	
	@RequestMapping("submit.action")
	public  String submitEmailInfo(@Validated EmailInfo emailInfo,BindingResult bindingResult,Model model)  throws Exception {
		
		//��ȡУ�������Ϣ
        if(bindingResult.hasErrors()) {
            //���������Ϣ
            List<ObjectError> allErrors=bindingResult.getAllErrors();
            //��������Ϣ���ݵ�ҳ��
            model.addAttribute("allErrors", allErrors);
            
            
            //ͨ��model�����ٴδ�������
            model.addAttribute("emailInfo", emailInfo);
            
            //ת������Ʒ�޸�ҳ��
            return "marketactive/emailinfo/emailinfo_send";
        }
        
       /* List<TemplateInfo> list = templateinfoService.getTemplateinfoList(templateInfo);
        for (int i = 0; i < list.size(); i++) {
        		System.out.println(list.get(i).getTemplateContent());
        		System.out.println(list.get(i).getTemplateType());
        	
        }*/
    	//״̬Ϊ��1����Ч
  		emailInfo.setEmailState("1");
  		boolean result = emailInfoService.sendEmailInfo(emailInfo);
  		if(result) {
  			model.addAttribute("info", "���ͳɹ�");
  		}else {
  			model.addAttribute("info", "����ʧ��");
  		}
  		return this.list(null, model);
	}
	
}
