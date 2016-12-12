package model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by HaouJohan on 12/8/2016.
 */
public class EMF {
    private static final EntityManagerFactory emfInstance = Persistence.createEntityManagerFactory("bookstore");

    private EMF(){

    }

    public static EntityManagerFactory get(){

        return emfInstance;
    }
}
