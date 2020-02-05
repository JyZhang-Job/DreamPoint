package com.ruoyi.project.system.dbmanage.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.system.dbmanage.domain.FdManage;
import com.ruoyi.project.system.dbmanage.domain.TbManage;
import com.ruoyi.project.system.dbmanage.mapper.FdManageMapper;
import com.ruoyi.project.system.dbmanage.mapper.TbManageMapper;
import com.ruoyi.project.system.dbmanage.service.ITbManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 数据库表管理Service业务层处理
 * 
 * @author 宗国建
 * @date 2020-01-26
 */
@Service
public class TbManageServiceImpl implements ITbManageService
{
    @Autowired
    private TbManageMapper tbManageMapper;

    @Autowired
    private FdManageMapper fdManageMapper;

    /**
     * 查询数据库表管理
     * 
     * @param tbId 数据库表管理ID
     * @return 数据库表管理
     */
    @Override
    public TbManage selectTbManageById(Long tbId)
    {
        return tbManageMapper.selectTbManageById(tbId);
    }

    /**
     * 查询数据库表管理列表
     * 
     * @param tbManage 数据库表管理
     * @return 数据库表管理
     */
    @Override
    public List<TbManage> selectTbManageList(TbManage tbManage)
    {
        return tbManageMapper.selectTbManageList(tbManage);
    }

    /**
     * 新增数据库表管理
     * 
     * @param tbManage 数据库表管理
     * @return 结果
     */
    @Override
    public int insertTbManage(TbManage tbManage)
    {
        tbManage.setCreateTime(DateUtils.getNowDate());
        return tbManageMapper.insertTbManage(tbManage);
    }

    /**
     * 修改数据库表管理
     * 
     * @param tbManage 数据库表管理
     * @return 结果
     */
    @Override
    public int updateTbManage(TbManage tbManage)
    {
        tbManage.setUpdateTime(DateUtils.getNowDate());
        return tbManageMapper.updateTbManage(tbManage);
    }

    /**
     * 删除数据库表管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTbManageByIds(String ids)
    {
        return tbManageMapper.deleteTbManageByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除数据库表管理信息
     * 
     * @param tbId 数据库表管理ID
     * @return 结果
     */
    @Override
    public int deleteTbManageById(Long tbId)
    {
        return tbManageMapper.deleteTbManageById(tbId);
    }

    @Override
    public List<String>  selectFdManageList(String searchValue) {
        return fdManageMapper.selectFdManageBySearchVal(searchValue);

    }

}
