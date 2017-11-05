package experiment1;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;

import java.util.*;

/**
 * Created by Ding on 2017/10/16 0016.
 */
public class Main {
    public static void main(String[] args) {
        PCB[] pcbs = new PCB[]{
                new PCB(0, 9, 0, 3, 2, 3, State.READY),
                new PCB(1, 38, 0, 3, -1, 0, State.READY),
                new PCB(2, 30, 0, 6, -1, 0, State.READY),
                new PCB(3, 29, 0, 3, -1, 0, State.READY),
                new PCB(4, 0, 0, 4, -1, 0, State.READY)
        };
        solve(pcbs);
        System.out.println("\n2153605-丁光耀");
    }

    public static void solve(PCB[] pcbs) {
        PriorityQueue<PCB> readyQueue = new PriorityQueue<>(pcbs.length, new Comparator<PCB>() {
            @Override
            public int compare(PCB o1, PCB o2) {
                return (int) o2.getPriority() - o1.getPriority();
            }
        });
        List<PCB> block = new ArrayList<>();
        List<PCB> finished = new ArrayList<>();

        PCB running = null;
        for (PCB pcb : pcbs) {
            switch (pcb.getState()) {
                case READY:
                    readyQueue.add(pcb);
                    break;
                case BLOCK:
                    block.add(pcb);
                    break;
                case FINISHED:
                    finished.add(pcb);
                    break;
                default:
                    running = pcb;
                    return;
            }
        }
        //模拟时间流动

        int time = 0;
        while (!readyQueue.isEmpty() || !block.isEmpty()) {

            if (running == null) {
                running = readyQueue.poll();
                if (running != null)
                    running.setState(State.START);
            }
            //输出
            System.out.println(time++);
            System.out.println("Running Process: " + ((running == null) ? "" : running.getId()));
            System.out.print("Ready Queue: ");
            for (PCB pcb : readyQueue) {
                System.out.print("->" + pcb.getId());
            }
            System.out.print("\nBlock Queue: ");
            for (PCB pcb : block) {
                System.out.print("->" + pcb.getId());
            }
            System.out.println("\n================================================================");
            System.out.println("ID\tPRIORITY\tCPUTIME\tALLTIME\tSTARTBLOCK\tBLOCKTIME\tSTATE");
            System.out.println((running == null) ? "" : running.toString());
            for (PCB pcb : readyQueue) {
                System.out.println(pcb.toString());
            }
            for (PCB pcb : block) {
                System.out.println(pcb.toString());
            }
            for (PCB pcb : finished) {
                System.out.println(pcb.toString());
            }
            System.out.println();
            //模拟
            for (int i = 0; i < block.size(); i++) {
                PCB pcb = block.get(i);
                if (pcb.getBlockTime() == 0) {
                    block.remove(pcb);
                    i--;
                    pcb.setState(State.READY);
                    readyQueue.add(pcb);
                } else {
                    pcb.minusBlockTime(1);
                }
            }
            for (PCB pcb : readyQueue) {
                pcb.addPriority(1);
            }

            if (running != null) {
                running.minusPriority(3);
                running.addCpuTime(1);
                running.minusAllTime(1);
                if (running.getAllTime() == 0) {
                    running.setState(State.FINISHED);
                    finished.add(running);
                } else if (running.getStartBlock() > 1 || running.getStartBlock() < 0) {
                    if (running.getStartBlock() > 1) {
                        running.minusStartBlock(1);
                    }
                    running.setState(State.READY);
                    readyQueue.add(running);
                } else if (running.getStartBlock() == 1) {
                    running.minusStartBlock(2);
                    running.setState(State.BLOCK);
                    block.add(running);
                }
                running = null;
            }
        }
        System.out.println(time + "\nEnded\n================================================================");
        System.out.println("ID\tPRIORITY\tCPUTIME\tALLTIME\tSTARTBLOCK\tBLOCKTIME\tSTATE");
        for (PCB pcb : finished) {
            System.out.println(pcb.toString());
        }
    }
}