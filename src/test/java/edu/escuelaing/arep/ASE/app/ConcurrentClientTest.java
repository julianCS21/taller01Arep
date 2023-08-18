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

    FilmController controllerTest;

    @Before
    public void setUp() throws Exception {
        controllerTest = new FilmController();
    }


    @Test
    public void WhenItDoACorrectGetRequestShouldToShowAFilm() throws IOException{

        //request and results
        String resultGet = controllerTest.getFilmByTitle("the+avengers", "http://www.omdbapi.com/?t=","c45e3292");


        String jsonString = "{\"Title\":\"The Avengers\",\"Year\":\"2012\",\"Rated\":\"PG-13\",\"Released\":\"04 May 2012\",\"Runtime\":\"143 min\",\"Genre\":\"Action, Sci-Fi\",\"Director\":\"Joss Whedon\",\"Writer\":\"Joss Whedon, Zak Penn\",\"Actors\":\"Robert Downey Jr., Chris Evans, Scarlett Johansson\",\"Plot\":\"Earth's mightiest heroes must come together and learn to fight as a team if they are going to stop the mischievous Loki and his alien army from enslaving humanity.\",\"Language\":\"English, Russian\",\"Country\":\"United States\",\"Awards\":\"Nominated for 1 Oscar. 38 wins & 80 nominations total\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"8.0/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"91%\"},{\"Source\":\"Metacritic\",\"Value\":\"69/100\"}],\"Metascore\":\"69\",\"imdbRating\":\"8.0\",\"imdbVotes\":\"1,426,217\",\"imdbID\":\"tt0848228\",\"Type\":\"movie\",\"DVD\":\"22 Jun 2014\",\"BoxOffice\":\"$623,357,910\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}";


        //Asserts

        Assert.assertEquals(resultGet,jsonString);



    }
}
    
