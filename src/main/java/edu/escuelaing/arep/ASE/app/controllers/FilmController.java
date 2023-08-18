package edu.escuelaing.arep.ASE.app.controllers;

import java.io.IOException;

import edu.escuelaing.arep.ASE.app.services.FilmService;
import edu.escuelaing.arep.ASE.app.services.impl.FilmServiceImpl;

/**
 * this class is a controller of app, responsible for providing the service about  films.
 */

public class FilmController {

    private FilmService fm;


    /**
    * Create a insante of FilmController.
    */
    public FilmController(){
        fm = new FilmServiceImpl();

    }


    /**
    * method that get a film by title
    * @param query : title of the film
    * @param URL : url of api
    * @param apikey : key that connect with the api
    */
    public String getFilmByTitle(String query, String URL, String apikey) throws IOException{
        return fm.getFilmByTitle(query,URL,apikey);


    }




    
}
