public class ErrorLogProcessor  extends LogProcessor{

    ErrorLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int level, String msg){
        if(level == ERROR){
            System.out.println("ERROR: " + msg);
        } else {
            super.log(level, msg);
        }
    }
}

