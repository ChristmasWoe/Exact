package calctest;

import java.util.Scanner;

public class CalcTest {
    public static Eval X;//объект класса Eval для работы с его полями
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Input your task :");
        String s = read.nextLine();//чтение строки из консоли
        X = new Eval();//инициализация объект через конструктор
        X.getOper( s );
        X.split(s, "\\" + String.valueOf( X.o ));
        X.Check( X.a );
        X.Check( X.b );
        if(X.typ( X.a ) != X.typ( X.b )){//проверка на совпадение типов элементов
            System.out.println("Incorrect request: check if both numbers are of the same type ");
            System.exit(0);
        }
        int ax=X.parsing(X.a, X.typ(X.a));
        int bx=X.parsing(X.b, X.typ(X.b));//вспомогательные переменные
        System.out.println("You've entered: "+s+"\n"+"The result is: "+X.Evaluate(ax, bx));
    }
}
