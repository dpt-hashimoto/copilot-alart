package com.example.demo.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserCopilotSetting;
import com.example.demo.exception.BusinessException;
import com.example.demo.exception.ErrorCode;
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
     * @throws SQLException 
     */
    public void regist(UserCopilotSetting setting) {
        try {
            mapper.insert(setting);
        } catch (DuplicateKeyException e) {
            throw new BusinessException(ErrorCode.BE002 ,e);
        }
    }

    /**
     * 更新する
     */
    public void update(UserCopilotSetting setting) {
        try {
            mapper.update(setting);
        } catch (DuplicateKeyException e) {
            throw new BusinessException(ErrorCode.BE002 ,e);
        }
    }

    /**
     * 削除する
     */
    public void delete(Integer id) {
        mapper.delete(id);
    }
}
