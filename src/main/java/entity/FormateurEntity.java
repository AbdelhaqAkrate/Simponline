package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "formateur", schema = "simplonlite", catalog = "")
public class FormateurEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "formateurId")
    private long formateurId;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "fullName")
    private String fullName;
    @Basic
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "formateurByFormateurId")
    private Collection<PromotionEntity> promotionsByFormateurId;

    public long getFormateurId() {
        return formateurId;
    }

    public void setFormateurId(Long formateurId) {
        this.formateurId = formateurId;
    }

    public void setFormateurId(long formateurId) {
        this.formateurId = formateurId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FormateurEntity that = (FormateurEntity) o;

        if (formateurId != that.formateurId) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (fullName != null ? !fullName.equals(that.fullName) : that.fullName != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (formateurId ^ (formateurId >>> 32));
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    public Collection<PromotionEntity> getPromotionsByFormateurId() {
        return promotionsByFormateurId;
    }

    public void setPromotionsByFormateurId(Collection<PromotionEntity> promotionsByFormateurId) {
        this.promotionsByFormateurId = promotionsByFormateurId;
    }
}
