package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "brief", schema = "simplonlite", catalog = "")
public class BriefEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "briefId")
    private long briefId;
    @Basic
    @Column(name = "context")
    private String context;
    @Basic
    @Column(name = "deadline")
    private int deadline;
    @Basic
    @Column(name = "promoId")
    private Long promoId;
    @ManyToOne
    @JoinColumn(name = "promoId", referencedColumnName = "promoId")
    private PromotionEntity promotionByPromoId;
    @OneToMany(mappedBy = "briefByBriefId")
    private Collection<LivrableEntity> livrablesByBriefId;
    @Basic
    @Column(name = "title")
    private String title;

    public long getBriefId() {
        return briefId;
    }

    public void setBriefId(Long briefId) {
        this.briefId = briefId;
    }

    public void setBriefId(long briefId) {
        this.briefId = briefId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(Integer deadline) {
        this.deadline = deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
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

        BriefEntity that = (BriefEntity) o;

        if (briefId != that.briefId) return false;
        if (deadline != that.deadline) return false;
        if (context != null ? !context.equals(that.context) : that.context != null) return false;
        if (promoId != null ? !promoId.equals(that.promoId) : that.promoId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (briefId ^ (briefId >>> 32));
        result = 31 * result + (context != null ? context.hashCode() : 0);
        result = 31 * result + deadline;
        result = 31 * result + (promoId != null ? promoId.hashCode() : 0);
        return result;
    }

    public PromotionEntity getPromotionByPromoId() {
        return promotionByPromoId;
    }

    public void setPromotionByPromoId(PromotionEntity promotionByPromoId) {
        this.promotionByPromoId = promotionByPromoId;
    }

    public Collection<LivrableEntity> getLivrablesByBriefId() {
        return livrablesByBriefId;
    }

    public void setLivrablesByBriefId(Collection<LivrableEntity> livrablesByBriefId) {
        this.livrablesByBriefId = livrablesByBriefId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
