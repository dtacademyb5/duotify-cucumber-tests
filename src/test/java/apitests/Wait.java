package apitests;

public enum Wait {

    SHORT(10),
    MEDIUM(20),
    LONG(30);


    private int seconds;

    private Wait(int seconds){
        this.seconds = seconds;
    }
}
