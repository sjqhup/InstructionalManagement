package com.guigu.instructional.po;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class StudentInfo {
    private Integer studentId;
    
    @Min(value=1,message="{staffid.error}")
    private Integer staffId;
 
    private Integer classId;
    
    @NotEmpty(message="{studentName.isNull}")
    private String studentName;

    private String studentSex;
    
    @Min(value=0,message="{studentAge.young}")
    @Max(value=150,message="{studentAge.old}")
    private Integer studentAge;

    @Size(min=11,max=11,message="{studentTellphone.length.error}")
    private String studentTellphone;
    @Email(message="{studentEmail.error}")
    private String studentEmail;

    @Size(min=18,max=18,message="{studentIdcard.length.error}")
    private String studentIdcard;

    private String studentAddress;

    @Past(message="{studentBirthday.past}")
    private Date studentBirthday;

    private String studentSchool;

    private String studentQq;
    
    @NotEmpty(message="{studentParentsName.isNull}")
    private String studentParentsName;
    @Size(min=11,max=11,message="{studentParentsPhone.length.error}")
    private String studentParentsPhone;

    private String studentPro;

    private String studentProCity;

    private String studentType;

    private String studentIspay;

    private Integer studentState;

    private String studentMark;

    private String studentDesc;

    private String studentNumber;

    private String studentPassword;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex == null ? null : studentSex.trim();
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentTellphone() {
        return studentTellphone;
    }

    public void setStudentTellphone(String studentTellphone) {
        this.studentTellphone = studentTellphone == null ? null : studentTellphone.trim();
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail == null ? null : studentEmail.trim();
    }

    public String getStudentIdcard() {
        return studentIdcard;
    }

    public void setStudentIdcard(String studentIdcard) {
        this.studentIdcard = studentIdcard == null ? null : studentIdcard.trim();
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress == null ? null : studentAddress.trim();
    }

    public Date getStudentBirthday() {
        return studentBirthday;
    }

    public void setStudentBirthday(Date studentBirthday) {
        this.studentBirthday = studentBirthday;
    }

    public String getStudentSchool() {
        return studentSchool;
    }

    public void setStudentSchool(String studentSchool) {
        this.studentSchool = studentSchool == null ? null : studentSchool.trim();
    }

    public String getStudentQq() {
        return studentQq;
    }

    public void setStudentQq(String studentQq) {
        this.studentQq = studentQq == null ? null : studentQq.trim();
    }

    public String getStudentParentsName() {
        return studentParentsName;
    }

    public void setStudentParentsName(String studentParentsName) {
        this.studentParentsName = studentParentsName == null ? null : studentParentsName.trim();
    }

    public String getStudentParentsPhone() {
        return studentParentsPhone;
    }

    public void setStudentParentsPhone(String studentParentsPhone) {
        this.studentParentsPhone = studentParentsPhone == null ? null : studentParentsPhone.trim();
    }

    public String getStudentPro() {
        return studentPro;
    }

    public void setStudentPro(String studentPro) {
        this.studentPro = studentPro == null ? null : studentPro.trim();
    }

    public String getStudentProCity() {
        return studentProCity;
    }

    public void setStudentProCity(String studentProCity) {
        this.studentProCity = studentProCity == null ? null : studentProCity.trim();
    }

    public String getStudentType() {
        return studentType;
    }

    public void setStudentType(String studentType) {
        this.studentType = studentType == null ? null : studentType.trim();
    }

    public String getStudentIspay() {
        return studentIspay;
    }

    public void setStudentIspay(String studentIspay) {
        this.studentIspay = studentIspay == null ? null : studentIspay.trim();
    }

    public Integer getStudentState() {
        return studentState;
    }

    public void setStudentState(Integer studentState) {
        this.studentState = studentState;
    }

    public String getStudentMark() {
        return studentMark;
    }

    public void setStudentMark(String studentMark) {
        this.studentMark = studentMark == null ? null : studentMark.trim();
    }

    public String getStudentDesc() {
        return studentDesc;
    }

    public void setStudentDesc(String studentDesc) {
        this.studentDesc = studentDesc == null ? null : studentDesc.trim();
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber == null ? null : studentNumber.trim();
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword == null ? null : studentPassword.trim();
    }
}