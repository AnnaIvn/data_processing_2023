package Crud;

import Entity.MyEntity;

public interface Lab2CrudInterface
{
    public MyEntity readEntity();   // to read entities
    public void updateEntity(MyEntity entity);   // to update MyEntity
}
