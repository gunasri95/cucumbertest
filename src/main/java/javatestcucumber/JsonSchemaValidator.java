package javatestcucumber;


import java.io.InputStream;
import org.json.JSONObject;
import org.json.JSONTokener;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;

public class JsonSchemaValidator {

    private static String schemaFilePath;

    // Getter for schemaFilePath
    public static String getSchemaFilePath() {
        return schemaFilePath;
    }

    // Setter for schemaFilePath
    public static void setSchemaFilePath(String schemaFilePath) {
        JsonSchemaValidator.schemaFilePath = schemaFilePath;
    }
    public static boolean validateResponseSchema(JSONObject jsonResponse, String schemaFilePath) {
        try (InputStream schemaStream = JsonSchemaValidator.class.getResourceAsStream(schemaFilePath)) {
            JSONObject schemaJson = new JSONObject(new JSONTokener(schemaStream));
            Schema schema = SchemaLoader.load(schemaJson);
            schema.validate(jsonResponse);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}