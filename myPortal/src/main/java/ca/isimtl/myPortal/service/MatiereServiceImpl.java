/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.service;

import ca.isimtl.myPortal.dao.MatiereDao;
import ca.isimtl.myPortal.model.Matiere;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Francois YOUALEU
 */
@Service("matiereService")
@Transactional
public class MatiereServiceImpl implements MatiereService {

    @Autowired
    MatiereDao matieredao;

    public List<Matiere> getAllMatieres() {
        return matieredao.getAll();
    }

}
