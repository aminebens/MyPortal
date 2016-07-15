

package ca.isimtl.myPortal.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Francois YOUALEU
 */
@Entity
@Table(name= "prof")
public class Prof implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;
    
    @NotEmpty
    @Column(name = "competence", nullable = false)
    private String competence;

    @OneToOne
    @JoinColumn(name="id_personne")
    private User user;
    
    @OneToMany(mappedBy = "prof", cascade  = CascadeType.ALL)
    private List<Cours>  mesCours;

    public Prof() {
    }

    public Prof(int id, String competence, User user) {
        this.id = id;
        this.competence = competence;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Cours> getMesCours() {
        return mesCours;
    }

    public void setMesCours(List<Cours> mesCours) {
        this.mesCours = mesCours;
    }
    
}
