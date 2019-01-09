package com.liyanxing.project.commonuser.service;

import com.liyanxing.project.commonuser.mapper.CommonUserMapper;
import com.liyanxing.project.commonuser.pojo.CommonUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commonUserServiceImpl")
public class CommonUserServiceImpl implements CommonUserService
{
    @Autowired
    @Qualifier("commonUserMapper")
    private CommonUserMapper mapper;

    /**
     * 查询所有普通用户的所有信息
     *
     * @return
     */
    @Override
    public List<CommonUser> selectAllCommonUser()
    {
        return mapper.selectAllCommonUser();
    }
}