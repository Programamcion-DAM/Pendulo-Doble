
package Code;

import processing.core.*;

public class Pendulo extends PApplet{
    float r1;
    float r2;
    float m1;
    float m2;
    float a1;
    float a2;
    float a1_v = 0;
    float a2_v = 0;
    float g;
    
    public float x1 = 0;
    public float y1 = 0;
    public float x2 = 0;
    public float y2 = 0;
    
    
    float a1_a;
    float a2_a;
    
    public Pendulo(float r1,float r2,float m1,float m2,float a1,float a2,float g){
        this.r1 = r1;
        this.r2 = r2;
        this.m1 = m1;
        this.m2 = m2;
        this.a1 = a1;
        this.a2 = a2;
        this.g = g;
    }
    
    public void calcular(){
        float num1 = -g * (2 * m1 + m2) * sin(a1);
        float num2 = -m2 * g * sin(a1-2*a2);
        float num3 = -2*sin(a1-a2)*m2;
        float num4 = a2_v*a2_v * r2 + a1_v*a1_v * r1 * cos(a1-a2);
        float den = r1 * (2*m1+m2-m2*cos(2*a1 -2*a2));
        a1_a = (num1 + num2 + num3*num4) / den;
 
        num1 = 2 * sin(a1-a2);
        num2 = (a1_v*a1_v*r1*(m1+m2));
        num3 = g * (m1 + m2) * cos(a1);
        num4 = a2_v*a2_v*r2*m2*cos(a1-a2);
        den = r2 * (2*m1+m2-m2*cos(2*a1-2*a2));
        a2_a = (num1*(num2+num3+num4)) / den;
    }
    
    public void mover(){
        x1 = r1 * sin(a1);
        y1 = r1 * cos(a1);
        x2 = x1 + r2 * sin(a2);
        y2 = y1+ r2 * cos(a2);
        
        a1_v += a1_a;
        a2_v += a2_a;
        a1 += a1_v;
        a2 += a2_v;
    }
    
}
