// for lab 4

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
        entity.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
        entity.setName(jsonElement.getAsJsonObject().get("name").getAsString());
        entity.setWeight(jsonElement.getAsJsonObject().get("weight").getAsInt());
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

    public static int getIndexByEntityId(int id, List<MyEntity> list) {
        int listId = id;
        Iterator<MyEntity> iterator = list.iterator();

        while(iterator.hasNext()) {
            MyEntity temp = (MyEntity) iterator.next();
            if (temp.getId() == listId) {
                listId = list.indexOf(temp);
                break;
            }
        }

        return listId;
    }
}
