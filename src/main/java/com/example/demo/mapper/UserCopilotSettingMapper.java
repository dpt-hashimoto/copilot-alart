package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.UserCopilotSetting;

/**
 * user_copilot_settingテーブルのMapperインターフェース
 */
@Mapper
public interface UserCopilotSettingMapper {
    /** 全件取得 */
    List<UserCopilotSetting> findAll();
    /** 1件取得 */
    UserCopilotSetting findById(Integer id);
    /** 新規追加 */
    int insert(UserCopilotSetting setting);
    /** 編集 */
    int update(UserCopilotSetting setting);
    /** 削除 */
    int delete(Integer id);
}
