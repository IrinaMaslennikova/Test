import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input:");
        String expression = sc.nextLine();
        System.out.println("Output:");
        System.out.println(calc(expression));
    }
    public static String calc(String input) throws Exception, NumberFormatException {
        String[] Expression = input.split(" "); //выражение а+b
        if (Expression.length != 3)
            throw new Exception( "Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        String result; //результат
        int a = 0,b = 0;
        int Rome = 0;
        if (Expression[0] != Rome(Expression[0]))
        {Rome++;}
        if (Expression[2] != Rome(Expression[2]))
        {Rome++;}
        Expression[0] = Rome(Expression[0]);
        Expression[2] = Rome(Expression[2]);
        try {a = Integer.parseInt(Expression[0].trim());}
        catch (NumberFormatException e){
            System.out.println(Expression[0] + " не является подходящим целым числом");
            throw new NumberFormatException();
        }
        try {b = Integer.parseInt(Expression[2].trim());}
        catch (NumberFormatException e){
            System.out.println(Expression[2] + " не является подхоящим целым числом");
            throw new NumberFormatException();
        }
        if (Rome == 1)
            throw new Exception("Используются одновременно разные системы счисления");
        if( a>10 | a<=0 )
            throw new Exception(Expression[0] + " не из промежутка [1;10]");
        if( b>10 | b<=0)
            throw new Exception(Expression[2] + " не из промежутка [1;10]");
        int c = 0;

        switch (Expression[1])
        {
            case "+":
                c = a+b;
                break;
            case "-":
                c = a-b;
                break;
            case "*":
                c = a*b;
                break;
            case "/":
                c = a/b;
                break;
            default:
                throw new Exception(Expression[1] +" не является соответстующей операцией");
        }
        result = String.valueOf(c);
        if (Rome == 2 & c < 1)
        {
            throw new Exception("В римской системе счисления присутствуют только положительные числа");
        }
        if (Rome == 2)
        {
            result = ResultRome(result);
        }
        return (result);
    }
    public static String Rome(String s)
    {
        int x = 0;
        String[] RomeNumber = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        for (int i=0; i < RomeNumber.length; i++)
        {
            if (s.equals(RomeNumber[i]))
            {
                x = i+1;
                break;
            }
        }
        if (x == 0)
        {
            return (s);
        }
        else {
            return (String.valueOf(x));
        }
    }
    public static String ResultRome(String s){
        String[] RomeUnits = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String[] RomeDozens = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC","C"};
        int cRome = Integer.parseInt(s.trim());
        return (RomeDozens[cRome/10]+RomeUnits[cRome%10]);
    }
}