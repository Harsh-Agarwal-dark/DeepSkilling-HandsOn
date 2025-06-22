package Exercise1;

class Logger{
    private static Logger instance;
    private Logger(){
        System.out.println("A new Logger is created");
    }
    public static Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }
    public void log(String message){
        System.out.println(message);
        System.out.println(java.time.LocalTime.now());
    }
}

class SingletonPatternExample{
    public static void main(String[] args) {
        //Logger l1 = new Logger();         cannot intialize logger like this since the constructor is declared as private
        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();
        l1.log("This is First Instance printing message");
        l2.log("This is Second Instance printing message");
        System.out.println((l1==l2)?"Test Passed":"Test Failed");
    }
}