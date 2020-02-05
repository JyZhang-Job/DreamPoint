package com.ruoyi.project.system.dbmanage.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.system.dbmanage.domain.FdManage;
import com.ruoyi.project.system.dbmanage.mapper.FdManageMapper;
import com.ruoyi.project.system.dbmanage.service.IFdManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 数据库字段管理Service业务层处理
 * 
 * @author 宗国建
 * @date 2020-01-27
 */
@Service
public class FdManageServiceImpl implements IFdManageService
{
    @Autowired
    private FdManageMapper fdManageMapper;

    /**
     * 查询数据库字段管理
     * 
     * @param fdId 数据库字段管理ID
     * @return 数据库字段管理
     */
    @Override
    public FdManage selectFdManageById(Long fdId)
    {
        return fdManageMapper.selectFdManageById(fdId);
    }

    /**
     * 查询数据库字段管理列表
     * 
     * @param fdManage 数据库字段管理
     * @return 数据库字段管理
     */
    @Override
    public List<FdManage> selectFdManageList(FdManage fdManage)
    {
        return fdManageMapper.selectFdManageList(fdManage);
    }

    /**
     * 新增数据库字段管理
     * 
     * @param fdManage 数据库字段管理
     * @return 结果
     */
    @Override
    public int insertFdManage(FdManage fdManage)
    {
        fdManage.setCreateTime(DateUtils.getNowDate());
        return fdManageMapper.insertFdManage(fdManage);
    }

    /**
     * 修改数据库字段管理
     * 
     * @param fdManage 数据库字段管理
     * @return 结果
     */
    @Override
    public int updateFdManage(FdManage fdManage)
    {
        fdManage.setUpdateTime(DateUtils.getNowDate());
        return fdManageMapper.updateFdManage(fdManage);
    }

    /**
     * 删除数据库字段管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteFdManageByIds(String ids)
    {
        return fdManageMapper.deleteFdManageByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除数据库字段管理信息
     * 
     * @param fdId 数据库字段管理ID
     * @return 结果
     */
    @Override
    public int deleteFdManageById(Long fdId)
    {
        return fdManageMapper.deleteFdManageById(fdId);
    }
}
