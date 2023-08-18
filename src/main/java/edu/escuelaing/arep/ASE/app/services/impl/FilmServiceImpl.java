package edu.escuelaing.arep.ASE.app.services.impl;

import java.io.IOException;

import edu.escuelaing.arep.ASE.app.ExternalsWebServices.FactoryOmdapiConnection;
import edu.escuelaing.arep.ASE.app.ExternalsWebServices.FactoryExternalsService;
import edu.escuelaing.arep.ASE.app.ExternalsWebServices.ExternalServices;
import edu.escuelaing.arep.ASE.app.services.FilmService;

/**
 * this class is a impleemntation of service of our backend
 */

public class FilmServiceImpl  implements FilmService{


    FactoryExternalsService OdmApiconnection;


    

    /**
    * create a instance of FilmServiceImpl  
    */
    public FilmServiceImpl(){
        this.OdmApiconnection = new FactoryOmdapiConnection();
    }


    /**
    * method that connect whit the external web services and get data of film
    * @param query : title of the film
    * @param URL : url of api
    * @param apikey : key that connect with the api
    */
    @Override
    public String getFilmByTitle(String query,String URL, String apikey) throws IOException {
        
        ExternalServices ApiConnection = this.OdmApiconnection.connection(URL, apikey);
        return ApiConnection.getData(query);        
    }
    
    
}
