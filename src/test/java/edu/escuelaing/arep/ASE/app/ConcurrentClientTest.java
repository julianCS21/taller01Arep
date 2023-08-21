package edu.escuelaing.arep.ASE.app;

import java.io.IOException;
import java.lang.ModuleLayer.Controller;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.escuelaing.arep.ASE.app.controllers.FilmController;


/**
 * test backend.
 */
public class ConcurrentClientTest {

    public FilmController controllerTest;

    @Before
    public void setUp() throws Exception {
        controllerTest = new FilmController();
    }

    private  class FilmTestRunnable implements Runnable {
        @Override
        public void run() {
            try {
                String resultGet = controllerTest.getFilmByTitle("the+avengers", "http://www.omdbapi.com/?t=", "c45e3292");
                String jsonString = "{\"Title\":\"The Avengers\",\"Year\":\"2012\",...}";

                Assert.assertEquals(resultGet, jsonString);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void whenItDoACorrectGetRequestShouldToShowAFilmConcurrently() throws InterruptedException {
        Thread[] threads = new Thread[10]; 

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new FilmTestRunnable());
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }

}
    
