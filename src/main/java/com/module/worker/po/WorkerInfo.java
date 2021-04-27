package com.module.worker.po;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.annotation.Excel;
import com.web.domain.BaseEntity;

/**
 * 测试表对象 worker_info
 * 
 * @author cjt
 * @date 2021-01-12
 */
public class WorkerInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Integer id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String workerName;

    /** 编号 */
    @Excel(name = "编号")
    private String workerCode;

    /** 头像 */
    @Excel(name = "头像")
    private String headPortrait;

    /** 手机号 */
    @Excel(name = "手机号")
    private String mobile;

    /** 工种id */
    @Excel(name = "工种id")
    private Integer workTypeId;

    /** 性别（M男F女） */
    @Excel(name = "性别", readConverterExp = "M=男F女")
    private String sex;

    /** 年龄 */
    @Excel(name = "年龄")
    private String age;

    /** 出生日期 */
    @Excel(name = "出生日期")
    private String birthday;

    /** 部门id */
    @Excel(name = "部门id")
    private Integer deptId;

    /** 民族 */
    @Excel(name = "民族")
    private String nation;

    /** 籍贯 */
    @Excel(name = "籍贯")
    private String nationPlace;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idCard;

    /** 现居地址 */
    @Excel(name = "现居地址")
    private String currentAddress;

    /** 工人状态（0正常，1已删除） */
    @Excel(name = "工人状态", readConverterExp = "0=正常，1已删除")
    private Integer status;

    /** 工程id */
    @Excel(name = "工程id")
    private Integer projectId;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setWorkerName(String workerName) 
    {
        this.workerName = workerName;
    }

    public String getWorkerName() 
    {
        return workerName;
    }
    public void setWorkerCode(String workerCode) 
    {
        this.workerCode = workerCode;
    }

    public String getWorkerCode() 
    {
        return workerCode;
    }
    public void setHeadPortrait(String headPortrait) 
    {
        this.headPortrait = headPortrait;
    }

    public String getHeadPortrait() 
    {
        return headPortrait;
    }
    public void setMobile(String mobile) 
    {
        this.mobile = mobile;
    }

    public String getMobile() 
    {
        return mobile;
    }
    public void setWorkTypeId(Integer workTypeId) 
    {
        this.workTypeId = workTypeId;
    }

    public Integer getWorkTypeId() 
    {
        return workTypeId;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setAge(String age) 
    {
        this.age = age;
    }

    public String getAge() 
    {
        return age;
    }
    public void setBirthday(String birthday) 
    {
        this.birthday = birthday;
    }

    public String getBirthday() 
    {
        return birthday;
    }
    public void setDeptId(Integer deptId) 
    {
        this.deptId = deptId;
    }

    public Integer getDeptId() 
    {
        return deptId;
    }
    public void setNation(String nation) 
    {
        this.nation = nation;
    }

    public String getNation() 
    {
        return nation;
    }
    public void setNationPlace(String nationPlace) 
    {
        this.nationPlace = nationPlace;
    }

    public String getNationPlace() 
    {
        return nationPlace;
    }
    public void setIdCard(String idCard) 
    {
        this.idCard = idCard;
    }

    public String getIdCard() 
    {
        return idCard;
    }
    public void setCurrentAddress(String currentAddress) 
    {
        this.currentAddress = currentAddress;
    }

    public String getCurrentAddress() 
    {
        return currentAddress;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setProjectId(Integer projectId) 
    {
        this.projectId = projectId;
    }

    public Integer getProjectId() 
    {
        return projectId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("workerName", getWorkerName())
            .append("workerCode", getWorkerCode())
            .append("headPortrait", getHeadPortrait())
            .append("mobile", getMobile())
            .append("workTypeId", getWorkTypeId())
            .append("sex", getSex())
            .append("age", getAge())
            .append("birthday", getBirthday())
            .append("deptId", getDeptId())
            .append("nation", getNation())
            .append("nationPlace", getNationPlace())
            .append("idCard", getIdCard())
            .append("currentAddress", getCurrentAddress())
            .append("status", getStatus())
            .append("projectId", getProjectId())
            .toString();
    }
}
