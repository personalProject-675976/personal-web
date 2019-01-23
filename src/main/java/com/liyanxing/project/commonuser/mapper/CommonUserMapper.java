package com.liyanxing.project.commonuser.mapper;

import com.liyanxing.project.commonuser.pojo.CommonUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("commonUserMapper")
@Mapper
public interface CommonUserMapper
{
    /**
     * 查询所有普通用户的所有信息
     * @return
     */
    @Select("select * from common_user")
    List<CommonUser> selectAllCommonUser();

    /**
     * 根据用户名查询一个用户
     * @param name
     * @return
     */
    @Select("select * from common_user where `name`=#{name}")
    CommonUser selectAbyName(String name);


    /**
     * 插入一个普通用户
     * @param commonUser
     */
    @Insert("insert into common_user (`name`,`password`,`salt`,`sex`,`birthday`,`email`) values (#{name},#{password},#{salt},#{sex},#{birthday},#{email})")
    void insertAcommonUser(CommonUser commonUser);
}