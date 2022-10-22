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
@TableName("t_menu")
@ApiModel(value = "Menu对象", description = "")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("url")
    private String url;

    @ApiModelProperty("path")
    private String path;

    @ApiModelProperty("组件")
    private String component;

    @ApiModelProperty("菜单名")
    private String name;

    @ApiModelProperty("图标")
    private String iconCls;

    @ApiModelProperty("是否保持激活")
    private Boolean keepAlive;

    @ApiModelProperty("是否要求权限")
    private Boolean requireAuth;

    @ApiModelProperty("父id")
    private Integer parentId;

    @ApiModelProperty("是否启用")
    private Boolean enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }
    public Boolean getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(Boolean keepAlive) {
        this.keepAlive = keepAlive;
    }
    public Boolean getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(Boolean requireAuth) {
        this.requireAuth = requireAuth;
    }
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Menu{" +
            "id=" + id +
            ", url=" + url +
            ", path=" + path +
            ", component=" + component +
            ", name=" + name +
            ", iconCls=" + iconCls +
            ", keepAlive=" + keepAlive +
            ", requireAuth=" + requireAuth +
            ", parentId=" + parentId +
            ", enabled=" + enabled +
        "}";
    }
}
