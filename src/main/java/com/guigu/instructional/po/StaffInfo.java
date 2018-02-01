package com.guigu.instructional.po;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;




public class StaffInfo {
    private Integer staffId;

    private Integer roleId;
    
    @NotEmpty(message="{items.staffName.notnull}")
    private String staffName;

    private String staffSex;
    
    @Min(value=20,message="{items.staffAge.min.error}")
    @Max(value=60,message="{items.staffAge.max.error}")
    private Integer staffAge;
    
    @NotEmpty(message="{items.staffNativePlace.notnull}")
    private String staffNativePlace;
    
    @Size(min=18,max=18,message="{items.staffIdcard.error}")
    private String staffIdcard;
    
    @Past(message="{items.staffBirthday.past}")
    private Date staffBirthday;

    @Size(min=11,max=12,message="{items.staffOfficePhone.error}")
    private String staffOfficePhone;
    
    @Size(min=11,max=11,message="{items.staffMobilePhone.error}")
    private String staffMobilePhone;

    @Email(message="{items.staffEmail.error}")
    private String staffEmail;
    
    @NotEmpty(message="{items.staffAddr.notnull}")
    private String staffAddr;
    
    @Size(min=5,max=10,message="{items.staffQq.error}")
    private String staffQq;
    
    @Past(message="{items.staffEntryTime.past}")
    private Date staffEntryTime;

    private String staffEducationLevel;
    
    @NotEmpty(message="{items.staffRemark.notEmpty}")
    private String staffRemark;

    private String staffState;
    
    @Size(min=6,max=12,message="{items.staffNumber.error}")
    private String staffNumber;

    @Size(min=6,max=12,message="{items.staffPassword.error}")
    private String staffPassword;

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public String getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(String staffSex) {
        this.staffSex = staffSex == null ? null : staffSex.trim();
    }

    public Integer getStaffAge() {
        return staffAge;
    }

    public void setStaffAge(Integer staffAge) {
        this.staffAge = staffAge;
    }

    public String getStaffNativePlace() {
        return staffNativePlace;
    }

    public void setStaffNativePlace(String staffNativePlace) {
        this.staffNativePlace = staffNativePlace == null ? null : staffNativePlace.trim();
    }

    public String getStaffIdcard() {
        return staffIdcard;
    }

    public void setStaffIdcard(String staffIdcard) {
        this.staffIdcard = staffIdcard == null ? null : staffIdcard.trim();
    }

    public Date getStaffBirthday() {
        return staffBirthday;
    }

    public void setStaffBirthday(Date staffBirthday) {
        this.staffBirthday = staffBirthday;
    }

    public String getStaffOfficePhone() {
        return staffOfficePhone;
    }

    public void setStaffOfficePhone(String staffOfficePhone) {
        this.staffOfficePhone = staffOfficePhone == null ? null : staffOfficePhone.trim();
    }

    public String getStaffMobilePhone() {
        return staffMobilePhone;
    }

    public void setStaffMobilePhone(String staffMobilePhone) {
        this.staffMobilePhone = staffMobilePhone == null ? null : staffMobilePhone.trim();
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail == null ? null : staffEmail.trim();
    }

    public String getStaffAddr() {
        return staffAddr;
    }

    public void setStaffAddr(String staffAddr) {
        this.staffAddr = staffAddr == null ? null : staffAddr.trim();
    }

    public String getStaffQq() {
        return staffQq;
    }

    public void setStaffQq(String staffQq) {
        this.staffQq = staffQq == null ? null : staffQq.trim();
    }

    public Date getStaffEntryTime() {
        return staffEntryTime;
    }

    public void setStaffEntryTime(Date staffEntryTime) {
        this.staffEntryTime = staffEntryTime;
    }

    public String getStaffEducationLevel() {
        return staffEducationLevel;
    }

    public void setStaffEducationLevel(String staffEducationLevel) {
        this.staffEducationLevel = staffEducationLevel == null ? null : staffEducationLevel.trim();
    }

    public String getStaffRemark() {
        return staffRemark;
    }

    public void setStaffRemark(String staffRemark) {
        this.staffRemark = staffRemark == null ? null : staffRemark.trim();
    }

    public String getStaffState() {
        return staffState;
    }

    public void setStaffState(String staffState) {
        this.staffState = staffState == null ? null : staffState.trim();
    }

    public String getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber == null ? null : staffNumber.trim();
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword == null ? null : staffPassword.trim();
    }
}