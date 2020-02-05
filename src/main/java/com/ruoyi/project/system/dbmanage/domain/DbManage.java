package com.ruoyi.project.system.dbmanage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 数据库管理对象 sys_db_manage
 * 
 * @author 宗国建
 * @date 2020-01-25
 */
public class DbManage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 数据库主键 */
    private Long dbId;

    /** 数据库名称 */
    @Excel(name = "数据库名称")
    private String dbName;

    /** 数据库类型 */
    @Excel(name = "数据库类型")
    private String dbType;

    public void setDbId(Long dbId) 
    {
        this.dbId = dbId;
    }

    public Long getDbId() 
    {
        return dbId;
    }
    public void setDbName(String dbName) 
    {
        this.dbName = dbName;
    }

    public String getDbName() 
    {
        return dbName;
    }
    public void setDbType(String dbType) 
    {
        this.dbType = dbType;
    }

    public String getDbType() 
    {
        return dbType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dbId", getDbId())
            .append("dbName", getDbName())
            .append("dbType", getDbType())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
