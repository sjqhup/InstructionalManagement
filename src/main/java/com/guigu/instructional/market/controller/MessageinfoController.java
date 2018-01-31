package com.guigu.instructional.market.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.market.mapper.MessageInfoStaffMapper;
import com.guigu.instructional.market.service.MessageinfoService;
import com.guigu.instructional.po.EmailInfoStaff;
import com.guigu.instructional.po.MessageInfo;
import com.guigu.instructional.po.MessageInfoStaff;
import com.guigu.instructional.po.MessageInfoStaffVO;
import com.guigu.instructional.system.service.StaffInfoService;

@Controller
@RequestMapping("/marketactive/messafeinfo")
public class MessageinfoController {

	@Resource(name="staffInfoServiceImpl")
    private StaffInfoService staffInfoService;
	
	@Resource(name="messageinfoServiceImpl")
	private MessageinfoService messageinfoService ;
	
	@Resource(name="messageInfoStaffMapper")
	private MessageInfoStaffMapper messageInfoStaffMapper;
	
	@RequestMapping("list.action")
	public String list(MessageInfoStaffVO messageInfoStaffVO,Model model) {
		List<MessageInfoStaff> list =messageInfoStaffMapper.findMessageInfoStaffList(messageInfoStaffVO);
		System.out.println(list);
	    model.addAttribute("list", list);
	    return "marketactive/messafeinfo/messafeinfo_list";
	}
//    public String list(MessageInfo messageInfo,Model model) {
//        List<MessageInfo> list =messageinfoService.getMessageinfoList(messageInfo);
//        model.addAttribute("list", list);
//        return "marketactive/messafeinfo/messafeinfo_list";
//    }
	
	@RequestMapping("query.action")
	public String query(MessageInfoStaffVO messageInfoStaffVO,Model model) {
		List<MessageInfoStaff> list = messageInfoStaffMapper.queryMessageInfoStaffList(messageInfoStaffVO);
		model.addAttribute("list", list);
	    return "marketactive/messafeinfo/messafeinfo_list";
	}
	
	@RequestMapping("look.action")
    public String lookMessageInfo(Integer messageId1,Model model) {
		MessageInfo messageInfo =messageinfoService.getMessageinfo(messageId1);
        model.addAttribute("messageInfo", messageInfo);
        return "marketactive/messafeinfo/messafeinfo_show";
    }
	
	@RequestMapping("delete.action")
    public String deleteMessageInfo(MessageInfo messageInfo,Model model) {
        //״̬Ϊ"0"��Ч
		messageInfo.setMessageState("0");
        boolean result =messageinfoService.updateMessageinfo(messageInfo);
        if(result) {
            model.addAttribute("info", "ɾ���ɹ�");
        }else {
            model.addAttribute("info", "ɾ��ʧ��");
        }
        return this.list(null, model);
    }
	
	@RequestMapping("send.action")
	public String addMessageInfo(Model model,@Validated MessageInfo messageInfo,BindingResult bindingResult) throws Exception{
		
		//��ȡУ�������Ϣ
        if(bindingResult.hasErrors()) {
            //���������Ϣ
            List<ObjectError> allErrors=bindingResult.getAllErrors();
            //��������Ϣ���ݵ�ҳ��
            model.addAttribute("allErrors", allErrors);
            
            //ͨ��model�����ٴδ�������
            model.addAttribute("messageInfo", messageInfo);
            
            //ת������Ʒ�޸�ҳ��
            return "marketactive/messafeinfo/messafeinfo_send";
        }
		
		
		//״̬Ϊ��1����Ч
		messageInfo.setMessageState("1");
		boolean result = messageinfoService.sendMessageinfo(messageInfo);
		if(result) {
			model.addAttribute("info", "���ͳɹ�");
		}else {
			model.addAttribute("info", "����ʧ��");
		}
		return this.list(null, model);
	}
	
}
