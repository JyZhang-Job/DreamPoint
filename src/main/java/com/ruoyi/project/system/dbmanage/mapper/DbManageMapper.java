package com.ruoyi.project.system.dbmanage.mapper;

import com.ruoyi.project.system.dbmanage.domain.DbManage;
import java.util.List;

/**
 * 数据库管理Mapper接口
 * 
 * @author 宗国建
 * @date 2020-01-25
 */
public interface DbManageMapper 
{
    /**
     * 查询数据库管理
     * 
     * @param dbId 数据库管理ID
     * @return 数据库管理
     */
    public DbManage selectDbManageById(Long dbId);

    /**
     * 查询数据库管理列表
     * 
     * @param dbManage 数据库管理
     * @return 数据库管理集合
     */
    public List<DbManage> selectDbManageList(DbManage dbManage);

    /**
     * 新增数据库管理
     * 
     * @param dbManage 数据库管理
     * @return 结果
     */
    public int insertDbManage(DbManage dbManage);

    /**
     * 修改数据库管理
     * 
     * @param dbManage 数据库管理
     * @return 结果
     */
    public int updateDbManage(DbManage dbManage);

    /**
     * 删除数据库管理
     * 
     * @param dbId 数据库管理ID
     * @return 结果
     */
    public int deleteDbManageById(Long dbId);

    /**
     * 批量删除数据库管理
     * 
     * @param dbIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteDbManageByIds(String[] dbIds);
}
