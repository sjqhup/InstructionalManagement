package com.guigu.instructional.market.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.market.mapper.MarketActiveStaffMapper;
import com.guigu.instructional.market.service.MarketActiveService;
import com.guigu.instructional.po.EmailInfo;
import com.guigu.instructional.po.EmailInfoStaff;
import com.guigu.instructional.po.MarketActive;
import com.guigu.instructional.po.MarketActiveStaff;
import com.guigu.instructional.po.MessageInfoStaffVO;

@Controller
@RequestMapping("/marketactive/marketactive")
public class MarketActiveController {

	
	@Resource(name="marketActiveServiceImpl")
	private MarketActiveService marketActiveService;
	
	@Resource(name="marketActiveStaffMapper")
	private MarketActiveStaffMapper marketActiveStaffMapper;
	
	@RequestMapping("list.action")
	public String list(MessageInfoStaffVO messageInfoStaffVO,Model model) {
		List<MarketActiveStaff> list =marketActiveStaffMapper.findMarketActiveStaffList(messageInfoStaffVO);
		System.out.println(list);
	    model.addAttribute("list", list);
	    return "marketactive/marketactive/marketactive_list";
	}
	
	@RequestMapping("query.action")
	public String query(MessageInfoStaffVO messageInfoStaffVO,Model model) {
		List<MarketActiveStaff> list = marketActiveStaffMapper.queryMarketActiveStaffList(messageInfoStaffVO);
		model.addAttribute("list", list);
	    return "marketactive/marketactive/marketactive_list";
	}
	
	@RequestMapping("look.action")
    public String lookMarketActive(Integer activeId,Model model) {
		MarketActive marketActive =marketActiveService.getMarketActive(activeId);
		System.out.println(marketActive+"--look----");
        model.addAttribute("marketActive", marketActive);
        return "marketactive/marketactive/marketactive_update";
    }
	
	@RequestMapping("delete.action")
    public String deleteMarketActive(MarketActive marketActive,Model model) {
        //״̬Ϊ"0"��Ч
		marketActive.setActiveState(0);
        boolean result =marketActiveService.updateMarketActive(marketActive);
        if(result) {
            model.addAttribute("info", "ɾ���ɹ�");
        }else {
            model.addAttribute("info", "ɾ��ʧ��");
        }
        return this.list(null, model);
    }
	
	@RequestMapping("send.action")
	public String addMarketActive(@Validated MarketActive marketActive,BindingResult bindingResult,Model model) throws Exception{
		
		//��ȡУ�������Ϣ
        if(bindingResult.hasErrors()) {
            //���������Ϣ
            List<ObjectError> allErrors=bindingResult.getAllErrors();
            //��������Ϣ���ݵ�ҳ��
            model.addAttribute("allErrors", allErrors);
            
            //ͨ��model�����ٴδ�������
            model.addAttribute("marketActive", marketActive);
            
            //ת������Ʒ�޸�ҳ��
            return "marketactive/marketactive/marketactive_add";
        }
		
		
		//״̬Ϊ��1����Ч
		marketActive.setActiveState(1);
		boolean result = marketActiveService.sendMarketActive(marketActive);
		if(result) {
			model.addAttribute("info", "��ӳɹ�");
		}else {
			model.addAttribute("info", "���ʧ��");
		}
		return this.list(null, model);
	}
	
}
