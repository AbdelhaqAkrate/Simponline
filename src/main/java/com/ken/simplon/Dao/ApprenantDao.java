package com.ken.simplon.Dao;

import java.sql.Date;

import javax.xml.crypto.Data;

public interface ApprenantDao {
    public boolean login(String email, String password);
    public void getAllBriefsOfPromo(Long idPromo);
    public void sendAssignment(Date postedAt, String link, Long idBrief, Long idApprenant);
}
