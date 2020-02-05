package com.ruoyi.project.system.dbmanage.mapper;

import com.ruoyi.project.system.dbmanage.domain.TbManage;

import java.util.List;

/**
 * 数据库表管理Mapper接口
 * 
 * @author 宗国建
 * @date 2020-01-26
 */
public interface TbManageMapper 
{
    /**
     * 查询数据库表管理
     * 
     * @param tbId 数据库表管理ID
     * @return 数据库表管理
     */
    public TbManage selectTbManageById(Long tbId);

    /**
     * 查询数据库表管理列表
     * 
     * @param tbManage 数据库表管理
     * @return 数据库表管理集合
     */
    public List<TbManage> selectTbManageList(TbManage tbManage);

    /**
     * 新增数据库表管理
     * 
     * @param tbManage 数据库表管理
     * @return 结果
     */
    public int insertTbManage(TbManage tbManage);

    /**
     * 修改数据库表管理
     * 
     * @param tbManage 数据库表管理
     * @return 结果
     */
    public int updateTbManage(TbManage tbManage);

    /**
     * 删除数据库表管理
     * 
     * @param tbId 数据库表管理ID
     * @return 结果
     */
    public int deleteTbManageById(Long tbId);

    /**
     * 批量删除数据库表管理
     * 
     * @param tbIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTbManageByIds(String[] tbIds);

}
