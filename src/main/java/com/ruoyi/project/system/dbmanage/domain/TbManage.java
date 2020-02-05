package com.ruoyi.project.system.dbmanage.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 数据库表管理对象 sys_tb_manage
 * 
 * @author 宗国建
 * @date 2020-01-26
 */
public class TbManage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 表主键 */
    private Long tbId;

    /** 表名称 */
    @Excel(name = "表名称")
    private String tbName;

    /** 中文名 */
    @Excel(name = "中文名")
    private String tbChName;

    /** 所属库id */
    @Excel(name = "所属库id")
    private Long tbByDbid;

    /** 描述 */
    @Excel(name = "描述")
    private String tbDesc;

    public void setTbId(Long tbId) 
    {
        this.tbId = tbId;
    }

    public Long getTbId() 
    {
        return tbId;
    }
    public void setTbName(String tbName) 
    {
        this.tbName = tbName;
    }

    public String getTbName() 
    {
        return tbName;
    }
    public void setTbChName(String tbChName) 
    {
        this.tbChName = tbChName;
    }

    public String getTbChName() 
    {
        return tbChName;
    }
    public void setTbByDbid(Long tbByDbid) 
    {
        this.tbByDbid = tbByDbid;
    }

    public Long getTbByDbid() 
    {
        return tbByDbid;
    }
    public void setTbDesc(String tbDesc) 
    {
        this.tbDesc = tbDesc;
    }

    public String getTbDesc() 
    {
        return tbDesc;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("tbId", getTbId())
            .append("tbName", getTbName())
            .append("tbChName", getTbChName())
            .append("tbByDbid", getTbByDbid())
            .append("tbDesc", getTbDesc())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
