package eva.kafka.entity;

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
 * @since 2022-11-02
 */
@TableName("parking_traffic")
@ApiModel(value = "ParkingTraffic对象", description = "")
public class ParkingTraffic implements Serializable {

    private static final long serialVersionUID = 1L;

    private String busiType;

    private String areaId;

    private Integer inParkingNum;

    private Integer outParkingNum;

    private LocalDateTime updateTime;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    public String getBusiType() {
        return busiType;
    }

    public void setBusiType(String busiType) {
        this.busiType = busiType;
    }
    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }
    public Integer getInParkingNum() {
        return inParkingNum;
    }

    public void setInParkingNum(Integer inParkingNum) {
        this.inParkingNum = inParkingNum;
    }
    public Integer getOutParkingNum() {
        return outParkingNum;
    }

    public void setOutParkingNum(Integer outParkingNum) {
        this.outParkingNum = outParkingNum;
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
        return "ParkingTraffic{" +
            "busiType=" + busiType +
            ", areaId=" + areaId +
            ", inParkingNum=" + inParkingNum +
            ", outParkingNum=" + outParkingNum +
            ", updateTime=" + updateTime +
            ", id=" + id +
        "}";
    }
}
