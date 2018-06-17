The project retrieves product details from the Sainsbury’s Groceries website (URL - https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html).  The data will be processed and used to generate a json file containing the name, price, calories and description of all the products in the particular page.  

Executing "GroceryProductsApplication" (Main method) generates a Result.json and saves in /src/main/resources.  It will also print out the result on the screen.

The project can be separated into 5 main components: core, data, httpclient, pojo, and service.
1. data is the component that retrieves the html page from the url above and saves it into resources folder.  The reason of saving this HTML page is that it is unnecessary to download a new html page whenever this program runs.  However, you can specify the program to download if you feel it necessary by passing true to DataRetriever.downloadPageHtml(true, {{fileName}}) or you can pass the url where you want to get the data from DataRetriever.downloadPageHtml({{url}}, {{fileName}}).

2. httpclient is the component that makes http requests to the urls and retrieves/asserts httpresponse.  It also parsed HttpResponse to be a string.  

3. pojo is just three pure objects that is used to generate json file.

4. service is a set of helper classes that facilitates the process of reading, writing files.  It also uses Jsoup library to parse HTML page.

5. core is the component that does the business logic such as only extracting the necessary data from the html page, calculating the gross and removing invalid data field from the result.  

Unit tests can be found in /src/test/java folder.