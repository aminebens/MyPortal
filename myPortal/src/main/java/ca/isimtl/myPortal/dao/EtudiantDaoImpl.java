/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.dao;

import ca.isimtl.myPortal.model.Etudiant;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Francois YOUALEU
 */
@Repository("etudiantDao")
public class EtudiantDaoImpl extends AbstractDao<Integer, Etudiant> implements EtudiantDao {

    public Etudiant findById(int id) {
        return getByKey(id);
    }
    
    public Etudiant findByIdPersonne(int id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("idPersonne", id));
        return (Etudiant) criteria.uniqueResult();
    }

    public List<Etudiant> getAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Etudiant>) criteria.list();
    }
    
    public void saveEtudiant(Etudiant etu) {
        persist(etu);
    }
    
}
