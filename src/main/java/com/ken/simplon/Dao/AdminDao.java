package com.ken.simplon.Dao;

import java.util.List;

import entity.AdminEntity;
import entity.PromotionEntity;

public interface AdminDao {
    public boolean login(String login, String password);
    public void createFormateurAccount(String fullName, String email, String password);
    public void createApprenantAccount(String fullName, String email, String password);
    public void createPromo(String name);
    public void assignFormateurToPromo(Long idFormateur, Long idPromo);
    public List<PromotionEntity> getAllPromos();

}
