package edu.escuelaing.arep.ASE.app.webServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

import edu.escuelaing.arep.ASE.app.controllers.FilmController;
import edu.escuelaing.arep.ASE.app.views.FilmSearcher;

/**
 * This class represents a server of app
 */

public class HTTPServer {

    public static void main(String[] args) throws IOException {

        //instance of server
        ServerSocket server = null;

        //instance of controller
        FilmController controller = new FilmController();

        //instance of cache
        ConcurrentHashMap<String,String> cache = new ConcurrentHashMap<>();

        
        try{
            //create a instance of server
            server = new ServerSocket(35000);

        }catch(IOException e){
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }

        //instance of client

        Socket client = null;

        //run a server 

        while(!(server.isClosed())){
            try{
                System.out.println("Ready to receive");
                client = server.accept();

            }
            catch(IOException e2){
                System.out.println("Couldn't listen on port: 32000");
                System.exit(1);
            }

            //instance of response by server
            PrintWriter responseServer = new PrintWriter(client.getOutputStream(),true);

            //instance of response by client or input of server
            BufferedReader inputServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String inputLine;


            boolean firstline= true;

            String path = "";

            String filmTitle = "";

            while ((inputLine = inputServer.readLine()) != null) {

                System.out.println("Received: " + inputLine);

                if(firstline){
                    path = inputLine.split("/")[1].split(" ")[0];
                    filmTitle = inputLine.split("/")[2].split(" ")[0];
                    firstline = false;

                }

                if (!inputServer.ready()) {
                    break;
                }
                
                    
                
            }

            String response = "";


            if(path.equals("films")){
                if(cache.containsKey(filmTitle)){
                    response = cache.get(filmTitle);

                }
                else{
                    response = controller.getFilmByTitle(filmTitle, "http://www.omdbapi.com/?t=", "c45e3292");
                    cache.put(filmTitle, response);

                }
                responseServer.println("HTTP/1.1 200 OK");
                responseServer.println("Content-Type: application/json"); 
                responseServer.println("Content-Length: " + response.length());
                responseServer.println(); 
                responseServer.println(response);       
            }
            else{
                FilmSearcher page = new FilmSearcher();
                responseServer.println(page.getPage());

            }
            responseServer.close();
            inputServer.close();
            client.close();
            
            
        }
        server.close();
    }
}
