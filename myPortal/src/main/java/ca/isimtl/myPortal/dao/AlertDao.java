/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.dao;

import ca.isimtl.myPortal.model.Alert;
import java.util.List;

/**
 *
 * @author yaantech
 */
public interface AlertDao {
    List<Alert> findByIdUserTO(Integer idUserTo);
    List<Alert> findByIdGroup(Integer idGroup);
    Alert findByid(int id);
    void saveAlert(Alert alert);
    List<Alert> getAllAlert();
}
