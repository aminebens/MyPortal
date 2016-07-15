/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.security;

import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Amine
 */
public class AppGrantedAuthority implements GrantedAuthority {

    private static final long serialVersionUID = 1029928088340565343L;

    private final String rolename;

    public AppGrantedAuthority(String rolename) {
        this.rolename = rolename;
    }

    public String getAuthority() {
        return "ROLE_" + this.rolename;
    }

}
