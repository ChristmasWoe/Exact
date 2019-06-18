package calctest;

public class Eval {
    //Здесь происходят все операции по отношению к исходной строке
    public char[] operators={'+' , '-' , '*' , '/'}; //массив допустимых арифметических операций
    public char[] allowed={'0' ,'1' ,'2' ,'3' ,'4' ,'5' ,'6' ,'7' ,'8' ,'9' 
            ,'I' ,'V' ,'X' ,'L' ,'D' ,'C' ,'M' ,' ' };//массив допустимых символов в строке
    public char o;//переменая для арифметической операции
    public String a,b;//соответственно первый и второй элемент в примере
    public char getOper( String x ){//функция для получения арифм.операции
        boolean found = false ;
        for(int i = 0 ; i < x.length(); i++ ){
            for( int j = 0 ; j < 4 ; j++ ){
                if( x.charAt(i) == operators[ j ] ){
                    o = x.charAt( i );//передача арифм.операции в переменную
                    found = true ;
                    break ;
                }
            }
        }
        if( found == false ){
            System.out.println("Incorrect request: only acceptable operators are + - * /");//соответсвующая арифм.операция не найдена
            return 0;
        }
    return o;    
    }
    public void split( String x , String delim ){//функция для разделения исходной строки на две новых
        String[] subStr;//вспомогательный массив
        subStr = x.split( delim );//разделителем выступает арифм.оператор
        a = subStr[0].toString();
        b = subStr[ 1 ].toString();
    }
    
    public void Check( String x ){//функция для проверки на наличие недопустимых символов
        for( int i = 0 ; i < x.length() ; i++ ){
            boolean found = false;
            for( int j = 0 ; j < allowed.length ; j++ ){
                if( x.charAt( i ) == allowed[ j ] ){
                    found = true;
                    break;
                }
            }
            if( found != true){
                System.out.println("Incorrect request: use only 0-9 or roman numerals(I,V,X,L,C,D,M)  ");
                System.exit(0);
            }
        }
    }
    public String typ( String x ){//функция для определения типа цифр(арабские или римские)
        String typ = "roman";
        for(int i = 0 ; i < x.length(); i++ ){
            for(int j = 0 ; j < 10 ; j++ ){
                if( x.charAt(i) == allowed[ j ] ){
                    typ = "arabic";
                }
            }
        }
       return typ;
    }
    public int parsing( String x , String typ ){//функция для перевода числа в зависимости от его типа
        int result = 0;
        while(x.startsWith(" ")==true){//удаление пробелов в начале строки
            x=x.substring(1);
        }
        while(x.endsWith(" ")==true){//удаление пробелов в конце строки
            x=x.substring(0 , x.length()-1);
        }
        switch ( typ ){
            case ("roman"):
                result = ToArabic(x);
                break;
            case("arabic"):
                //x.replaceAll("\\s","");
                for(int i = x.length() - 1 ; i >= 0; i-- ){
                    result += ( Character.getNumericValue( x.charAt( i ) ) )*( Math.pow(10 , x.length()-i-1));
                }
                break;
        }   
    return result;
    }
    public static int ToArabic( String number ) {//вспомогательная функция, которая с помощью рекурсии
        //переводит римское число в десятичное
        if( number.isEmpty() == true) return 0;
        if (number.startsWith( "M" ) ) return 1000 + ToArabic(number.substring(1));
        if (number.startsWith( "CM" )) return 900 + ToArabic(number.substring(2));   //2
        if (number.startsWith( "D" )) return 500 + ToArabic(number.substring(1));//1
        if (number.startsWith( "CD" )) return 400 + ToArabic(number.substring(2));//2
        if (number.startsWith( "C" )) return 100 + ToArabic(number.substring(1));//1
        if (number.startsWith( "XC" )) return 90 + ToArabic(number.substring(2));//2
        if (number.startsWith( "L" )) return 50 + ToArabic(number.substring(1));//1
        if (number.startsWith( "XL" )) return 40 + ToArabic(number.substring(2));//2
        if (number.startsWith( "X" )) return 10 + ToArabic(number.substring(1));//1
        if (number.startsWith( "IX" )) return 9 + ToArabic(number.substring(2));//2
        if (number.startsWith( "V" )) return 5 + ToArabic(number.substring(1));//1
        if (number.startsWith( "IV" )) return 4 + ToArabic(number.substring(2));//2
        if (number.startsWith( "I" )) return 1 + ToArabic(number.substring(1));//1
    return 0;
    }
    public int Evaluate(int x,int y){//функция для конечного подсчета строки
        switch(o){
            case('+'):
                return x + y;                
            case('-'):
                return x - y;
            case('/'):
                return x / y;
            case('*'):
                return x * y;
        }
    return 0;
    } 
}