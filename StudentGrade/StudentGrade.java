import java.util.Scanner;

public class StudentGrade{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of students: ");
        int n = input.nextInt();
        int[] marks = new int[n];

        int totalMarks=0;
        for (int i = 0; i<n;i++){
            System.out.println("Enter the marks of student " + (i+1) + ":");
            marks[i]=input.nextInt();
            totalMarks+=marks[i];
        }
        double avgPercentage=(double)totalMarks/n;

        char grade;
        if(avgPercentage>=90){
            grade='A';

        }
        else if(avgPercentage>=80){
            grade='B';

        }
        else if(avgPercentage>=70){
            grade='C';
        }
        else if(avgPercentage>=60){
            grade='D';
        }else{
            grade='F';
        }
        System.out.println("\nTotal marks:"+totalMarks);
        System.out.println("Average percentage: "+avgPercentage+"%");
        System.out.println("Grade: "+grade);
        input.close();
    }
}
