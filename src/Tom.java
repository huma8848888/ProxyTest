public class Tom implements human{

    public Tom(){}

    @Override
    public void eat() {
        System.out.println("humanImpl eating");
    }

    @Override
    public void run() {
        System.out.println("humanImpl running");
    }
}
