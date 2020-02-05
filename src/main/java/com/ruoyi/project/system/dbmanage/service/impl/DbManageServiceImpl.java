package com.ruoyi.project.system.dbmanage.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.dbmanage.mapper.DbManageMapper;
import com.ruoyi.project.system.dbmanage.domain.DbManage;
import com.ruoyi.project.system.dbmanage.service.IDbManageService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 数据库管理Service业务层处理
 * 
 * @author 宗国建
 * @date 2020-01-25
 */
@Service
public class DbManageServiceImpl implements IDbManageService 
{
    @Autowired
    private DbManageMapper dbManageMapper;

    /**
     * 查询数据库管理
     * 
     * @param dbId 数据库管理ID
     * @return 数据库管理
     */
    @Override
    public DbManage selectDbManageById(Long dbId)
    {
        return dbManageMapper.selectDbManageById(dbId);
    }

    /**
     * 查询数据库管理列表
     * 
     * @param dbManage 数据库管理
     * @return 数据库管理
     */
    @Override
    public List<DbManage> selectDbManageList(DbManage dbManage)
    {
        return dbManageMapper.selectDbManageList(dbManage);
    }

    /**
     * 新增数据库管理
     * 
     * @param dbManage 数据库管理
     * @return 结果
     */
    @Override
    public int insertDbManage(DbManage dbManage)
    {
        dbManage.setCreateTime(DateUtils.getNowDate());
        return dbManageMapper.insertDbManage(dbManage);
    }

    /**
     * 修改数据库管理
     * 
     * @param dbManage 数据库管理
     * @return 结果
     */
    @Override
    public int updateDbManage(DbManage dbManage)
    {
        dbManage.setUpdateTime(DateUtils.getNowDate());
        return dbManageMapper.updateDbManage(dbManage);
    }

    /**
     * 删除数据库管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDbManageByIds(String ids)
    {
        return dbManageMapper.deleteDbManageByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除数据库管理信息
     * 
     * @param dbId 数据库管理ID
     * @return 结果
     */
    @Override
    public int deleteDbManageById(Long dbId)
    {
        return dbManageMapper.deleteDbManageById(dbId);
    }

}
