package com.ken.simplon.Dao;


public interface FormateurDao {
    public boolean login(String email, String password);
    public void createBrief(String title, String context, int deadline);
    public boolean assignPromoToApprenant(Long idApprenant, Long idPromo);
    public boolean assignBriefToPromo(Long idBrief, Long idPromo);
    public boolean validateBriefOfApprenant(Long idLivrable);
}
