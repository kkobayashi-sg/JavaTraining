package com.s_giken.training.webapp.repository;

import java.util.List;
import java.util.Optional;
import com.s_giken.training.webapp.model.entity.Charge;

public interface IChargeRepository {
    /**
     * 料金情報をすべて取得する
     * 
     * 
     * @return　Chargeオブジェクトのリスト
     */
    public List<Charge> findAll();

    /**
     * 指定した料金番号の料金情報を取得する。
     * 
     * 
     * @return Optional型のChargeオブジェクト
     */
    public Optional<Charge> findById(Long id);

    /**
     * 
     * @param name
     * @return
     */
    public List<Charge> findByNameLike(String name);
    
    /**
     * 料金情報をデータベースへ登録する。
     * 
     * @param charge
     * @return
     */
    public int add(Charge charge);

    /**
     * 
     * データベースの料金情報を更新する
     * 
     * 
     */
    public int update(Charge charge);

    /**
     * データベースから指定した料金番号の料金情報を削除する
     * 
     * 
     * 
     */
    public int deleteById(Long id);
}
