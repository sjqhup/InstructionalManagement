package com.guigu.instructional.finance.service;

import java.util.List;

import com.guigu.instructional.po.StaffSalary;
import com.guigu.instructional.po.StaffSalaryOrder;

//����ʵ��Ա�����ʵ�service
public interface SalaryService {

	public boolean addSalary(StaffSalary staffSalary) ;
	
	public boolean updateSalary(StaffSalary staffSalary);
	
	public List<StaffSalaryOrder> findSalaryForList(StaffSalaryOrder staffSalaryOrder);
	
	public StaffSalaryOrder findSalaryOrderById(Integer staffSalaryId);
	
	public StaffSalary findSalaryById(Integer staffSalaryId);
	
	public boolean deleteSalary(Integer staffSalaryId);
}
