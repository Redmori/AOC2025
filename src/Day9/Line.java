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
        //System.out.println(position + " " + start + " " + end + " " + horizontal+ " <-> " + pos2 + " " + start2 + " " + end2);
        boolean fullIntersect = pos2 > start && pos2 < end && position > start2 && position < end2;
        boolean Tsection1 = start == pos2 && start2 < position && end2 > position;
        boolean Tsection2 = end == pos2 && start2 < position && end2 > position;
        boolean Tsection3 = start2 == position && start < pos2 && end > pos2;
        boolean Tsection4 = end2 == position && start < pos2 && end > pos2;
        //System.out.println(fullIntersect || Tsection1 || Tsection2 || Tsection3 || Tsection4);
        return fullIntersect || Tsection1 || Tsection2 || Tsection3 || Tsection4;
    }

    @Override
    public String toString(){
        return horizontal + " " + position + " " + start + " " + end;
    }
}
