package Entity;

import java.util.ArrayList;
import java.util.List;

public class Mock
{
    private List<MyEntity> entityList = new ArrayList<>();

    public Mock (){
        MyEntity entity = new MyEntity("Sleeping bag#1", "/photo1", 2.2f, 2.4f);
        this.entityList.add(entity);

    }

    public List<MyEntity> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<MyEntity> entityList) {
        this.entityList = entityList;
    }
}
