package Day9;

public class Tile {
    public int x;
    public int y;

    public Tile(String position){
        String[] split = position.split(",");
        x = Integer.parseInt(split[0]);
        y = Integer.parseInt(split[1]);
    }

    public long squareSize(Tile otherTile){
        return (long) (Math.abs(x - otherTile.x) + 1) * (Math.abs(y - otherTile.y) + 1);
    }

    public boolean isInRect(Tile t1, Tile t2){
        return x > Math.min(t1.x, t2.x) && x < Math.max(t1.x,t2.x) && y > Math.min(t1.y, t2.y) && y < Math.max(t1.y,t2.y);
    }

    @Override
    public String toString(){
        return "(" + x + "," + y + ")";
    }
}
