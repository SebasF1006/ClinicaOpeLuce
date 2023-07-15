/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

/**
 *
 * @author HP
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String a ="sofia acAsio raTa rOrA";
        System.out.println(FormatoString(a));
    }
    
    public static String FormatoString(String palabra){
        String stg="";
        char letrauno=' ';
        char c=' ';
        int aux=0;
        
        for (int i = 0; i < palabra.length(); i++) {
            letrauno=palabra.charAt(0);
            c=palabra.charAt(i);
            
            if (letrauno==' ') {
                return null;
            }else if (!Character.isLetter(c)) {
                if (c != ' ') {
                  return null;  
                }
                
            }
            
            if (i==0) {
                c=Character.toUpperCase(c);
            }
            if (i>=1) {
                c=Character.toLowerCase(c);
            }
            if (c==' ') {
                aux=(i+1);
            }
            if (aux==i) {
                c=Character.toUpperCase(c);
            }
            
            stg+=c;
        }
        
        return stg;
    }
    
    
}
