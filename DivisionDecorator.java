import java.util.Scanner;

public class DivisionDecorator extends Decorator{
    
    public DivisionDecorator(StartInterface startInterface) {
        super(startInterface);
    }

    @Override
    public double getResult() {
        Scanner scan = new Scanner(System.in);
        double division = scan.nextInt();
        System.out.println("введите делимое: ");
        if (division != 0){
            return startInterface.getResult() / division;
        }
        else{
            System.out.println("На ноль делить нельзя");
            return 0;
        }
    }
}
