package entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "livrable", schema = "simplonlite", catalog = "")
public class LivrableEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "livrableId")
    private long livrableId;
    @Basic
    @Column(name = "postedAt")
    private Date postedAt;
    @Basic
    @Column(name = "link")
    private String link;
    @Basic
    @Column(name = "state")
    private Integer state;
    @Basic
    @Column(name = "briefId")
    private long briefId;
    @Basic
    @Column(name = "apprenantId")
    private long apprenantId;
    @ManyToOne
    @JoinColumn(name = "briefId", referencedColumnName = "briefId", nullable = false,insertable = false, updatable = false)
    private BriefEntity briefByBriefId;
    @ManyToOne
    @JoinColumn(name = "apprenantId", referencedColumnName = "apprenantId", nullable = false, insertable = false, updatable = false)
    private ApprenantEntity apprenantByApprenantId;
    @Basic
    @Column(name = "message")
    private String message;

    public long getLivrableId() {
        return livrableId;
    }

    public void setLivrableId(Long livrableId) {
        this.livrableId = livrableId;
    }

    public void setLivrableId(long livrableId) {
        this.livrableId = livrableId;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public long getBriefId() {
        return briefId;
    }

    public void setBriefId(Long briefId) {
        this.briefId = briefId;
    }

    public void setBriefId(long briefId) {
        this.briefId = briefId;
    }

    public long getApprenantId() {
        return apprenantId;
    }

    public void setApprenantId(Long apprenantId) {
        this.apprenantId = apprenantId;
    }

    public void setApprenantId(long apprenantId) {
        this.apprenantId = apprenantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LivrableEntity that = (LivrableEntity) o;

        if (livrableId != that.livrableId) return false;
        if (briefId != that.briefId) return false;
        if (apprenantId != that.apprenantId) return false;
        if (postedAt != null ? !postedAt.equals(that.postedAt) : that.postedAt != null) return false;
        if (link != null ? !link.equals(that.link) : that.link != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (livrableId ^ (livrableId >>> 32));
        result = 31 * result + (postedAt != null ? postedAt.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (int) (briefId ^ (briefId >>> 32));
        result = 31 * result + (int) (apprenantId ^ (apprenantId >>> 32));
        return result;
    }

    public BriefEntity getBriefByBriefId() {
        return briefByBriefId;
    }

    public void setBriefByBriefId(BriefEntity briefByBriefId) {
        this.briefByBriefId = briefByBriefId;
    }

    public ApprenantEntity getApprenantByApprenantId() {
        return apprenantByApprenantId;
    }

    public void setApprenantByApprenantId(ApprenantEntity apprenantByApprenantId) {
        this.apprenantByApprenantId = apprenantByApprenantId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
