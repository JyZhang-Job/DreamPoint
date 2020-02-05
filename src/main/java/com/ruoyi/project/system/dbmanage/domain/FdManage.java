package com.ruoyi.project.system.dbmanage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 数据库字段管理对象 sys_fd_manage
 * 
 * @author 宗国建
 * @date 2020-01-27
 */
public class FdManage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 字段id */
    private Long fdId;

    /** 表id */
    @Excel(name = "表id")
    private Long tbId;

    /** 字段名称 */
    @Excel(name = "字段名称")
    private String fdName;

    /** 中文名 */
    @Excel(name = "中文名")
    private String fdChName;

    /** 字段类型 */
    @Excel(name = "字段类型")
    private Integer fdType;

    /** 字段长度 */
    @Excel(name = "字段长度")
    private String fdLen;

    /** 是否是主键 */
    @Excel(name = "是否是主键")
    private String isKey;

    /** 是否是空 */
    @Excel(name = "是否是空")
    private String isNull;

    /** 默认值 */
    @Excel(name = "默认值")
    private String defVal;

    /** 字段排序 */
    @Excel(name = "字段排序")
    private String fdSort;

    /** 字段描述 */
    @Excel(name = "字段描述")
    private String fdDesc;

    public void setFdId(Long fdId) 
    {
        this.fdId = fdId;
    }

    public Long getFdId() 
    {
        return fdId;
    }
    public void setTbId(Long tbId) 
    {
        this.tbId = tbId;
    }

    public Long getTbId() 
    {
        return tbId;
    }
    public void setFdName(String fdName) 
    {
        this.fdName = fdName;
    }

    public String getFdName() 
    {
        return fdName;
    }
    public void setFdChName(String fdChName) 
    {
        this.fdChName = fdChName;
    }

    public String getFdChName() 
    {
        return fdChName;
    }
    public void setFdType(Integer fdType) 
    {
        this.fdType = fdType;
    }

    public Integer getFdType() 
    {
        return fdType;
    }
    public void setFdLen(String fdLen) 
    {
        this.fdLen = fdLen;
    }

    public String getFdLen() 
    {
        return fdLen;
    }
    public void setIsKey(String isKey) 
    {
        this.isKey = isKey;
    }

    public String getIsKey() 
    {
        return isKey;
    }
    public void setIsNull(String isNull) 
    {
        this.isNull = isNull;
    }

    public String getIsNull() 
    {
        return isNull;
    }
    public void setDefVal(String defVal) 
    {
        this.defVal = defVal;
    }

    public String getDefVal() 
    {
        return defVal;
    }
    public void setFdSort(String fdSort) 
    {
        this.fdSort = fdSort;
    }

    public String getFdSort() 
    {
        return fdSort;
    }
    public void setFdDesc(String fdDesc) 
    {
        this.fdDesc = fdDesc;
    }

    public String getFdDesc() 
    {
        return fdDesc;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fdId", getFdId())
            .append("tbId", getTbId())
            .append("fdName", getFdName())
            .append("fdChName", getFdChName())
            .append("fdType", getFdType())
            .append("fdLen", getFdLen())
            .append("isKey", getIsKey())
            .append("isNull", getIsNull())
            .append("defVal", getDefVal())
            .append("fdSort", getFdSort())
            .append("fdDesc", getFdDesc())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
