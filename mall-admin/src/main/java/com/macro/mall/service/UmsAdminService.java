package com.macro.mall.service;

import com.macro.mall.dto.UmsAdminParam;
import com.macro.mall.model.UmsAdmin;
import com.macro.mall.model.UmsPermission;
import com.macro.mall.model.UmsRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 后台管理员Service
 */
public interface UmsAdminService {

    /**
     * 根据用户名获取后台管理员
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<UmsPermission> getPermissionList(Long adminId);

    /**
     * 用户注册
     */
    UmsAdmin register(UmsAdminParam param);

    /**
     * 登录功能
     */
    String login(String username, String password);

    /**
     * 刷新token的功能
     */
    String refreshToken(String token);

    /**
     * 根据用户名或姓名分页获取用户列表
     */
    List<UmsAdmin> list(String name, Integer pageSize, Integer pageNum);

    /**
     * 获取指定用户信息
     */
    UmsAdmin getItem(Long id);

    /**
     * 修改指定用户信息
     */
    int update(Long id, UmsAdmin admin);

    /**
     * 删除指定用户信息
     */
    int delete(Long id);

    /**
     * 给用户分配角色
     */
    @Transactional
    int updateRole(Long adminId, List<Long> roleIds);

    /**
     * 获取指定用户的角色
     * */
    List<UmsRole> getRoleList(Long adminId);

    /**
     * 给用户分配+-权限
     * */
    int updatePermission(Long adminId, List<Long> permissionIds);
}
