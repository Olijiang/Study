package eva.kafka.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author ZGB
 * @since 2022-11-02
 */
@TableName("taxi_trans")
@ApiModel(value = "TaxiTrans对象", description = "")
public class TaxiTrans implements Serializable {

    private static final long serialVersionUID = 1L;

    private String areaId;

    private Integer perhalfNum;

    private LocalDateTime updateTime;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }
    public Integer getPerhalfNum() {
        return perhalfNum;
    }

    public void setPerhalfNum(Integer perhalfNum) {
        this.perhalfNum = perhalfNum;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TaxiTrans{" +
            "areaId=" + areaId +
            ", perhalfNum=" + perhalfNum +
            ", updateTime=" + updateTime +
            ", id=" + id +
        "}";
    }
}
