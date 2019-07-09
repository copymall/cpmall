package com.macro.mall.dto;

import com.macro.mall.model.UmsPermission;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

public class UmsPermissionNode extends UmsPermission {

    @Getter
    @Setter
    private List<UmsPermissionNode> children;

}
