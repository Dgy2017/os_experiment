package experiment2;

/**
 * Created by Ding on 2017/11/5 0005.
 */
public class BaseList {
    private int startAdr;
    private int len;
    private BaseList pre = null;
    private BaseList next = null;

    public BaseList() {
    }

    public BaseList(int startAdr, int len, BaseList pre, BaseList next) {
        this.startAdr = startAdr;
        this.len = len;
        this.pre = pre;
        this.next = next;
    }

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

    public BaseList getPre() {
        return pre;
    }

    public void setPre(BaseList pre) {
        this.pre = pre;
    }

    public BaseList getNext() {
        return next;
    }

    public void setNext(BaseList next) {
        this.next = next;
    }

    static public PCB alloc(BaseList head, int size) {
        if (head == null) return null;
        if (head.getLen() >= size) {
            head.setLen(head.getLen() - size);
            PCB pcb = new PCB(head.getStartAdr(),size);
            //分配完删除
            if (head.getLen() == 0) {
                if (head.getPre() != null) {
                    head.getPre().setNext(head.getNext());
                }
                if (head.getNext() != null) {
                    head.getNext().setPre(head.getPre());
                }
            }
            //修改起始位置
            head.setStartAdr(head.getStartAdr() + size );
            return pcb;
        } else {
            return alloc(head.getNext(), size);
        }
    }

    static void printList(BaseList head) {
        System.out.println();
        head = head.getNext();
        while (head.getNext() != null) {
            System.out.print("|startAdr:" + head.getStartAdr() + ",length:" + head.getLen() + "|-------->");
            head = head.getNext();
        }
        System.out.print("|startAdr:" + head.getStartAdr() + ",length:" + head.getLen());
        System.out.println();
    }
}
