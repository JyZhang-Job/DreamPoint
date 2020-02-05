package com.ruoyi.project.system.dbmanage.service;

import com.ruoyi.project.system.dbmanage.domain.FdManage;
import com.ruoyi.project.system.dbmanage.domain.TbManage;

import java.util.List;

/**
 * 数据库表管理Service接口
 * 
 * @author 宗国建
 * @date 2020-01-26
 */
public interface ITbManageService 
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
     * 批量删除数据库表管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTbManageByIds(String ids);

    /**
     * 删除数据库表管理信息
     * 
     * @param tbId 数据库表管理ID
     * @return 结果
     */
    public int deleteTbManageById(Long tbId);

    public List<String> selectFdManageList(String searchValue);
}
