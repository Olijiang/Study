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
@TableName("t_oplog")
@ApiModel(value = "Oplog对象", description = "")
public class Oplog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("添加日期")
    private LocalDate addDate;

    @ApiModelProperty("操作内容")
    private String operate;

    @ApiModelProperty("操作员ID")
    private Integer adminid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public LocalDate getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDate addDate) {
        this.addDate = addDate;
    }
    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }
    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    @Override
    public String toString() {
        return "Oplog{" +
            "id=" + id +
            ", addDate=" + addDate +
            ", operate=" + operate +
            ", adminid=" + adminid +
        "}";
    }
}
