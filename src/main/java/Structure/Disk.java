package Structure;

public class Disk {
    private Status status;

    public Disk(Status status){
        this.status=status;
    }

    public Status getStatus() {
        return status;
    }

    public void changeStatusTo(Status status){
        this.status=status;
    }
}
