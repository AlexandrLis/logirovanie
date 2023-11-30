public abstract class Decorator implements StartInterface{
    
    StartInterface startInterface;

    public Decorator(StartInterface startInterface) {
        this.startInterface = startInterface;
    }

    @Override
    public double getResult() {
        return startInterface.getResult();
    }
}