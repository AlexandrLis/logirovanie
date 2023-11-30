import java.io.FileWriter;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class test {
    public static void main(String[] args) {
        // пытался вывести в logo() вводимые числа и действия с ними, что бы
        // записать их в журнал логирования, но не получилось

        // и программа из-за декоратора запрашивает сначала второе число, а затем
        // первое. Поэтому нужно вводить числа задом-наперед(хорошо видно на примере
        // с делением). Исправить не удалось
        function();
    }

    public static void logo(String str){
        Logger logger = Logger.getAnonymousLogger();
        String pathFile = "file.txt";
        String pathLog = "log.txt";
        SimpleFormatter formatter = new SimpleFormatter();
        FileHandler handler = null;
        try {
            handler = new FileHandler(pathLog, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.addHandler(handler);
        handler.setFormatter(formatter);
        try (FileWriter file = new FileWriter(pathFile, true)){
            file.write("\n");
            file.write(str);
            file.flush();
            logger.info("Запись выполнена");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("запись не удалась");
            logger.warning("запись не удалась");
        }
        handler.close();
    }

    public static void function(){

        System.out.println("Выберите действие: ");
        System.out.println("1 - сложение ");
        System.out.println("2 - умножение");
        System.out.println("3 - деление");
        System.out.println("4 - выход");
        Scanner scan = new Scanner(System.in);
        int choise = scan.nextInt();
        switch (choise) {
            case 1:
                System.out.println("введите первое слагаемое: ");
                StartInterface summa = new SummaDecorator(new StartNumber());
                String resultSumma = "Результат:\n" + summa.getResult();
                System.out.println(resultSumma);
                logo(resultSumma);
                function();
            break;
                
            case 2:
                System.out.println("введите первый множитель: ");
                StartInterface multiplicator = new MultiDecorator(new StartNumber());
                String resultMultiplicator = "Результат:\n" + multiplicator.getResult();
                System.out.println(resultMultiplicator);
                logo(resultMultiplicator);
                function();
            break;

            case 3:
                System.out.println("введите делитель: ");
                StartInterface division = new DivisionDecorator(new StartNumber());
                String resultDivision = "Результат:\n" + division.getResult();
                System.out.println(resultDivision);
                logo(resultDivision);
                function();
            break;

            case 4:
                System.out.println("Завершено");
            break;

            default:
                System.out.println("Вы ввели некорректное значение.");
                System.out.println("Введите число от 1 до 4, соответствующее действию");
                function();
            break;
        }
    }
}