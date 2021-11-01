package com.podufalyy;

import com.podufalyy.db.HibernateManager;
import com.podufalyy.view.View;
import org.hibernate.Session;

public class App {
    public static void main(String[] args) {
        System.err.close();
        System.setErr(System.out);
        try (Session SESSION = HibernateManager.getSession()) {
            System.out.println("Test session established. ");
            new View().show();
        } catch (Throwable ex) {
            System.err.println("Test session failed.");
            ex.printStackTrace();
        }
    }
}
