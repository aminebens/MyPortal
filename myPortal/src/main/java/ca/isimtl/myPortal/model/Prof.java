
package ca.isimtl.myPortal.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Francois YOUALEU
 */
@Entity
@Table(name= "prof")
public class Prof implements Serializable {
    
    @NotNull
    @Id
    @Column(name = "id_prof", nullable = false)
    private int id;
    
    @NotEmpty
    @Column(name = "competence", nullable = false)
    private String competence;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private User user;

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
    
}
