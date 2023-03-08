/*package Servlets;

import Crud.FileCrud;
import Crud.Lab2CrudInterface;

public class ServletConfig implements ServletConfigInterface
{
    Lab2CrudInterface l2ci;

    public ServletConfig(){            // constructor
        this.l2ci = new FileCrud();
    }

    public void setL2ci(Lab2CrudInterface l2ci)
    {
        this.l2ci = l2ci;
    }
    // we wrote all this to be able to change some things dynamically (while program is running)


    public Lab2CrudInterface getCrud(){
        return l2ci;     // під'єднали (інший) інтерфейс до метода getCrud
    }
}*/
