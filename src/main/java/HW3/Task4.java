package HW3;

import java.util.Scanner;

// Ханойская башня.
public class Task4 {
    static void hanoi(int n,char start,char mid,char end) {
        // Метод решает задачу ханойская башня
        if(n==1) { // Условие выхода из рекурсии, если у нас один блинчик, который мы перкладываем с первой башни на последнюю.
            System.out.println(n+" from "+start+" to "+end);
            return;
        }
        hanoi(n-1,start,end,mid); // Запускается рекурсия с перстановкой башень
        System.out.println(n+" from "+start+" to "+end);
        hanoi(n-1,mid,start,end); // Запускается рекурсия с новой перстановкой башень

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        hanoi(n,'A','B','C');
    }
}
