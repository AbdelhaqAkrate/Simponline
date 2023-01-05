package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "promotion", schema = "simplonlite", catalog = "")
public class PromotionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "promoId")
    private long promoId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "formateurId")
    private Long formateurId;
    @OneToMany(mappedBy = "promotionByPromoId")
    private Collection<ApprenantEntity> apprenantsByPromoId;
    @OneToMany(mappedBy = "promotionByPromoId")
    private Collection<BriefEntity> briefsByPromoId;
    @ManyToOne
    @JoinColumn(name = "formateurId", referencedColumnName = "formateurId", insertable = false, updatable = false)
    private FormateurEntity formateurByFormateurId;

    public long getPromoId() {
        return promoId;
    }

    public void setPromoId(Long promoId) {
        this.promoId = promoId;
    }

    public void setPromoId(long promoId) {
        this.promoId = promoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFormateurId() {
        return formateurId;
    }

    public void setFormateurId(Long formateurId) {
        this.formateurId = formateurId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PromotionEntity that = (PromotionEntity) o;

        if (promoId != that.promoId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (formateurId != null ? !formateurId.equals(that.formateurId) : that.formateurId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (promoId ^ (promoId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (formateurId != null ? formateurId.hashCode() : 0);
        return result;
    }

    public Collection<ApprenantEntity> getApprenantsByPromoId() {
        return apprenantsByPromoId;
    }

    public void setApprenantsByPromoId(Collection<ApprenantEntity> apprenantsByPromoId) {
        this.apprenantsByPromoId = apprenantsByPromoId;
    }

    public Collection<BriefEntity> getBriefsByPromoId() {
        return briefsByPromoId;
    }

    public void setBriefsByPromoId(Collection<BriefEntity> briefsByPromoId) {
        this.briefsByPromoId = briefsByPromoId;
    }

    public FormateurEntity getFormateurByFormateurId() {
        return formateurByFormateurId;
    }

    public void setFormateurByFormateurId(FormateurEntity formateurByFormateurId) {
        this.formateurByFormateurId = formateurByFormateurId;
    }
}
