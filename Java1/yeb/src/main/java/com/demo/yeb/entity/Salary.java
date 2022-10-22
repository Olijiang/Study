package com.demo.yeb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author ZGB
 * @since 2022-10-20
 */
@TableName("t_salary")
@ApiModel(value = "Salary对象", description = "")
public class Salary implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("基本工资")
    private Integer basicSalary;

    @ApiModelProperty("奖金")
    private Integer bonus;

    @ApiModelProperty("午餐补助")
    private Integer lunchSalary;

    @ApiModelProperty("交通补助")
    private Integer trafficSalary;

    @ApiModelProperty("应发工资")
    private Integer allSalary;

    @ApiModelProperty("养老金基数")
    private Integer pensionBase;

    @ApiModelProperty("养老金比率")
    private Float pensionPer;

    @ApiModelProperty("启用时间")
    private LocalDateTime createDate;

    @ApiModelProperty("医疗基数")
    private Integer medicalBase;

    @ApiModelProperty("医疗保险比率")
    private Float medicalPer;

    @ApiModelProperty("公积金基数")
    private Integer accumulationFundBase;

    @ApiModelProperty("公积金比率")
    private Float accumulationFundPer;

    @ApiModelProperty("名称")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Integer basicSalary) {
        this.basicSalary = basicSalary;
    }
    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }
    public Integer getLunchSalary() {
        return lunchSalary;
    }

    public void setLunchSalary(Integer lunchSalary) {
        this.lunchSalary = lunchSalary;
    }
    public Integer getTrafficSalary() {
        return trafficSalary;
    }

    public void setTrafficSalary(Integer trafficSalary) {
        this.trafficSalary = trafficSalary;
    }
    public Integer getAllSalary() {
        return allSalary;
    }

    public void setAllSalary(Integer allSalary) {
        this.allSalary = allSalary;
    }
    public Integer getPensionBase() {
        return pensionBase;
    }

    public void setPensionBase(Integer pensionBase) {
        this.pensionBase = pensionBase;
    }
    public Float getPensionPer() {
        return pensionPer;
    }

    public void setPensionPer(Float pensionPer) {
        this.pensionPer = pensionPer;
    }
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
    public Integer getMedicalBase() {
        return medicalBase;
    }

    public void setMedicalBase(Integer medicalBase) {
        this.medicalBase = medicalBase;
    }
    public Float getMedicalPer() {
        return medicalPer;
    }

    public void setMedicalPer(Float medicalPer) {
        this.medicalPer = medicalPer;
    }
    public Integer getAccumulationFundBase() {
        return accumulationFundBase;
    }

    public void setAccumulationFundBase(Integer accumulationFundBase) {
        this.accumulationFundBase = accumulationFundBase;
    }
    public Float getAccumulationFundPer() {
        return accumulationFundPer;
    }

    public void setAccumulationFundPer(Float accumulationFundPer) {
        this.accumulationFundPer = accumulationFundPer;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Salary{" +
            "id=" + id +
            ", basicSalary=" + basicSalary +
            ", bonus=" + bonus +
            ", lunchSalary=" + lunchSalary +
            ", trafficSalary=" + trafficSalary +
            ", allSalary=" + allSalary +
            ", pensionBase=" + pensionBase +
            ", pensionPer=" + pensionPer +
            ", createDate=" + createDate +
            ", medicalBase=" + medicalBase +
            ", medicalPer=" + medicalPer +
            ", accumulationFundBase=" + accumulationFundBase +
            ", accumulationFundPer=" + accumulationFundPer +
            ", name=" + name +
        "}";
    }
}
