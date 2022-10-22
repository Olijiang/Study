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
@TableName("t_employee")
@ApiModel(value = "Employee对象", description = "")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("员工编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("员工姓名")
    private String name;

    @ApiModelProperty("性别")
    private String gender;

    @ApiModelProperty("出生日期")
    private LocalDate birthday;

    @ApiModelProperty("身份证号")
    private String idCard;

    @ApiModelProperty("婚姻状况")
    private String wedlock;

    @ApiModelProperty("民族")
    private Integer nationId;

    @ApiModelProperty("籍贯")
    private String nativePlace;

    @ApiModelProperty("政治面貌")
    private Integer politicId;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("电话号码")
    private String phone;

    @ApiModelProperty("联系地址")
    private String address;

    @ApiModelProperty("所属部门")
    private Integer departmentId;

    @ApiModelProperty("职称ID")
    private Integer jobLevelId;

    @ApiModelProperty("职位ID")
    private Integer posId;

    @ApiModelProperty("聘用形式")
    private String engageForm;

    @ApiModelProperty("最高学历")
    private String tiptopDegree;

    @ApiModelProperty("所属专业")
    private String specialty;

    @ApiModelProperty("毕业院校")
    private String school;

    @ApiModelProperty("入职日期")
    private LocalDate beginDate;

    @ApiModelProperty("在职状态")
    private String workState;

    @ApiModelProperty("工号")
    private String workID;

    @ApiModelProperty("合同期限")
    private Double contractTerm;

    @ApiModelProperty("转正日期")
    private LocalDate conversionTime;

    @ApiModelProperty("离职日期")
    private LocalDate notWorkDate;

    @ApiModelProperty("合同起始日期")
    private LocalDate beginContract;

    @ApiModelProperty("合同终止日期")
    private LocalDate endContract;

    @ApiModelProperty("工龄")
    private Integer workAge;

    @ApiModelProperty("工资账套ID")
    private Integer salaryId;

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
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    public String getWedlock() {
        return wedlock;
    }

    public void setWedlock(String wedlock) {
        this.wedlock = wedlock;
    }
    public Integer getNationId() {
        return nationId;
    }

    public void setNationId(Integer nationId) {
        this.nationId = nationId;
    }
    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }
    public Integer getPoliticId() {
        return politicId;
    }

    public void setPoliticId(Integer politicId) {
        this.politicId = politicId;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
    public Integer getJobLevelId() {
        return jobLevelId;
    }

    public void setJobLevelId(Integer jobLevelId) {
        this.jobLevelId = jobLevelId;
    }
    public Integer getPosId() {
        return posId;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }
    public String getEngageForm() {
        return engageForm;
    }

    public void setEngageForm(String engageForm) {
        this.engageForm = engageForm;
    }
    public String getTiptopDegree() {
        return tiptopDegree;
    }

    public void setTiptopDegree(String tiptopDegree) {
        this.tiptopDegree = tiptopDegree;
    }
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }
    public String getWorkState() {
        return workState;
    }

    public void setWorkState(String workState) {
        this.workState = workState;
    }
    public String getWorkID() {
        return workID;
    }

    public void setWorkID(String workID) {
        this.workID = workID;
    }
    public Double getContractTerm() {
        return contractTerm;
    }

    public void setContractTerm(Double contractTerm) {
        this.contractTerm = contractTerm;
    }
    public LocalDate getConversionTime() {
        return conversionTime;
    }

    public void setConversionTime(LocalDate conversionTime) {
        this.conversionTime = conversionTime;
    }
    public LocalDate getNotWorkDate() {
        return notWorkDate;
    }

    public void setNotWorkDate(LocalDate notWorkDate) {
        this.notWorkDate = notWorkDate;
    }
    public LocalDate getBeginContract() {
        return beginContract;
    }

    public void setBeginContract(LocalDate beginContract) {
        this.beginContract = beginContract;
    }
    public LocalDate getEndContract() {
        return endContract;
    }

    public void setEndContract(LocalDate endContract) {
        this.endContract = endContract;
    }
    public Integer getWorkAge() {
        return workAge;
    }

    public void setWorkAge(Integer workAge) {
        this.workAge = workAge;
    }
    public Integer getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Integer salaryId) {
        this.salaryId = salaryId;
    }

    @Override
    public String toString() {
        return "Employee{" +
            "id=" + id +
            ", name=" + name +
            ", gender=" + gender +
            ", birthday=" + birthday +
            ", idCard=" + idCard +
            ", wedlock=" + wedlock +
            ", nationId=" + nationId +
            ", nativePlace=" + nativePlace +
            ", politicId=" + politicId +
            ", email=" + email +
            ", phone=" + phone +
            ", address=" + address +
            ", departmentId=" + departmentId +
            ", jobLevelId=" + jobLevelId +
            ", posId=" + posId +
            ", engageForm=" + engageForm +
            ", tiptopDegree=" + tiptopDegree +
            ", specialty=" + specialty +
            ", school=" + school +
            ", beginDate=" + beginDate +
            ", workState=" + workState +
            ", workID=" + workID +
            ", contractTerm=" + contractTerm +
            ", conversionTime=" + conversionTime +
            ", notWorkDate=" + notWorkDate +
            ", beginContract=" + beginContract +
            ", endContract=" + endContract +
            ", workAge=" + workAge +
            ", salaryId=" + salaryId +
        "}";
    }
}
