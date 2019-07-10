package com.macro.mall.dao;

import com.macro.mall.model.UmsAdminRoleRelation;
import com.macro.mall.model.UmsPermission;
import com.macro.mall.model.UmsRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户与角色管理自定义Dao
 */
public interface UmsAdminRoleRelationDao {

    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);

    /**
     * 批量插入用户角色关系
     */
    void insertList(@Param("list") List<UmsAdminRoleRelation> roleRelationList);

    /**
     * 获取用于所有角色
     * */
    List<UmsRole> getRoleList(@Param("adminId") Long adminId);

}
