package experiment2;

/**
 * Created by Ding on 2017/10/31 0031.
 */
public class Main {
    public static void main(String[] args) {
        FFListTest();
        System.out.println("2153605-丁光耀");
        BFListTest();
        System.out.println("2153605-丁光耀");
    }
    public static void FFListTest(){
        System.out.println("FFListTest:");
        BaseList head = new BaseList(-1,-1,null,null);
        BaseList firstNode =  new BaseList(0,640,head,null);
        head.setNext(firstNode);
        FFList.printList(head);
        PCB pcb_1 = FFList.alloc(head,130);
        FFList.printList(head);
        PCB pcb_2 = FFList.alloc(head,60);
        FFList.printList(head);
        PCB pcb_3 = FFList.alloc(head,100);
        FFList.printList(head);
        FFList.free(head,pcb_2);
        FFList.printList(head);
        PCB pcb_4 = FFList.alloc(head,200);
        FFList.printList(head);
        FFList.free(head,pcb_3);
        FFList.printList(head);
        FFList.free(head,pcb_1);
        FFList.printList(head);
        PCB pcb_5 = FFList.alloc(head,140);
        FFList.printList(head);
        PCB pcb_6 = FFList.alloc(head,60);
        FFList.printList(head);
        PCB pcb_7 = FFList.alloc(head,50);
        FFList.printList(head);
        FFList.free(head,pcb_6);
        FFList.printList(head);
    }
    public static void BFListTest(){

        System.out.println("BFListTest:");
        BaseList head = new BaseList(-1,-1,null,null);
        BaseList firstNode =  new BaseList(0,640,head,null);
        head.setNext(firstNode);
        BFList.printList(head);
        PCB pcb_1 = BFList.alloc(head,130);
        BFList.printList(head);
        PCB pcb_2 = BFList.alloc(head,60);
        BFList.printList(head);
        PCB pcb_3 = BFList.alloc(head,100);
        BFList.printList(head);
        BFList.free(head,pcb_2);
        BFList.printList(head);
        PCB pcb_4 = BFList.alloc(head,200);
        BFList.printList(head);
        BFList.free(head,pcb_3);
        BFList.printList(head);
        BFList.free(head,pcb_1);
        BFList.printList(head);
        PCB pcb_5 = BFList.alloc(head,140);
        BFList.printList(head);
        PCB pcb_6 = BFList.alloc(head,60);
        BFList.printList(head);
        PCB pcb_7 = BFList.alloc(head,50);
        BFList.printList(head);
        BFList.free(head,pcb_6);
        BFList.printList(head);
    }
}
