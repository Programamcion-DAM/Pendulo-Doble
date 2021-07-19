
package Code;

import java.util.ArrayList;
import processing.core.*;

public class Main extends PApplet{
    ArrayList<Pendulo> pendulos = new ArrayList<Pendulo>();
    
    Pendulo p1 = new Pendulo((float)150,120,30,30,PI,2,(float)1.5);
    Pendulo p2 = new Pendulo(150,120,30,31,PI,2,(float)1.5);
    
    public static void main(String[] args) {
        PApplet.main(new String[]{Code.Main.class.getName()});
    }
    
    @Override
    public void settings(){
        size(1800,900);
    }
    
    @Override
    public void setup(){
        pendulos.add(p1);
        pendulos.add(p2);
    }
    
    @Override
    public void draw(){
        background(0);
        stroke(255);
        strokeWeight(2);
        
        for(int i = 0;i<pendulos.size();i++){
            pendulos.get(i).calcular();
            pendulos.get(i).mover();
            
            if(i == 0){
                translate((1800/pendulos.size())/2,350);
            }
            else{
                translate(1800/pendulos.size(),0);
            }
            
            fill(255);
            line(0,0,pendulos.get(i).x1,pendulos.get(i).y1);
            ellipse(pendulos.get(i).x1,pendulos.get(i).y1,pendulos.get(i).m1,pendulos.get(i).m1);
            line(pendulos.get(i).x1,pendulos.get(i).y1,pendulos.get(i).x2,pendulos.get(i).y2);
            ellipse(pendulos.get(i).x2,pendulos.get(i).y2,pendulos.get(i).m2,pendulos.get(i).m2);
        }   
    }
}


/* Experimento 1
    Pendulo p1 = new Pendulo((float)99.9,100,20,20,PI,2,1);
    Pendulo p2 = new Pendulo(100,100,20,20,PI,2,1);
    Pendulo p3 = new Pendulo((float)100.1,100,20,20,PI,2,1);
*/

/* Experimento 2
    Pendulo p1 = new Pendulo((float)150,120,30,30,PI,2,(float)1.5);
    Pendulo p2 = new Pendulo(150,120,30,31,PI,2,(float)1.5);
*/

/* Experimento 3
    Pendulo p1 = new Pendulo(99,200,40,40,PI,2,(float)1.5;
*/
