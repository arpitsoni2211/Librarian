package com.arpit;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

class Librarian{
    int bookCount =0;
    int stuCount =0;

    Scanner sc =new Scanner(System.in);
    ArrayList<String> bookDetails = new ArrayList<>();
    ArrayList<String> stuName =new ArrayList<>();
    LocalDateTime dt =LocalDateTime.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d-L-yyyy H:mm a");

    public void existingStus() {
        this.stuName.add(stuCount,"Thomas");
        stuCount++;
        this.stuName.add(stuCount,"Arthur");
        stuCount++;
        this.stuName.add(stuCount,"John");
        stuCount++;
        this.stuName.add(stuCount,"Polly");
        stuCount++;
    }

    public void existingBooks(){
        this.bookDetails.add(bookCount,"The Alchemist");
        bookCount++;
        this.bookDetails.add(bookCount,"Dune");
        bookCount++;
        this.bookDetails.add(bookCount,"Pride and Prejudice");
        bookCount++;
        this.bookDetails.add(bookCount,"Beloved");
        bookCount++;
        this.bookDetails.add(bookCount,"The Lord of the Rings");
        bookCount++;
    }

    public void userInStu(){
        boolean bc=true;
        while (bc==true){
            System.out.println("Enter name of student: ");
            String name =sc.nextLine();
            if (name.equals("end")){
                bc=false;
                System.out.println("Students have been enrolled");
            }
            else{
                this.stuName.add(stuCount,name);
                stuCount++;
                System.out.println(name + " has been added as student");
            }
        }
    }

    public void stuList(){
        System.out.println("\nStudents Enrolled:");
        for (int i =0;i<this.stuName.size();i++){
            System.out.println( (i+1) + " " +this.stuName.get(i));
        }
    }

    public void userInBook(){

        boolean cb=true;
        while (cb==true){
            System.out.println("Enter Book name: ");
            String bname =sc.nextLine();
            if(bname.equals("end")){
                cb=false;
                System.out.println("Books have been added");
            }
            else {
                this.bookDetails.add(bookCount,bname);
                System.out.println(bname+ " has been added");
                bookCount++;
            }
        }
    }

    public void issueBook(){
        System.out.println("Enter the book name: ");
        String bn = sc.nextLine();
        System.out.println("Enter Student Name:");
        String sn = sc.nextLine();
        for (int i =0; i<this.stuName.size();i++){
            if (sn.equals(this.stuName.get(i))){
                for (int j =0; j<this.bookDetails.size();j++){
                    if (bn.equals(this.bookDetails.get(j))){
                        this.bookDetails.remove(bn);
                        System.out.println(sn+ " issued the book: \"" + bn + "\" on: " + dt.format(dtf));
                        bookCount--;
                    }
                }
            }
        }
    }

    public void returnBook(){
        System.out.println("Enter the book name: ");
        String bn = sc.nextLine();
        System.out.println("Enter Student Name");
        String sn = sc.nextLine();
        for (int i= 0; i<this.stuName.size();i++){
            if (sn.equals(this.stuName.get(i))){
                this.bookDetails.add(bookCount,bn);
                System.out.println(sn+ " returned the book: \"" + bn + "\" on: " + dt.format(dtf));
                bookCount++;
            }
//                System.out.println("No student enrolled with the name " + sn);
        }
    }

    public void totalBooks(){
        System.out.println("Total no. of books available: "+ this.bookCount);
        for (int i =0; i<bookDetails.size(); i++){
            System.out.println( (i+1)+". "+this.bookDetails.get(i));
        }


    }
    public void exSB(){
        existingStus();
        existingBooks();
    }

    public void activeLib(){

        System.out.println("1 for issuing a book");
        System.out.println("2 for returning a book");
        System.out.println("3 for adding books");
        System.out.println("4 for enrolling students");
        System.out.println("5 for displaying available books");
        System.out.println("6 for displaying enrolled students");
        System.out.println("0 for main menu");
        System.out.println("99 for shut down");

        boolean b= true;
        int a;
        Scanner sc1 =new Scanner(System.in);

        while(b){
            a = sc1.nextInt();

            switch (a){
                case 0: activeLib();
                break;

                case 1: stuList(); totalBooks();issueBook();
                break;

                case 2: returnBook();
                break;

                case 3: userInBook();
                break;

                case 4: userInStu();
                break;

                case 5: totalBooks();
                break;

                case 6: stuList();
                break;

                case 99: b=false;
                break;
            }

        }
    }
}

public class Adv_LIB {
    public static void main(String[] args) {

        Librarian lb =new Librarian();
        lb.exSB();
        lb.activeLib();

    }
}
