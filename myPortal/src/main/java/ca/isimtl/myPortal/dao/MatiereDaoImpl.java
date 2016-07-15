/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.dao;

import ca.isimtl.myPortal.model.Matiere;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Francois YOUALEU
 */
@Repository("matiereDao")
public class MatiereDaoImpl extends AbstractDao<Integer, Matiere> implements MatiereDao{
    
    @SuppressWarnings("unchecked")
    public List<Matiere> getAll(){
        Criteria criteria = createEntityCriteria();
        return (List<Matiere>) criteria.list();
    }

    public Matiere findById(int id) {
        return getByKey(id);
    }

    public void saveMatiere(Matiere uneMatiere) {
        persist(uneMatiere);
    }

    public void deleteMatiere(Matiere uneMatiere) {
        delete(uneMatiere);
    }
}
