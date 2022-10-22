package com.demo.yeb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
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
@TableName("t_salary_adjust")
@ApiModel(value = "SalaryAdjust对象", description = "")
public class SalaryAdjust implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("员工ID")
    private Integer eid;

    @ApiModelProperty("调薪日期")
    private LocalDate asDate;

    @ApiModelProperty("调前薪资")
    private Integer beforeSalary;

    @ApiModelProperty("调后薪资")
    private Integer afterSalary;

    @ApiModelProperty("调薪原因")
    private String reason;

    @ApiModelProperty("备注")
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }
    public LocalDate getAsDate() {
        return asDate;
    }

    public void setAsDate(LocalDate asDate) {
        this.asDate = asDate;
    }
    public Integer getBeforeSalary() {
        return beforeSalary;
    }

    public void setBeforeSalary(Integer beforeSalary) {
        this.beforeSalary = beforeSalary;
    }
    public Integer getAfterSalary() {
        return afterSalary;
    }

    public void setAfterSalary(Integer afterSalary) {
        this.afterSalary = afterSalary;
    }
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "SalaryAdjust{" +
            "id=" + id +
            ", eid=" + eid +
            ", asDate=" + asDate +
            ", beforeSalary=" + beforeSalary +
            ", afterSalary=" + afterSalary +
            ", reason=" + reason +
            ", remark=" + remark +
        "}";
    }
}
