import java.util.Scanner;
public class Jfsd1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String name;
        int age;
        float cgpa;
        char grade;
        System.out.println("Enter your name: ");
        name = sc.nextLine();
        System.out.println("Enter your age: ");
        age = sc.nextInt();
        System.out.println("Enter your cgpa: ");
        cgpa = sc.nextFloat();
        System.out.println("Enter your grade: ");
        grade = sc.next().charAt(0);

        System.out.println("Name: "+name);
        System.out.println("age: "+age);
        System.out.println("cgpa: "+cgpa);
        System.out.println("grade: "+grade);


    }
}