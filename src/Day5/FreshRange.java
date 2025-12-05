package Day5;

public class FreshRange  implements Comparable<FreshRange>  {
    public long start;
    public long end;

    public FreshRange(String input) {
        String[] range = input.split("-");
        start = Long.parseLong(range[0]);
        end = Long.parseLong(range[1]);
    }

    public FreshRange(long s, long e){
        start = s;
        end = e;
    }

    public boolean isFresh(long value){
        return value >= start && value <= end;
    }

    public boolean overlaps(FreshRange range){
        return (range.start >= start && range.start <= end);
    }

    public void merge(FreshRange range){
        end = Math.max(end, range.end);
    }

    public long countVolume(){
        return end - start + 1;
    }

    @Override
    public int compareTo(FreshRange range) {
        return Long.compare(this.start, range.start);
    }

    @Override
    public String toString() {
        return start + "-" + end;
    }
}
