package Day5;

public class FreshRange {
    public long start;
    public long end;

    public FreshRange(String input){
        String[] range = input.split("-");
        start = Long.parseLong(range[0]);
        end = Long.parseLong(range[1]);
    }

    public boolean isFresh(long value){
        return value >= start && value <= end;
    }

    @Override
    public String toString() {
        return start + "-" + end;
    }
}
