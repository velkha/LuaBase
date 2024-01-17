package lua.base.consola.luabase.util.resources;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.stream.StreamSupport;

public class GenericResources {
    private static final String MENUS_PATH="menus/menus.properties";
    public static String processJsonFromProperty(String propertiesFileName, String jsonPropertyName) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = GenericResources.class.getClassLoader().getResourceAsStream(propertiesFileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("Properties file not found in resources folder");
        }

        properties.load(inputStream);

        String jsonData = properties.getProperty(jsonPropertyName);
        if (jsonData == null) {
            throw new IllegalArgumentException("JSON property not found in the properties file");
        }

        JsonElement jsonElement = JsonParser.parseString(jsonData);

        if (jsonElement.isJsonArray()) {
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            return StreamSupport.stream(jsonArray.spliterator(), false)
                    .map(JsonElement::getAsString)
                    .reduce((s1, s2) -> s1 + "\n" + s2)
                    .orElse("");
        } else if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isString()) {
            return jsonElement.getAsString();
        } else {
            throw new IllegalArgumentException("JSON data is neither a string nor an array of strings");
        }
    }

    public static String getMenu(String menuName) throws IOException {
        return processJsonFromProperty(MENUS_PATH, menuName);
    }

}
