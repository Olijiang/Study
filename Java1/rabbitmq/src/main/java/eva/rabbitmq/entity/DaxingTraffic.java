package eva.rabbitmq.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ZGB
 * @since 2022-11-07
 */
@TableName("daxing_traffic")
public class DaxingTraffic implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String start;

    private String end;

    private Integer provincialBus;

    private Integer cityBus;

    private Integer railway;

    private Integer parkingBuildingPassenger;

    private Integer metro;

    private Integer taxiQueue_1;

    private Integer taxiQueue_2;

    private Integer taxiQueue_3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }
    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
    public Integer getProvincialBus() {
        return provincialBus;
    }

    public void setProvincialBus(Integer provincialBus) {
        this.provincialBus = provincialBus;
    }
    public Integer getCityBus() {
        return cityBus;
    }

    public void setCityBus(Integer cityBus) {
        this.cityBus = cityBus;
    }
    public Integer getRailway() {
        return railway;
    }

    public void setRailway(Integer railway) {
        this.railway = railway;
    }
    public Integer getParkingBuildingPassenger() {
        return parkingBuildingPassenger;
    }

    public void setParkingBuildingPassenger(Integer parkingBuildingPassenger) {
        this.parkingBuildingPassenger = parkingBuildingPassenger;
    }
    public Integer getMetro() {
        return metro;
    }

    public void setMetro(Integer metro) {
        this.metro = metro;
    }
    public Integer getTaxiQueue1() {
        return taxiQueue_1;
    }

    public void setTaxiQueue1(Integer taxiQueue1) {
        this.taxiQueue_1 = taxiQueue1;
    }
    public Integer getTaxiQueue2() {
        return taxiQueue_2;
    }

    public void setTaxiQueue2(Integer taxiQueue2) {
        this.taxiQueue_2 = taxiQueue2;
    }
    public Integer getTaxiQueue3() {
        return taxiQueue_3;
    }

    public void setTaxiQueue3(Integer taxiQueue3) {
        this.taxiQueue_3 = taxiQueue3;
    }

    @Override
    public String toString() {
        return "DaxingTraffic{" +
            "id=" + id +
            ", start=" + start +
            ", end=" + end +
            ", provincialBus=" + provincialBus +
            ", cityBus=" + cityBus +
            ", railway=" + railway +
            ", parkingBuildingPassenger=" + parkingBuildingPassenger +
            ", metro=" + metro +
            ", taxiQueue1=" + taxiQueue_1 +
            ", taxiQueue2=" + taxiQueue_2 +
            ", taxiQueue3=" + taxiQueue_3 +
        "}";
    }
}
