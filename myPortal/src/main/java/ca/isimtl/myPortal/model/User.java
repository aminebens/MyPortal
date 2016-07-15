package ca.isimtl.myPortal.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Francois YOUALEU
 */
@Entity
@Table(name = "personne")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 3, max = 50)
    @Column(name = "login", nullable = false)
    private String login;

    @NotEmpty
    @Column(name = "password", nullable = false)
    private String pwd;

    @NotEmpty
    @Column(name = "nom", nullable = false)
    private String nom;

    @NotEmpty
    @Column(name = "prenom", nullable = false)
    private String prenom;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "date_naissance", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private LocalDate  dateNaissance;

    @NotEmpty
    @Column(name = "telephone", nullable = false)
    private String telephone;

    @NotEmpty
    @Column(name = "email", nullable = false)
    private String email;

    @NotEmpty
    @Column(name = "adresse", nullable = false)
    private String adresse;

    @Column(name = "NAS", nullable = true)
    private String numeroAssuranceSociale;

    @Column(name = "photo", nullable = true)
    private String photo;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id")
    private UserRole userRole;

    @Column(name = "titre", nullable = true)
    private String titre;

    @Column(name = "active", nullable = false)
    private Boolean active;

    public User() {
    }

    public User(int id, String login, String pwd, String nom, String prenom, LocalDate dateNaissance, String telephone, String email, String adresse, String numeroAssuranceSociale, String photo, String titre, Boolean active) {
        this.id = id;
        this.login = login;
        this.pwd = pwd;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.telephone = telephone;
        this.email = email;
        this.adresse = adresse;
        this.numeroAssuranceSociale = numeroAssuranceSociale;
        this.photo = photo;
        this.titre = titre;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumeroAssuranceSociale() {
        return numeroAssuranceSociale;
    }

    public void setNumeroAssuranceSociale(String numeroAssuranceSociale) {
        this.numeroAssuranceSociale = numeroAssuranceSociale;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
    
    @Override
    public String toString() {
        return "[" + id + ", " + login + "]";
    }

}
