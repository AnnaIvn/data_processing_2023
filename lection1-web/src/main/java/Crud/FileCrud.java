package Crud;

import Entity.MyEntity;
import FileIO.FileIO;
import FileIO.FileIOInterface;

public class FileCrud implements Lab2CrudInterface
{
    // implementation of FileCrud interface
    FileIOInterface fio;

    public FileCrud(){
        this.fio = new FileIO();    // initialisation of fio
    }

    @Override
    public MyEntity readEntity()
    {
        return (MyEntity) fio.loadFromFile();
    }

    @Override
    public void updateEntity(MyEntity entity)
    {
        fio.saveToFile(entity);
    }
}
