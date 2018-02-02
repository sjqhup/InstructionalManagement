package com.guigu.instructional.po;

public class AuditionCustom {
	//这个是自定义的试听记录po  po要根据学生名字以及试听课程得到
	//自定义一个po类  这样就不用写mapper  在这个po里面自定义方法去根据其他信息得到对应的信息
	private AuditionInfo auditionInfo;
	private String disciplineName;

	private String studentName;

	public AuditionInfo getAuditionInfo() {
		return auditionInfo;
	}

	public void setAuditionInfo(AuditionInfo auditionInfo) {
		this.auditionInfo = auditionInfo;
	}

	public String getDisciplineName() {
		return disciplineName;
	}

	public void setDisciplineName(String disciplineName) {
		this.disciplineName = disciplineName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	
	//获得对应的课程名字 以及设置名字为了在查询中调用对应数据

	
	
	
	

}
