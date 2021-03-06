/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.service;

import ca.isimtl.myPortal.model.Alert;
import java.util.List;

/**
 *
 * @author yaantech
 */
public interface AlertService {
    List<Alert> findByIdUserTO(Integer idUserTo);
    List<Alert> findByIdUserFrom(Integer idUserFrom);
    List<Alert> findByIdGroup(Integer idGroup);
    Alert findByid(int id);
    void saveAlert(Alert alert);
    void updateAlert(Alert alert);
    void deleteAlert(Alert alert);
    List<Alert> getAllAlert();
}
