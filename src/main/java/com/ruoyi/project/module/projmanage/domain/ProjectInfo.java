package com.ruoyi.project.module.projmanage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 项目管理详情对象 ccb_project_info
 *
 * @author 宗国建
 * @date 2020-02-05
 */
public class ProjectInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 项目id */
    private Long projId;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projName;

    /** 项目负责人 */
    @Excel(name = "项目负责人")
    private String projLeader;

    /** 项目周期 */
    @Excel(name = "项目周期")
    private String projPeriod;

    /** 项目预算 */
    @Excel(name = "项目预算")
    private String projBudget;

    /** 项目状态 */
    @Excel(name = "项目状态")
    private String projStatus;

    /** 项目阶段 */
    @Excel(name = "项目阶段")
    private String projStage;

    /** 项目进度 */
    @Excel(name = "项目进度")
    private String projProgress;

    /** 参与人员 */
    @Excel(name = "参与人员")
    private String projUserids;

    /** 项目描述 */
    @Excel(name = "项目描述")
    private String projDesc;

    public void setProjId(Long projId)
    {
        this.projId = projId;
    }

    public Long getProjId()
    {
        return projId;
    }
    public void setProjName(String projName)
    {
        this.projName = projName;
    }

    public String getProjName()
    {
        return projName;
    }
    public void setProjLeader(String projLeader)
    {
        this.projLeader = projLeader;
    }

    public String getProjLeader()
    {
        return projLeader;
    }
    public void setProjPeriod(String projPeriod)
    {
        this.projPeriod = projPeriod;
    }

    public String getProjPeriod()
    {
        return projPeriod;
    }
    public void setProjBudget(String projBudget)
    {
        this.projBudget = projBudget;
    }

    public String getProjBudget()
    {
        return projBudget;
    }
    public void setProjStatus(String projStatus)
    {
        this.projStatus = projStatus;
    }

    public String getProjStatus()
    {
        return projStatus;
    }
    public void setProjStage(String projStage)
    {
        this.projStage = projStage;
    }

    public String getProjStage()
    {
        return projStage;
    }
    public void setProjProgress(String projProgress)
    {
        this.projProgress = projProgress;
    }

    public String getProjProgress()
    {
        return projProgress;
    }
    public void setProjUserids(String projUserids)
    {
        this.projUserids = projUserids;
    }

    public String getProjUserids()
    {
        return projUserids;
    }
    public void setProjDesc(String projDesc)
    {
        this.projDesc = projDesc;
    }

    public String getProjDesc()
    {
        return projDesc;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("projId", getProjId())
                .append("projName", getProjName())
                .append("projLeader", getProjLeader())
                .append("projPeriod", getProjPeriod())
                .append("projBudget", getProjBudget())
                .append("projStatus", getProjStatus())
                .append("projStage", getProjStage())
                .append("projProgress", getProjProgress())
                .append("projUserids", getProjUserids())
                .append("projDesc", getProjDesc())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
