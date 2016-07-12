/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.dao;

import ca.isimtl.myPortal.model.Sujet;
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

    public List<Sujet> getSujetByIdUser(int id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("idUser", id));
        crit.addOrder(Order.asc("date_creation"));
        return (List<Sujet>) crit.list();
    }

    public List<Sujet> getSujetNonResolutByIdUser(int id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.and(Restrictions.eq("idUser", id),Restrictions.eq("isResolu", false)));
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
