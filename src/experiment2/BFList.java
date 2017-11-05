package experiment2;

/**
 * Created by Ding on 2017/10/31 0031.
 */
public class BFList extends BaseList {

    static public void insert(BaseList head,BaseList node){
        BaseList preNode = null;
        BaseList nextNode = head;
        while (nextNode!=null&&nextNode.getLen()<node.getLen()){
            preNode = nextNode;
            nextNode = nextNode.getNext();
        }
        node.setPre(preNode);
        node.setNext(nextNode);
        if (preNode != null){
            preNode.setNext(node);
        }
        if (nextNode != null){
            nextNode.setPre(node);
        }
    }
    static public void delete(BaseList head,BaseList node){
        if(node.getPre() != null){
            node.getPre().setNext(node.getNext());
        }
        if(node.getNext() != null){
            node.getNext().setPre(node.getPre());
        }
        node = null;
    }
    static public void free(BaseList head,PCB pcb){
        BaseList preNode = head;
        BaseList nextNode = head;
        //寻找前面的相邻区
        while (preNode != null&&preNode.getStartAdr()+preNode.getLen()!=pcb.getStartAdr()){
            preNode = preNode.getNext();
        }
        //寻找后面的相邻区
        while (nextNode != null&&nextNode.getStartAdr()!= pcb.getStartAdr()+pcb.getLen()){
            nextNode = nextNode.getNext();
        }
        if(preNode != null){
            if (nextNode != null){
                BaseList newNode = new BaseList(preNode.getStartAdr(),preNode.getLen()+pcb.getLen()+nextNode.getLen(),
                        null,null);
                delete(head,preNode);
                delete(head,nextNode);
                insert(head,newNode);
            } else {
                BaseList newNode = new BaseList(preNode.getStartAdr(),preNode.getLen()+pcb.getLen(), null,null);
                delete(head,preNode);
                insert(head,newNode);
            }
        }else {
            if (nextNode != null){
                BaseList newNode = new BaseList(pcb.getStartAdr(),pcb.getLen()+nextNode.getLen(), null,null);
                delete(head,nextNode);
                insert(head,newNode);
            } else {
                BaseList newNode = new BaseList(pcb.getStartAdr(),pcb.getLen(), null,null);
                insert(head,newNode);
            }
        }
    }
}
