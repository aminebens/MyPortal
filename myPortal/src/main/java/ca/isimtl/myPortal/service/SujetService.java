/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.service;

import ca.isimtl.myPortal.model.Sujet;
import ca.isimtl.myPortal.model.User;
import java.util.List;

public interface SujetService {

    List<Sujet> getAllSujet();

    List<Sujet> getAllSujetNonResolut();

    List<Sujet> getSujetByIdUser(User personne);

    List<Sujet> getSujetNonResolutByIdUser(User personne);

    Sujet getSujetById(int id);

    void saveSujet(Sujet sujet);

    void sujetResolut(Sujet sujet);
}
