/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.dao;

import ca.isimtl.myPortal.model.Message;
import ca.isimtl.myPortal.model.Sujet;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("messageDao")
public class MessageDaoImpl extends AbstractDao<Integer ,Message> implements MessageDao{

    public Message findById(int id) {
        return getByKey(id);
    }

    public void saveMessage(Message msg) {
        persist(msg);
    }

    public List<Message> getMessageSujet(Sujet sujet) {
         Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("sujet", sujet));
        crit.addOrder(Order.asc("date"));
        return (List<Message>) crit.list();
    }
    
}
