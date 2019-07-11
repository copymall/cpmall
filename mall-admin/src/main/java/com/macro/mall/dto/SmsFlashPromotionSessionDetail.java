package com.macro.mall.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 包含商品数量的场次信息
 */
public class SmsFlashPromotionSessionDetail {
    @Setter
    @Getter
    private Long productCount;
}
