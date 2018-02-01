package com.guigu.instructional.po;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SyllabusInfo {
    private Integer syllabusId;
    @NotEmpty(message="{SyllabusInfo.syllabusYi.notnull}")
    private String syllabusYi;
    @NotEmpty(message="{SyllabusInfo.syllabusEr.notnull}")
    private String syllabusEr;
    @NotEmpty(message="{SyllabusInfo.syllabusSan.notnull}")
    private String syllabusSan;
    @NotEmpty(message="{SyllabusInfo.syllabusSi.notnull}")
    private String syllabusSi;
    @NotEmpty(message="{SyllabusInfo.syllabusWu.notnull}")
    private String syllabusWu;
    @NotEmpty(message="{SyllabusInfo.syllabusLiu.notnull}")
    private String syllabusLiu;
    @NotEmpty(message="{SyllabusInfo.syllabusQi.notnull}")
    private String syllabusQi;

    private String syllabusIsused;

    @Size(min=1,max=30,message="{SyllabusInfo.syllabusName.length.error}")
    @NotEmpty(message="{SyllabusInfo.syllabusName.notnull}")
    private String syllabusName;
    
    public Integer getSyllabusId() {
        return syllabusId;
    }

    public void setSyllabusId(Integer syllabusId) {
        this.syllabusId = syllabusId;
    }

    public String getSyllabusYi() {
        return syllabusYi;
    }

    public void setSyllabusYi(String syllabusYi) {
        this.syllabusYi = syllabusYi == null ? null : syllabusYi.trim();
    }

    public String getSyllabusEr() {
        return syllabusEr;
    }

    public void setSyllabusEr(String syllabusEr) {
        this.syllabusEr = syllabusEr == null ? null : syllabusEr.trim();
    }

    public String getSyllabusSan() {
        return syllabusSan;
    }

    public void setSyllabusSan(String syllabusSan) {
        this.syllabusSan = syllabusSan == null ? null : syllabusSan.trim();
    }

    public String getSyllabusSi() {
        return syllabusSi;
    }

    public void setSyllabusSi(String syllabusSi) {
        this.syllabusSi = syllabusSi == null ? null : syllabusSi.trim();
    }

    public String getSyllabusWu() {
        return syllabusWu;
    }

    public void setSyllabusWu(String syllabusWu) {
        this.syllabusWu = syllabusWu == null ? null : syllabusWu.trim();
    }

    public String getSyllabusLiu() {
        return syllabusLiu;
    }

    public void setSyllabusLiu(String syllabusLiu) {
        this.syllabusLiu = syllabusLiu == null ? null : syllabusLiu.trim();
    }

    public String getSyllabusQi() {
        return syllabusQi;
    }

    public void setSyllabusQi(String syllabusQi) {
        this.syllabusQi = syllabusQi == null ? null : syllabusQi.trim();
    }

    public String getSyllabusIsused() {
        return syllabusIsused;
    }

    public void setSyllabusIsused(String syllabusIsused) {
        this.syllabusIsused = syllabusIsused == null ? null : syllabusIsused.trim();
    }

    public String getSyllabusName() {
        return syllabusName;
    }

    public void setSyllabusName(String syllabusName) {
        this.syllabusName = syllabusName == null ? null : syllabusName.trim();
    }
}