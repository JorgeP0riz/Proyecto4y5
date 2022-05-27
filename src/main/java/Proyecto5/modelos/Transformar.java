package Proyecto5.modelos;

import Proyecto5.ui.Imagen;

import java.awt.*;

public abstract class Transformar {

    protected Imagen img;

    public abstract void transformar(Point punto1,Point punto2);
}
