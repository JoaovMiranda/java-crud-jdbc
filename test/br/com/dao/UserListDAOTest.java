package br.com.dao;

import org.junit.Test;

/**
 *
 * @author joaomiranda
 */
public class UserListDAOTest {
    
    public UserListDAOTest() {
    }

    @Test
    public void testRead() {

        UserListDAO dao;
        dao = new UserListDAO();

        dao.readFull().forEach((u) -> {
            System.out.println("ID: " + u.getId());
        });

    }
    
}
