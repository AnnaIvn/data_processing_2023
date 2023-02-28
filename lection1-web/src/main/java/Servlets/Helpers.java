package Servlets;

import Entity.MyEntity;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Helpers {
    public Helpers() {
    }

    public static JsonElement bodyParse(HttpServletRequest request) {  // парсить з request в body
        JsonElement jsonElement = null;

        try {
            jsonElement = JsonParser.parseReader(request.getReader());   // пробуємо розпарсити
        } catch (JsonSyntaxException | IOException | JsonIOException e) {
            e.printStackTrace();
        }

        return jsonElement;
    }

    public static MyEntity entityParse(HttpServletRequest request) {
        MyEntity entity = new MyEntity();
        JsonElement jsonElement = bodyParse(request);
        entity.setName(jsonElement.getAsJsonObject().get("name").getAsString());
        entity.setPhoto(jsonElement.getAsJsonObject().get("photo").getAsString());
        entity.setWeight(jsonElement.getAsJsonObject().get("weight").getAsFloat());
        entity.setLength(jsonElement.getAsJsonObject().get("length").getAsFloat());
        return entity;
    }


    
    public static int getNextId(List<MyEntity> list) {
        int maxId = 0;
        Iterator<MyEntity> iterator = list.iterator();

        while(iterator.hasNext()) {
            int currentId = ((MyEntity)iterator.next()).getId();
            if (currentId > maxId) {
                maxId = currentId;
            }
        }
        return maxId + 1;
    }

    public static int getIndexByUserId(int id, List<User> list) {
        int listId = id;
        Iterator<User> iterator = list.iterator();

        while(iterator.hasNext()) {
            User temp = (User)iterator.next();
            if (temp.getId() == listId) {
                listId = list.indexOf(temp);
                break;
            }
        }

        return listId;
    }
}
