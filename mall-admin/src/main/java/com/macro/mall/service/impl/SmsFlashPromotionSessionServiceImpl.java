package com.macro.mall.service.impl;

import com.macro.mall.dto.SmsFlashPromotionSessionDetail;
import com.macro.mall.mapper.SmsFlashPromotionSessionMapper;
import com.macro.mall.model.SmsFlashPromotionSession;
import com.macro.mall.service.SmsFlashPromotionProductRelationService;
import com.macro.mall.service.SmsFlashPromotionSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 限时购场次管理Service实现类
 */
@Service
public class SmsFlashPromotionSessionServiceImpl implements SmsFlashPromotionSessionService {
    @Autowired
    private SmsFlashPromotionSessionMapper sessionMapper;
    @Autowired
    private SmsFlashPromotionProductRelationService relationService;
    @Override
    public int create(SmsFlashPromotionSession promotionSession) {
        return 0;
    }

    @Override
    public int update(Long id, SmsFlashPromotionSession promotionSession) {
        return 0;
    }

    @Override
    public int updateStatus(Long id, Integer status) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public SmsFlashPromotionSession getItem(Long id) {
        return null;
    }

    @Override
    public List<SmsFlashPromotionSession> list() {
        return null;
    }

    @Override
    public List<SmsFlashPromotionSessionDetail> selectList(Long flashPromotionId) {
        return null;
    }
}
