package experiment2;

/**
 * Created by Ding on 2017/10/31 0031.
 */
public class FFList extends BaseList {


    static public void free(BaseList head, PCB pcb) {
        BaseList preNode = null;
        BaseList nextNode = head;
        while (nextNode != null && nextNode.getStartAdr() < pcb.getStartAdr()) {
            preNode = nextNode;
            nextNode = nextNode.getNext();
        }
        //与前一节点相邻
        if (preNode != null && preNode.getStartAdr() + preNode.getLen() == pcb.getLen()) {
            //与后一节点相邻
            if (nextNode != null && pcb.getStartAdr() + pcb.getLen() == nextNode.getStartAdr()) {
                //与后一节点相邻
                preNode.setLen(preNode.getLen() + pcb.getLen() + nextNode.getLen());
                preNode.setNext(nextNode.getNext());
                if (nextNode.getNext() != null) {
                    nextNode.getNext().setPre(preNode);
                }
            } else {
                //与后一节点不相邻
                preNode.setLen(preNode.getLen() + pcb.getLen());
            }

        } else {
            //与前一节点不相邻
            if (nextNode != null && pcb.getStartAdr() + pcb.getLen() == nextNode.getStartAdr()) {
                //与后一节点相邻
                nextNode.setStartAdr(pcb.getStartAdr());
                nextNode.setLen(nextNode.getLen() + pcb.getLen());
            } else {
                //与后一节点不相邻
                BaseList node = new BaseList(pcb.getLen(), pcb.getStartAdr(), preNode, nextNode);
                if (preNode != null) {
                    preNode.setNext(node);
                } else {
                    head = node;
                }
                if (nextNode != null) {
                    nextNode.setPre(node);
                }
            }
        }
    }
}