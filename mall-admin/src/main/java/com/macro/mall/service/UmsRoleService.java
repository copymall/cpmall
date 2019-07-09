package com.macro.mall.service;

import com.macro.mall.model.UmsPermission;
import com.macro.mall.model.UmsRole;

import java.util.List;

/**
 * 后台角色管理Service
 */
public interface UmsRoleService {

    /**
     * 添加角色
     */
    int create(UmsRole role);

    /**
     * 修改角色
     */
    int update(Long id, UmsRole role);

    /**
     * 批量删除角色
     * */
    int delete(List<Long> ids);

    /**
     * 获取相应角色权限
     * */
    List<UmsPermission> getPermissionList(Long roleId);

    /**
     * 修改角色权限
     * */
    int updatePermission(Long roleId, List<Long> permissionIds);

    /**
     * 获取所有角色
     * */
    List<UmsRole> list();
}
