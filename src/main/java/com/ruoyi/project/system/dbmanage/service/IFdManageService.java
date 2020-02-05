package com.ruoyi.project.system.dbmanage.service;

import com.ruoyi.project.system.dbmanage.domain.FdManage;
import java.util.List;

/**
 * 数据库字段管理Service接口
 *
 * @author 宗国建
 * @date 2020-01-27
 */
public interface IFdManageService {
    /**
     * 查询数据库字段管理
     *
     * @param fdId 数据库字段管理ID
     * @return 数据库字段管理
     */
    public FdManage selectFdManageById(Long fdId);

    /**
     * 查询数据库字段管理列表
     *
     * @param fdManage 数据库字段管理
     * @return 数据库字段管理集合
     */
    public List<FdManage> selectFdManageList(FdManage fdManage);

    /**
     * 新增数据库字段管理
     *
     * @param fdManage 数据库字段管理
     * @return 结果
     */
    public int insertFdManage(FdManage fdManage);

    /**
     * 修改数据库字段管理
     *
     * @param fdManage 数据库字段管理
     * @return 结果
     */
    public int updateFdManage(FdManage fdManage);

    /**
     * 批量删除数据库字段管理
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFdManageByIds(String ids);

    /**
     * 删除数据库字段管理信息
     *
     * @param fdId 数据库字段管理ID
     * @return 结果
     */
    public int deleteFdManageById(Long fdId);
}
