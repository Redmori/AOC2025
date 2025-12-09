package Day9;

public class Line {

    public int position;
    public int start;
    public int end;
    public boolean horizontal;

    public Line(int pos, int s, int e, boolean dir){
        position = pos;
        start = s;
        end = e;
        horizontal = dir;
    }

    public boolean intersectsRect(int x1, int y1, int x2, int y2){
        if(horizontal){
            return intersectsLine(x1, y1, y2) || intersectsLine(x2, y1, y2);
        }else{
            return intersectsLine(y1, x1, x2) || intersectsLine(y2, x1, x2);
        }
    }

    public boolean intersectsLine(int pos2, int start2, int end2){
        return pos2 > start && pos2 < end && position > start2 && position < end2;
    }

    @Override
    public String toString(){
        return horizontal + " " + position + " " + start + " " + end;
    }
}
