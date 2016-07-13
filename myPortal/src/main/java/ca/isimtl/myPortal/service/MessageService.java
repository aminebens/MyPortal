/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.service;

import ca.isimtl.myPortal.model.Message;
import ca.isimtl.myPortal.model.Sujet;
import java.util.List;

/**
 *
 * @author yaantech
 */
public interface MessageService {
    Message findById(int id);
    void saveMessage(Message msg);
    List<Message> getMessageSujet(Sujet sujet);
}
