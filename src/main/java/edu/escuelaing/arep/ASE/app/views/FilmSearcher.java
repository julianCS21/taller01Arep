package edu.escuelaing.arep.ASE.app.views;

/**
    *class that define a view of page
*/

public class FilmSearcher {

    /**
    *method that return a page
    */
    public String getPage() {
        
        

        String htmlContent =  "HTTP/1.1 200 OK\r\n" +
        "Content-Type: text/html\r\n" +
        "\r\n" +
        "<!DOCTYPE html>\n" +
        "<html>\n" +
        "<head>\n" +
        "  <title>Searcher of films</title>\n" +
        "  <meta charset=\"UTF-8\">\n" +
        "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
        "  <style>\n" +
        "    body {\n" +
        "      font-family: Arial, sans-serif;\n" +
        "      text-align: center;\n" +
        "      margin-top: 50px;\n" +
        "    }\n" +
        "    h1 {\n" +
        "      color: #333;\n" +
        "    }\n" +
        "    input[type=\"text\"] {\n" +
        "      width: 300px;\n" +
        "      padding: 10px;\n" +
        "      font-size: 16px;\n" +
        "      border: 1px solid #ccc;\n" +
        "      border-radius: 5px;\n" +
        "      box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);\n" +
        "      outline: none;\n" +
        "    }\n" +
        "    button[type=\"submit\"] {\n" +
        "      background-color: #007bff;\n" +
        "      color: white;\n" +
        "      border: none;\n" +
        "      padding: 10px 20px;\n" +
        "      font-size: 16px;\n" +
        "      border-radius: 5px;\n" +
        "      cursor: pointer;\n" +
        "      transition: background-color 0.3s;\n" +
        "    }\n" +
        "    button[type=\"submit\"]:hover {\n" +
        "      background-color: #0056b3;\n" +
        "    }\n" +
        "  </style>\n" +
        "</head>\n" +
        "<body>\n" +
        "  <h1>Searcher of films</h1>\n" +
        "  <form action=\"/search\" method=\"get\">\n" +
        "    <input type=\"text\" name=\"q\" placeholder=\"Search a film...\">\n" +
        "    <br><br>\n" +
        "    <button type=\"button\" onclick=\"searchFilm()\">Search</button>\n" +
        "  </form>\n" +
        "  <h1 id=\"film\">Film</h1>         " +
        "  <script>\n" +
        "    function searchFilm() {\n" +
        "      var input = document.querySelector('input[name=\"q\"]');\n" +
        "      var filmTitle = input.value.replace(/ /g, \"+\");\n" +
        "      var url = \"http://localhost:35000/films/\" + filmTitle;\n" +
        "      fetch(url)\n" +
        "        .then(response => response.text())\n" +
        "        .then(data => (document.getElementById(\"film\").innerHTML = data))\n" +
        "        .catch(error => console.error('Error:', error));\n" +
        "    }\n" +
        "  </script>\n" +
        "</body>\n" +
        "</html>";

        return htmlContent;

                
    }
    
}
