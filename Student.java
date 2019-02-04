package J29;

import java.util.ArrayList;

public class Student {

    private String imie;
    private String nazwisko;
    private int index;
    public static int count = 0; //deklaracja licznika studentów
    private ArrayList<Integer> lista_ocen;// = new ArrayList<>();//dopisano 31.01.2019
    //private int ocena = 0;

    public Student(String imie, String nazwisko, int index){ //konstruktor

        setImie(imie);
        setNazwisko(nazwisko);
        setIndex(index);
        
        this.lista_ocen = new ArrayList<>(); //tworząc nowy obiekt klasy student, tworzy w tym obiekcie nowy obiekt ktory jest listą ocen
        count += 1; //po utworzeniu obiektu dodaje do licznika nowego studenta

    }

    @Override
    public String toString() {
        return "Student{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", index=" + index +
                '}';
    }


    // gettery i setery

    public void setImie(String imie){
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko){
        this.nazwisko = nazwisko;
    }

    public void setIndex(int index){
        this.index = index;
    }

    public String getImie(){
        return this.imie;
    }

    public String getNazwisko(){
        return this.nazwisko;
    }

    public int getIndex(){
        return this.index;
    }
    
    public void getLista_ocen(){            //przeszukuję daną listę ocen i wypisuje po kolei elementy, oddzielone przecinkiem
        for (int tmp : this.lista_ocen){
            System.out.print(tmp);
            System.out.print(", ");
        }
        System.out.println("");
    }
    
    public void setOcena(int ocena){  //dodaje ocenę do danej listy przypisanej do studenta
        this.lista_ocen.add(ocena);
    }


}
