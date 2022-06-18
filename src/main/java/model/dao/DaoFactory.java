/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

/**
 *
 * @author jeana
 */
public class DaoFactory {
    public static RegistroDaoJpa novoRegistroDao() throws Exception {
        return new RegistroDaoJpa();
    }
}
