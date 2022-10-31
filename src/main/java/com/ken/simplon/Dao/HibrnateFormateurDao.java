package com.ken.simplon.Dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import com.ken.simplon.Util.EntityManagers;
import jakarta.persistence.Query;
import entity.*;
import java.util.*;
public class HibrnateFormateurDao implements FormateurDao {
    public boolean login(String email, String password) {
        EntityManager manager = EntityManagers.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        Query query = (Query) manager.createQuery("SELECT f FROM Formateur f WHERE f.email = :email AND f.password = :password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        List list = query.getResultList();
        transaction.commit();
        manager.close();
        if(list.size() > 0) {
            return true;
        }
        return false;
    }
    public void createBrief(String title, String context, int deadline) {
        EntityManager manager = EntityManagers.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        BriefEntity brief = new BriefEntity();
        brief.setTitle(title);
        brief.setContext(context);
        brief.setDeadline(deadline);
        manager.persist(brief);
        transaction.commit();
        manager.close();
    }
    public boolean assignPromoToApprenant(Long idApprenant, Long idPromo) {
        EntityManager manager = EntityManagers.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        Query query = (Query) manager.createQuery("SELECT a FROM Apprenant a WHERE a.apprenantId = :idApprenant");
        query.setParameter("idApprenant", idApprenant);
        List list = query.getResultList();
        if(list.size() > 0) {
            ApprenantEntity apprenant = (ApprenantEntity) list.get(0);
            apprenant.setPromoId(idPromo);
            manager.persist(apprenant);
            transaction.commit();
            manager.close();
            return true;
        }
        transaction.commit();
        manager.close();
        return false;
    }
   public boolean assignBriefToPromo(Long idBrief, Long idPromo) {
       EntityManager manager = EntityManagers.getEntityManagerFactory().createEntityManager();
       EntityTransaction transaction = manager.getTransaction();
       transaction.begin();
       Query query = (Query) manager.createQuery("SELECT b FROM Brief b WHERE b.briefId = :idBrief");
       query.setParameter("idBrief", idBrief);
       List list = query.getResultList();
       if(list.size() > 0) {
           BriefEntity brief = (BriefEntity) list.get(0);
           brief.setPromoId(idPromo);
           manager.persist(brief);
           transaction.commit();
           manager.close();
           return true;
       }
       transaction.commit();
       manager.close();
       return false;
   }
   
  public boolean validateBriefOfApprenant(Long idLivrable) {
      EntityManager manager = EntityManagers.getEntityManagerFactory().createEntityManager();
      EntityTransaction transaction = manager.getTransaction();
      transaction.begin();
      Query query = (Query) manager.createQuery("SELECT l FROM Livrable l WHERE l.livrableId = :idLivrable");
      query.setParameter("idLivrable", idLivrable);
      List list = query.getResultList();
      if(list.size() > 0) {
          LivrableEntity livrable = (LivrableEntity) list.get(0);
          livrable.setState(1);
          manager.persist(livrable);
          transaction.commit();
          manager.close();
          return true;
      }
      transaction.commit();
      manager.close();
      return false;
  }
}
