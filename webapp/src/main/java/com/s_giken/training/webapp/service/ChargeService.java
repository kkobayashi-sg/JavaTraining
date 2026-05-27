package com.s_giken.training.webapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.s_giken.training.webapp.exception.AttributeErrorException;
import com.s_giken.training.webapp.model.entity.Charge;
import com.s_giken.training.webapp.model.entity.ChargeSearchCondition;
import com.s_giken.training.webapp.repository.IChargeRepository;

import com.s_giken.training.webapp.repository.IUserRepository;
import com.s_giken.training.webapp.repository.UserRepository;
/**
 * 料金管理機能のサービスクラス（実体クラス）
 * 
 */
@Service
public class ChargeService implements IChargeService {
    private IChargeRepository chargeRepository;
    private IUserRepository userRepository;

    /**
     * 料金管理機能のサービスクラスのコンストラクタ
     * 
     */
    public ChargeService(IChargeRepository chargeRepository){
        this.chargeRepository = chargeRepository;
    }
    
    /**
     * 料金情報を全件取得する
     * 
     * 
     */
    @Override
    public List<Charge> findAll() {
        return chargeRepository.findAll();
    }

    /**
     * 料金情報を一件取得する
     * 
     * 
     * 
     */
    @Override
    public Optional<Charge> findById(Long chargeId) {
        return chargeRepository.findById(chargeId);
    }

    /**
     * 料金情報を条件検索する
     * 
     */
    @Override
    public List<Charge> findByConditions(ChargeSearchCondition chargeSearchCondition) {
        return chargeRepository.findByNameLike(
            chargeSearchCondition.getName()
        );
    }

    /**
     * 料金情報を登録する
     * 
     * 
     */
    @Override
    public void add(Charge charge) {
        if (charge.getChargeId() != null) {
            throw new AttributeErrorException("料金番号が指定されていると登録できません。");
        }
        chargeRepository.add(charge);
    }

    /***
     * 料金情報を更新する
     * 
     * 
     */
    @Override
    public void update(Charge charge) {
        if (charge.getChargeId() == null) {
            throw new AttributeErrorException("料金番号が指定されていません。");
        }
        chargeRepository.update(charge);
    }

    /**
     * 料金情報を削除する
     * 
     * 
     */
    @Override
    public void deleteById(Long chargeId) {
        chargeRepository.deleteById(chargeId);
    }

}
