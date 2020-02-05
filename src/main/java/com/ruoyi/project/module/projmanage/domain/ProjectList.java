package com.ruoyi.project.module.projmanage.domain;

import com.ruoyi.project.system.user.domain.User;

import java.util.List;

public class ProjectList {

    private ProjectInfo  projInfo;

    private List<User> user;

    public ProjectList() {
    }

    public ProjectInfo getProjInfo() {
        return projInfo;
    }

    public void setProjInfo(ProjectInfo projInfo) {
        this.projInfo = projInfo;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ProjectList{" +
                "projInfo=" + projInfo +
                ", user=" + user +
                '}';
    }
}
