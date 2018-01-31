package com.guigu.instructional.po;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

public class EvaluationInfo {
    private Integer evaluationId;

    @Min(value=1,message="{studentId.error}")
    private Integer studentId;

    private String evaluationTile;

    @NotEmpty(message="{evaluationContent.isNull}")
    private String evaluationContent;

    private String evaluationCourse;

    @NotEmpty(message="{evaluationTeacher.isNull}")
    private String evaluationTeacher;

    @Past(message="{evaluationTime.past}")
    private Date evaluationTime;

    public Integer getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(Integer evaluationId) {
        this.evaluationId = evaluationId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getEvaluationTile() {
        return evaluationTile;
    }

    public void setEvaluationTile(String evaluationTile) {
        this.evaluationTile = evaluationTile == null ? null : evaluationTile.trim();
    }

    public String getEvaluationContent() {
        return evaluationContent;
    }

    public void setEvaluationContent(String evaluationContent) {
        this.evaluationContent = evaluationContent == null ? null : evaluationContent.trim();
    }

    public String getEvaluationCourse() {
        return evaluationCourse;
    }

    public void setEvaluationCourse(String evaluationCourse) {
        this.evaluationCourse = evaluationCourse == null ? null : evaluationCourse.trim();
    }

    public String getEvaluationTeacher() {
        return evaluationTeacher;
    }

    public void setEvaluationTeacher(String evaluationTeacher) {
        this.evaluationTeacher = evaluationTeacher == null ? null : evaluationTeacher.trim();
    }

    public Date getEvaluationTime() {
        return evaluationTime;
    }

    public void setEvaluationTime(Date evaluationTime) {
        this.evaluationTime = evaluationTime;
    }
}