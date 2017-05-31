/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murach.data;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BigMac
 */

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import murach.business.*;

public class wordDB {

    public static String selectWord(int id){
    EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT word FROM Word word " +
                "WHERE id = :id";
        TypedQuery<Word> q = em.createQuery(qString, Word.class);

        try {
            Word currentWord = q.getSingleResult();
            return currentWord.getWord();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }

    }
}
