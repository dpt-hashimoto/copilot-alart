package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserCopilotSetting;
import com.example.demo.mapper.UserCopilotSettingMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserCopilotSettingService {

    // XXX メモ @RequiredArgsConstructorがあると、自動でインスタンスを取得してくれる。
    /** Mapperインターフェース */
    private final UserCopilotSettingMapper mapper;

    /**
     * 指定したIDのエンティティを取得する
     * @param id
     * @return エンティティDTO
     */
    public UserCopilotSetting getSettingById(Integer id) {
        return mapper.findById(id);
    }

    /**
     * エンティティを全件取得する
     * @return エンティティリスト
     */
    public List<UserCopilotSetting> findAll() {
        return mapper.findAll();
    }

    /**
     * 新規作成する
     */
    public void regist(UserCopilotSetting setting) {
        mapper.insert(setting);
    }

    /**
     * 更新する
     */
    public void update(UserCopilotSetting setting) {
        mapper.update(setting);
    }

    /**
     * 削除する
     */
    public void delete(Integer id) {
        mapper.delete(id);
    }
}
