import java.util.Scanner;

public class StartNumber implements StartInterface{
    
    public double enterNumber(){
        Scanner scan = new Scanner(System.in);
        double q = scan.nextInt();
        return q;
    }

    @Override
    public double getResult() {
        return enterNumber();
    }

}