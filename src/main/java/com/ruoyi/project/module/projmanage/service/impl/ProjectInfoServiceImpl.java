package com.ruoyi.project.module.projmanage.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.module.projmanage.mapper.ProjectInfoMapper;
import com.ruoyi.project.module.projmanage.domain.ProjectInfo;
import com.ruoyi.project.module.projmanage.service.IProjectInfoService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 项目管理详情Service业务层处理
 * 
 * @author 宗国建
 * @date 2020-01-31
 */
@Service
public class ProjectInfoServiceImpl implements IProjectInfoService 
{
    @Autowired
    private ProjectInfoMapper projectInfoMapper;

    /**
     * 查询项目管理详情
     * 
     * @param projId 项目管理详情ID
     * @return 项目管理详情
     */
    @Override
    public ProjectInfo selectProjectInfoById(Long projId)
    {
        return projectInfoMapper.selectProjectInfoById(projId);
    }

    /**
     * 查询项目管理详情列表
     * 
     * @param projectInfo 项目管理详情
     * @return 项目管理详情
     */
    @Override
    public List<ProjectInfo> selectProjectInfoList(ProjectInfo projectInfo)
    {
        return projectInfoMapper.selectProjectInfoList(projectInfo);
    }

    /**
     * 新增项目管理详情
     * 
     * @param projectInfo 项目管理详情
     * @return 结果
     */
    @Override
    public int insertProjectInfo(ProjectInfo projectInfo)
    {
        projectInfo.setCreateTime(DateUtils.getNowDate());
        return projectInfoMapper.insertProjectInfo(projectInfo);
    }

    /**
     * 修改项目管理详情
     * 
     * @param projectInfo 项目管理详情
     * @return 结果
     */
    @Override
    public int updateProjectInfo(ProjectInfo projectInfo)
    {
        projectInfo.setUpdateTime(DateUtils.getNowDate());
        return projectInfoMapper.updateProjectInfo(projectInfo);
    }

    /**
     * 删除项目管理详情对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProjectInfoByIds(String ids)
    {
        return projectInfoMapper.deleteProjectInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除项目管理详情信息
     * 
     * @param projId 项目管理详情ID
     * @return 结果
     */
    @Override
    public int deleteProjectInfoById(Long projId)
    {
        return projectInfoMapper.deleteProjectInfoById(projId);
    }
}
