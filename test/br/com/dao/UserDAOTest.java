/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.User;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author joaomiranda
 */
public class UserDAOTest {

    public UserDAOTest() {
    }

    @Ignore
    @Test
    public void testAdd() {

        User us;
        UserDAO desc;
        us = new User();
        desc = new UserDAO();

        us.setNome("Batata");
        desc.add(us);

        assertTrue(us.getNome() == null);

    }

    @Ignore
    @Test
    public void testRead() {

        UserDAO dao;
        dao = new UserDAO();

        for (User u : dao.read()) {
            System.out.println("ID: " + u.getId());
        }

    }

    @Ignore
    @Test
    public void testUpdate() {

        User us;
        UserDAO desc;

        us = new User();
        desc = new UserDAO();

        us.setId(1);
        us.setNome("Batata");
        desc.update(us);

        // us.getNome() == "Batata"
        assertTrue("Batata".equals(us.getNome()));

    }

    @Ignore
    @Test
    public void testDelete() {

        User us;
        UserDAO desc;

        us = new User();
        desc = new UserDAO();

        us.setId(1);
        desc.delete(us);

        assertTrue(us.getId() == null);
    }
}
