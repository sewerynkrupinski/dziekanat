package J29;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {

    ArrayList<Student> studentList = new ArrayList<>(); //utworzenie listy studentow (obiektow typu Student)
    Scanner input = new Scanner(System.in);

    public StudentController(){
        boolean flag = true; //zastosowano flage bo switch po wybraniu q nie moglby opuscic petli
        while(flag){
            System.out.println("A - dodaj, S - pokaż, D - usuń, U - zmodyfikuj, C - liczba studentów, Q - wyjście");
            String wybor = input.nextLine().toUpperCase();

            switch(wybor){
                case "A":
                    addStudent();
                    break;
                case "D":
                    subStudent();
                    break;
                case "S":
                    showStudent();
                    break;
                case "C":
                    countStudent();
                    break;
                case "U":
                    modStudent();
                    break;
                case "Q":
                    flag = false;
                    input.close();
                    break;
                default:
                    System.out.println("Błędny wybór");
            }//switch

        }//while

    }//student controller

    public void addStudent(){

        System.out.println("Podaj imię studenta");
        String imie = input.nextLine();
        System.out.println("Podaj nazwisko studenta");
        String nazwisko = input.nextLine();
        System.out.println("Podaj index studenta");
        int index = input.nextInt();
        input.nextLine(); //konsumuje enter
        studentList.add(new Student(imie, nazwisko, index));  //dodaje nowy obiekt do listy, z podanymi parametrami

    }

    public void subStudent(){
        System.out.println("Podaj index studenta do usunięcia");
        int index = input.nextInt();
        input.nextLine();
        for (Student val : studentList){ //przeglada liste studentow i dany obiekt zapisuje do tymczasowej zmiennej val
            if (val.getIndex() == index) { //pobiera z danego obiektu indeks i sprawdza czy jest rowny z wprowadzonym z klawiatury i jeśli tak...
                studentList.remove(val); //... to usuwa dany obiekt
                Student.count -=1;      //pomniejsza licznik studentow o 1
                break;
            }
        }

    }

    public void showStudent(){ //wyświetla listę wszystkich studentow

        for (Student tmp : studentList){
            System.out.println("imię: "+tmp.getImie()+ " ,nazwisko: " +tmp.getNazwisko()+ " ,index: " +tmp.getIndex());


        }

    }

    public void countStudent(){ //wyswietla liczbe studentow

        System.out.println("Liczba studentów: " +Student.count);
    }

    public void modStudent(){  //modyfikacja studenta

        System.out.println("Podaj index studenta do modyfikacji");
        int index = input.nextInt();
        input.nextLine();
        System.out.println("Podaj imię");
        String imie = input.nextLine();
        System.out.println("Podaj nazwisko");
        String nazwisko = input.nextLine();

        for (Student val2 : studentList){  //przeglada liste studentow
            if (val2.getIndex() == index){ //z kazdego obiektu sprawdza indeks i sprawdza czy ten indeks jest taki sam jak wprowadzony z klawiatury
                if (!imie.equals("")){ //jesli wprowadzony jest inny niz pusty to zmienia imie z uzyciem setera
                    val2.setImie(imie);
                }
                if (!nazwisko.equals("")){   //jesli wprowadzone nazwisko jest rozne od pustego to ustawia nowe naziwsko
                    val2.setNazwisko(nazwisko);
                }

                break;
            }
        }
    }
}



