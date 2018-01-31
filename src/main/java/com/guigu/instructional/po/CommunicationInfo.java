package com.guigu.instructional.po;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

public class CommunicationInfo {
    private Integer communicationId;

    @Min(value=1,message="{studentId.error}")
    private Integer studentId;
    @Min(value=1,message="{staffId.error}")
    private Integer staffId;
    @Past(message="{communicationTime.past}")
    private Date communicationTime;
    @NotEmpty(message="{communicationContent.isNull}")
    private String communicationContent;

    public Integer getCommunicationId() {
        return communicationId;
    }

    public void setCommunicationId(Integer communicationId) {
        this.communicationId = communicationId;
    }

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

    public Date getCommunicationTime() {
        return communicationTime;
    }

    public void setCommunicationTime(Date communicationTime) {
        this.communicationTime = communicationTime;
    }

    public String getCommunicationContent() {
        return communicationContent;
    }

    public void setCommunicationContent(String communicationContent) {
        this.communicationContent = communicationContent == null ? null : communicationContent.trim();
    }
}