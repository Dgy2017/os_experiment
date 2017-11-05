package experiment2;

/**
 * Created by Ding on 2017/10/31 0031.
 */
public class PCB {
    private int startAdr;
    private int len;

    public int getStartAdr() {
        return startAdr;
    }

    public void setStartAdr(int startAdr) {
        this.startAdr = startAdr;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public PCB(int startAdr, int len) {

        this.startAdr = startAdr;
        this.len = len;
    }
}
