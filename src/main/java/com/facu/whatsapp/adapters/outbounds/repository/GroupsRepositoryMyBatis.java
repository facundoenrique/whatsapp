package com.facu.whatsapp.adapters.outbounds.repository;

import com.facu.whatsapp.domain.model.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GroupsRepositoryMyBatis {

    @Select("INSERT INTO messages (group_id, text, read_for_user_id, dateSend) " +
            "VALUES (#{xMessage.groupId},#{xMessage.message},#{xMessage.userId},#{xMessage.createdSend})")
    Message save(@Param("xMessage") Message xMessage);

    @Select("SELECT * FROM group_users WHERE user_id = #{xUserId} AND group_id=#{xGroupId}")
    Object checkUser(@Param("xUserId") Long xUserId, @Param("xGroupId") Long xGroupId);

    @Select("SELECT user_id FROM group_users WHERE group_id=#{xGroupId}")
    List<Long> getUserGroups(Long groupId);
}
