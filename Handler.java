package com.tutorial.main;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by user on 27/01/2017.
 */
public class Handler {

    ArrayList<GameObject> object = new ArrayList<GameObject>();

    public void tick(){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);

            tempObject.tick();
        }
    }

    public void render(Graphics g) {
        try {
            for (int i = 0; i < object.size(); i++) {
                GameObject tempObject = object.get(i);

                tempObject.render(g);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }


    public void clearEnemys(){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);

            if(tempObject.getId() != ID.Player){
                object.clear();
                addObject(new Player((int) tempObject.getX(),(int) tempObject.getY(), ID.Player, this));
            }
        }
    }

    public void addObject(GameObject object){
        this.object.add(object);
    }

    public void removeObject(GameObject object){
        this.object.remove(object);
    }

}
