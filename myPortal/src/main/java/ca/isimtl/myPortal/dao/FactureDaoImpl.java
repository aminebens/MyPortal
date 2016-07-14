/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.dao;

import ca.isimtl.myPortal.model.Facture;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nicolas
 */

@Repository("factureDao")
public class FactureDaoImpl extends AbstractDao<Integer, Facture> implements FactureDao {

    public Facture findByUserId(int idUser) {
        
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("idUser", idUser));
        Facture facture = (Facture)criteria.uniqueResult();
        
        return facture;
    }
    
}
