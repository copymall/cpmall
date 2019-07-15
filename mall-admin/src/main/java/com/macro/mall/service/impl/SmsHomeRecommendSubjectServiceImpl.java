package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.mapper.SmsHomeRecommendSubjectMapper;
import com.macro.mall.model.SmsHomeRecommendSubject;
import com.macro.mall.model.SmsHomeRecommendSubjectExample;
import com.macro.mall.service.SmsHomeRecommendSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class SmsHomeRecommendSubjectServiceImpl implements SmsHomeRecommendSubjectService {

    @Autowired
    private SmsHomeRecommendSubjectMapper homeRecommendSubjectMapper;

    @Override
    public int create(List<SmsHomeRecommendSubject> homeRecommendSubjectList) {
        for (SmsHomeRecommendSubject smsHomeRecommendSubject : homeRecommendSubjectList) {
            smsHomeRecommendSubject.setRecommendStatus(1);
            smsHomeRecommendSubject.setRecommendStatus(0);
            homeRecommendSubjectMapper.insert(smsHomeRecommendSubject);
        }
        return homeRecommendSubjectList.size();
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        SmsHomeRecommendSubject homeRecommendSubject = new SmsHomeRecommendSubject();
        homeRecommendSubject.setId(id);
        homeRecommendSubject.setSort(sort);
        return homeRecommendSubjectMapper.updateByPrimaryKeySelective(homeRecommendSubject);
    }

    @Override
    public int delete(List<Long> ids) {
        SmsHomeRecommendSubjectExample homeRecommendSubjectExample = new SmsHomeRecommendSubjectExample();
        homeRecommendSubjectExample.createCriteria().andIdIn(ids);
        return homeRecommendSubjectMapper.deleteByExample(homeRecommendSubjectExample);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        SmsHomeRecommendSubjectExample homeRecommendSubjectExample = new SmsHomeRecommendSubjectExample();
        homeRecommendSubjectExample.createCriteria().andIdIn(ids);
        SmsHomeRecommendSubject homeRecommendSubject = new SmsHomeRecommendSubject();
        homeRecommendSubject.setRecommendStatus(recommendStatus);
        return homeRecommendSubjectMapper.updateByExampleSelective(homeRecommendSubject, homeRecommendSubjectExample);
    }

    @Override
    public List<SmsHomeRecommendSubject> list(String subjectName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        SmsHomeRecommendSubjectExample homeRecommendSubjectExample = new SmsHomeRecommendSubjectExample();
        SmsHomeRecommendSubjectExample.Criteria criteria = homeRecommendSubjectExample.createCriteria();
        if (!StringUtils.isEmpty(subjectName)) {
            criteria.andSubjectNameLike("%" + subjectName + "%");
        }
        if (recommendStatus != null) {
            criteria.andRecommendStatusEqualTo(recommendStatus);
        }
        homeRecommendSubjectExample.setOrderByClause("sort desc");
        return homeRecommendSubjectMapper.selectByExample(homeRecommendSubjectExample);
    }
}
