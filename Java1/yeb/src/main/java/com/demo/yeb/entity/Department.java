package com.demo.yeb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("t_department")
@ApiModel(value = "Department对象", description = "")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("部门名称")
    private String name;

    @ApiModelProperty("父id")
    private Integer parentId;

    @ApiModelProperty("路径")
    private String depPath;

    @ApiModelProperty("是否启用")
    private Boolean enabled;

    @ApiModelProperty("是否上级")
    private Boolean isParent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    public String getDepPath() {
        return depPath;
    }

    public void setDepPath(String depPath) {
        this.depPath = depPath;
    }
    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    public Boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }

    @Override
    public String toString() {
        return "Department{" +
            "id=" + id +
            ", name=" + name +
            ", parentId=" + parentId +
            ", depPath=" + depPath +
            ", enabled=" + enabled +
            ", isParent=" + isParent +
        "}";
    }
}
