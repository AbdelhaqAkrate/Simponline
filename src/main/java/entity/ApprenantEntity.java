package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "apprenant", schema = "simplonlite", catalog = "")
public class ApprenantEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "apprenantId")
    private long apprenantId;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "fullName")
    private String fullName;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "promoId")
    private Long promoId;
    @ManyToOne
    @JoinColumn(name = "promoId", referencedColumnName = "promoId")
    private PromotionEntity promotionByPromoId;
    @OneToMany(mappedBy = "apprenantByApprenantId")
    private Collection<LivrableEntity> livrablesByApprenantId;

    public long getApprenantId() {
        return apprenantId;
    }

    public void setApprenantId(Long apprenantId) {
        this.apprenantId = apprenantId;
    }

    public void setApprenantId(long apprenantId) {
        this.apprenantId = apprenantId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPromoId() {
        return promoId;
    }

    public void setPromoId(Long promoId) {
        this.promoId = promoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApprenantEntity that = (ApprenantEntity) o;

        if (apprenantId != that.apprenantId) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (fullName != null ? !fullName.equals(that.fullName) : that.fullName != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (promoId != null ? !promoId.equals(that.promoId) : that.promoId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (apprenantId ^ (apprenantId >>> 32));
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (promoId != null ? promoId.hashCode() : 0);
        return result;
    }

    public PromotionEntity getPromotionByPromoId() {
        return promotionByPromoId;
    }

    public void setPromotionByPromoId(PromotionEntity promotionByPromoId) {
        this.promotionByPromoId = promotionByPromoId;
    }

    public Collection<LivrableEntity> getLivrablesByApprenantId() {
        return livrablesByApprenantId;
    }

    public void setLivrablesByApprenantId(Collection<LivrableEntity> livrablesByApprenantId) {
        this.livrablesByApprenantId = livrablesByApprenantId;
    }
}
