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
    
    public List<Cours> getAllCours() {
        return coursdao.getAllCours();
    }
    
}
