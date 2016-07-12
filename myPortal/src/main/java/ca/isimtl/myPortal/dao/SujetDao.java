/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.dao;

import ca.isimtl.myPortal.model.Sujet;
import java.util.List;


public interface SujetDao {
    List<Sujet> getAllSujet();
    List<Sujet> getAllSujetNonResolut();
    List<Sujet> getSujetByIdUser(int id);
    List<Sujet> getSujetNonResolutByIdUser(int id);
    Sujet getSujetById(int id);
    void saveSujet(Sujet sujet);
}
