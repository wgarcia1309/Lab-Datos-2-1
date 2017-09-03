package lab1_willian_garcia;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Nodo {
    public static Stack<Nodo> pilab=new Stack();
    public static Stack<Nodo> pilac=new Stack();
    private char id;
    private Nodo letras[]= new Nodo[28];

    public Nodo() {
        id='-';
    }
    public Nodo(char id) {
        this.id=id;
    }
    public Nodo fn(){
        Nodo n=new Nodo();
        n.id='$';
        return n;
    }
    public Nodo cp(){
        Nodo n=new Nodo();
        n.id='*';
        return n;
    }

    public void add(String word){
        Nodo root=this;
         Nodo temp[]=letras;
        for (int i = 0; i < word.length() ; i++){
            char l=word.charAt(i);
            int indx=-65+(int)(l);
            if(temp[indx]==null){
                temp[indx]= new Nodo(l);
                temp=temp[indx].letras;
            }else{
                temp=temp[indx].letras;
            }
        }
        temp[27]=fn();
    }    
    public void lvl(Nodo raiz){
     Queue <Nodo> queque =new LinkedList();
     queque.add(raiz);
     while(!queque.isEmpty()){
          Nodo x=queque.remove();
          System.out.print(x.id);
          for (int i = 0; i < 28; i++) {
             if(x.letras[i]!=null){
                 queque.add(x.letras[i]);
             }
         }
        }
        System.out.println();
    }
    public void printS(){
        System.out.println("base");
        for (int i = 0; i <pilab.size(); i++) {
            System.out.print(pilab.get(i).id);
        }
        System.out.println();
    }
     public void printS2(){   
         System.out.println("complemento");
         for (int i = 0; i <pilac.size(); i++) {
//        for (int i = pilac.size()-1; i >=0; i--) {
            System.out.print(pilac.get(i).id);
        }
         System.out.println();
    }
    public Nodo s(String txt) {
        Nodo temp= this;
        if(!pilab.isEmpty())pilab.removeAllElements();
        if(!pilac.isEmpty())pilac.removeAllElements();
        int i =0;
        while(i<txt.length()){
            char l=txt.charAt(i);
            Nodo x=temp.letras[-65+(int)(l)];
            if(x==null)break;
            pilab.add(x);
            temp=x;
            i++;
        }
        return temp;
    }
    public void p() {
        Nodo n=this;
        if(n!=null){
            Nodo t2=n.letras[27];
            pilac.add(n);
            if(t2!=null && !n.end())pilac.add(cp());
            else if (t2!=null)pilac.add(t2);
            for (int i = 0; i < 27; i++) {
                Nodo x=n.letras[i];
               if(x!=null)x.p();
            }
        }
    }
    public void pre(Nodo n){
        if(n!=null){
            Nodo temp=n,t2=temp.letras[27];
            System.out.print(temp.id);
            for (int i = 0; i < 27; i++) {
                pre(temp.letras[i]);
            }
            if(t2!=null)System.out.print(t2.id);
        }
    }
    private boolean end(){
        Nodo n=this;
        boolean a=true;
        for (int i = 0; i < 27 && a; i++) {
            if(n.letras[i]!=null)a=false;
        }
        return a;
    }

    String getbBse() {
        String m="";
        for (int i = 0; i < pilab.size(); i++) {
            m+=pilab.get(i).id;
        }
        return m;
    }

    String getCp() {
        String m="";
        for (int i = 0; i < pilac.size(); i++) {
            m+=pilac.get(i).id;
        }
        return m;
    }
}
