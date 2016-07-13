/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.dao;

import ca.isimtl.myPortal.model.Matiere;
import java.util.List;
import org.hibernate.Criteria;

/**
 *
 * @author Francois YOUALEU
 */
public class MatiereDaoImpl extends AbstractDao<Integer, Matiere> implements MatiereDao{
    
    public List<Matiere> getAll(){
        Criteria criteria = createEntityCriteria();
        return (List<Matiere>) criteria.list();
    }
}
