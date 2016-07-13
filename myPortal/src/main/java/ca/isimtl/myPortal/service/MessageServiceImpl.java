/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.service;

import ca.isimtl.myPortal.dao.MessageDao;
import ca.isimtl.myPortal.model.Message;
import ca.isimtl.myPortal.model.Sujet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("messageService")
@Transactional
public class MessageServiceImpl implements MessageService{

    @Autowired
    MessageDao messageDao;
    public Message findById(int id) {
       return messageDao.findById(id);
    }

    public void saveMessage(Message msg) {
        messageDao.saveMessage(msg);
    }

    public List<Message> getMessageSujet(Sujet sujet) {
        return messageDao.getMessageSujet(sujet);
    }
    
}
