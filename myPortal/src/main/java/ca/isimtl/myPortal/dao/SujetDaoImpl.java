/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.dao;

import ca.isimtl.myPortal.model.Sujet;
import ca.isimtl.myPortal.model.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("sujetDao")
public class SujetDaoImpl extends AbstractDao<Integer, Sujet> implements SujetDao {

    public List<Sujet> getAllSujet() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("date_creation"));
        return (List<Sujet>)crit.list();
    }

    public List<Sujet> getAllSujetNonResolut() {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("isResolu", false));
        crit.addOrder(Order.asc("date_creation"));
        return (List<Sujet>) crit.list();
    }

    public List<Sujet> getSujetByIdUser(User personne) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("user", personne));
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        crit.addOrder(Order.asc("date_creation"));
        return (List<Sujet>) crit.list();
    }

    public List<Sujet> getSujetNonResolutByIdUser(User personne) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.and(Restrictions.eq("user", personne),Restrictions.eq("isResolu", false)));
        crit.addOrder(Order.asc("date_creation"));
        return (List<Sujet>) crit.list();
    }

    public Sujet getSujetById(int id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        return (Sujet) crit.uniqueResult();
    }

    public void saveSujet(Sujet sujet) {
        persist(sujet);
    }

}
