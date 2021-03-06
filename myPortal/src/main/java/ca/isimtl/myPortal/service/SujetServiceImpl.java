/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.service;

import ca.isimtl.myPortal.dao.SujetDao;
import ca.isimtl.myPortal.model.Sujet;
import ca.isimtl.myPortal.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("sujetService")
@Transactional
public class SujetServiceImpl implements SujetService{

    @Autowired
    SujetDao sujetDao;
    
    public List<Sujet> getAllSujet() {
        return sujetDao.getAllSujet();
    }

    public List<Sujet> getAllSujetNonResolut() {
        return sujetDao.getAllSujetNonResolut();
    }

    public List<Sujet> getSujetByIdUser(User personne) {
        return sujetDao.getSujetByIdUser(personne);
    }

    public List<Sujet> getSujetNonResolutByIdUser(User personne) {
        return sujetDao.getSujetNonResolutByIdUser(personne);
    }

    public Sujet getSujetById(int id) {
        return sujetDao.getSujetById(id);
    }

    public void saveSujet(Sujet sujet) {
        sujetDao.saveSujet(sujet);
    }

    public void sujetResolut(Sujet sujet) {
        Sujet entity = sujetDao.getSujetById(sujet.getId());
        if(entity != null){
            entity.setIsResolu(true);
        }
    }
}
