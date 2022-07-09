package units.exam.physical;

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

    public boolean isEmpty(){
        return status.equals(Status.EMPTY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Disk disk = (Disk) o;
        return status == disk.status;
    }
    @Override
    public int hashCode() {
        return status.hashCode();
    }
}
