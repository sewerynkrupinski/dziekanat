package J29;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {

    ArrayList<Student> studentList = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public StudentController(){
        boolean flag = true;
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
        input.nextLine();
        studentList.add(new Student(imie, nazwisko, index));

    }

    public void subStudent(){
        System.out.println("Podaj index studenta do usunięcia");
        int index = input.nextInt();
        input.nextLine();
        for (Student val : studentList){
            if (val.getIndex() == index) {
                studentList.remove(val);
                Student.count -=1;
                break;
            }
        }

    }

    public void showStudent(){

        for (Student tmp : studentList){
            System.out.println("imię: "+tmp.getImie()+ " ,nazwisko: " +tmp.getNazwisko()+ " ,index: " +tmp.getIndex());


        }

    }

    public void countStudent(){

        System.out.println("Liczba studentów: " +Student.count);
    }

    public void modStudent(){

        System.out.println("Podaj index studenta do modyfikacji");
        int index = input.nextInt();
        input.nextLine();
        System.out.println("Podaj imię");
        String imie = input.nextLine();
        System.out.println("Podaj nazwisko");
        String nazwisko = input.nextLine();

        for (Student val2 : studentList){
            if (val2.getIndex() == index){
                if (!imie.equals("")){
                    val2.setImie(imie);
                }
                if (!nazwisko.equals("")){
                    val2.setNazwisko(nazwisko);
                }

                break;
            }
        }


    }

}



