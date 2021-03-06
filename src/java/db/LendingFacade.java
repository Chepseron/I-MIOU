/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Amon.Sabul
 */
@Stateless
public class LendingFacade extends AbstractFacade<Lending> {

    @PersistenceContext(unitName = "IOUPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LendingFacade() {
        super(Lending.class);
    }
    
}
