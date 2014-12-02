/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.beans;

/**
 *
 * @author johneisenheim
 */
public final class Permissions {
    
    private int idPermission;
    private String description = null;
    private String permissionClass = null;
    
    public Permissions(){}
    
    public Permissions( String description, String permissionClass ){
        setDescription(description);
        setPermissionClass(permissionClass);
    }

    public int getIdPermission() {
        return idPermission;
    }

    public String getDescription() {
        return description;
    }

    public String getPermissionClass() {
        return permissionClass;
    }

    public void setIdPermission(int idPermission) {
        this.idPermission = idPermission;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPermissionClass(String permissionClass) {
        this.permissionClass = permissionClass;
    }

}
