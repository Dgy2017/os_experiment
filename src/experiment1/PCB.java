package experiment1;

/**
 * Created by Ding on 2017/10/16 0016.
 */
public class PCB {
    private Integer id;
    private Integer priority;
    private Integer cpuTime;
    private Integer allTime;
    private Integer startBlock;
    private Integer blockTime;
    private State state;

    public PCB(Integer id, Integer priority, Integer cpuTime, Integer allTime, Integer startBlock, Integer blockTime,
               State state) {
        this.id = id;
        this.priority = priority;
        this.cpuTime = cpuTime;
        this.allTime = allTime;
        this.startBlock = startBlock;
        this.blockTime = blockTime;
        this.state = state;
    }
    public void addPriority(int x){
        this.priority += x;
    }
    public void minusPriority(int x){
        this.priority -= x;
    }

    public void addCpuTime(int x){
        this.cpuTime += x;
    }
    public void  minusAllTime(int x){
        this.allTime -= x;
    }
    public void minusStartBlock(int x){
        this.startBlock -= x;
    }
    public void minusBlockTime(int x){
        this.blockTime -= x;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getAllTime() {
        return allTime;
    }

    public void setAllTime(Integer allTime) {
        this.allTime = allTime;
    }

    public Integer getCpuTime() {
        return cpuTime;
    }

    public void setCpuTime(Integer cpuTime) {
        this.cpuTime = cpuTime;
    }

    public Integer getStartBlock() {
        return startBlock;
    }

    public void setStartBlock(Integer startBlock) {
        this.startBlock = startBlock;
    }

    public Integer getBlockTime() {
        return blockTime;
    }

    public void setBlockTime(Integer blockTime) {
        this.blockTime = blockTime;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return id + "\t" + priority + "\t\t\t" + cpuTime + "\t\t" + allTime + "\t\t" + startBlock + "\t\t\t" +
                blockTime + "\t\t\t" + state.toString();
    }
}
