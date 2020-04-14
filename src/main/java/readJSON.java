
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class readJSON {

        @SuppressWarnings("unchecked")
        public void main()
        {
            JSONParser jsonParser = new JSONParser();

            try (FileReader reader = new FileReader("stock_transations.by.account.holder.json"))
            {
                Object obj = jsonParser.parse(reader);

                JSONArray personList = (JSONArray) obj;
                System.out.println(personList);

                personList.forEach( emp -> parsePersonObject( (JSONObject) emp ) );

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        private void parsePersonObject(JSONObject person)
        {
            JSONArray personObject = (JSONArray) person.get("stock_trades");

            String firstName = (String) person.get("type");
            System.out.println(firstName);

            String lastName = (String) person.get("stock_symbol");
            System.out.println(lastName);

            String website = (String) person.get("price_per_share");
            System.out.println(website);
        }
    }
