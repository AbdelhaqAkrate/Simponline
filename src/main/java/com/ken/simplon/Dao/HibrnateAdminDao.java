package com.ken.simplon.Dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import com.ken.simplon.Util.EntityManagers;

import entity.*;

import org.hibernate.query.Query;
import java.util.*;
public class HibrnateAdminDao implements AdminDao {
   
    public boolean login(String login, String password) {
        EntityManager manager = EntityManagers.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        Query query = (Query) manager.createQuery("SELECT a FROM AdminEntity a WHERE a.email = :email AND a.password = :password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        List list = query.getResultList();
        transaction.commit();
        manager.close();
        if(list.size() > 0) {
            return true;
        }
        return false;
    }
    public void createFormateurAccount(String fullName, String email, String password) {
        EntityManager manager = EntityManagers.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        FormateurEntity formateur = new FormateurEntity();
        formateur.setFullName(fullName);
        formateur.setEmail(email);
        formateur.setPassword(password);
        manager.persist(formateur);
        transaction.commit();
        manager.close();
        
    }
    public void createApprenantAccount(String fullName, String email, String password) {
        EntityManager manager = EntityManagers.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        ApprenantEntity apprenant = new ApprenantEntity();
        apprenant.setFullName(fullName);
        apprenant.setEmail(email);
        apprenant.setPassword(password);
        manager.persist(apprenant);
        transaction.commit();
        manager.close();
    }
    public void createPromo(String name) {
        EntityManager manager = EntityManagers.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        PromotionEntity promo = new PromotionEntity();
        promo.setName(name);
        manager.persist(promo);
        transaction.commit();
        manager.close();
    }
    public void assignFormateurToPromo(Long idFormateur, Long idPromo) {
        EntityManager manager = EntityManagers.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        FormateurEntity formateur = manager.find(FormateurEntity.class, idFormateur);
        PromotionEntity promo = manager.find(PromotionEntity.class, idPromo);
        promo.setFormateurByFormateurId(formateur);
        manager.persist(promo);
        transaction.commit();
        manager.close();
    }
    public List<PromotionEntity> getAllPromos() {
        EntityManager manager = EntityManagers.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        Query query = (Query) manager.createQuery("SELECT p FROM PromotionEntity p");
        List list = query.getResultList();
        transaction.commit();
        manager.close();
        return list;
    }
    public static void main(String [] args)
    {
        HibrnateAdminDao adminDao = new HibrnateAdminDao();
//        System.out.println(adminDao.getAllPromos());
        List<PromotionEntity> promos = (List<PromotionEntity>) adminDao.getAllPromos();
        for(PromotionEntity promo : promos)
        {
            System.out.println(promo.getName());
        }
    }
  
}
