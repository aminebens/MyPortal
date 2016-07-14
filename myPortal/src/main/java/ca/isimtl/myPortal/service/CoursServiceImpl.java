/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.service;

import ca.isimtl.myPortal.dao.CoursDao;
import ca.isimtl.myPortal.model.Cours;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Francois YOUALEU
 */
@Service("coursService")
@Transactional
public class CoursServiceImpl implements CoursService{

    @Autowired
    CoursDao coursdao;
    
    public List<Cours> getAll() {
        return coursdao.getAll();
    }

    public Cours findById(int id) {
         return coursdao.findById(id);
    }

    public void saveCours(Cours unCours) {
         coursdao.saveCours(unCours);
    }

    public void updateCours(Cours unCours) {
        Cours entity = coursdao.findById(unCours.getId());
        if(entity != null){
             entity.setLibelle(unCours.getLibelle());
             entity.setMaSession(unCours.getMaSession());
             entity.setPlageHoraire(unCours.getPlageHoraire());
             entity.setDateDebut(unCours.getDateDebut());
             entity.setDateFin(unCours.getDateFin());
             entity.setUneMat(unCours.getUneMat());
             entity.setProf(unCours.getProf());                  
        }
    }

    public void deleteCours(Cours unCours) {
        coursdao.deleteCours(unCours);
    }
    
}
