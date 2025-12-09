package Day9;

import java.util.ArrayList;
import java.util.BitSet;

public class Map {

    public BitSet map;
    int sizeX;
    int sizeY;

    public Map(int sX, int sY) {
        sizeX = sX;
        sizeY = sY;
        map = new BitSet((sizeX * sizeY));
    }

    boolean get(int x, int y) {
        return map.get(x * sizeY + y);
    }

    void set(long x, long y, boolean value) {
        map.set((int) (x * sizeY + y), value);
    }

    public void createContour(ArrayList<Tile> tiles) {
        for(Tile tile : tiles){
            set(tile.x, tile.y, true);
        }

        boolean isOn = false;
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if(get(i,j)){
                    isOn = !isOn;
                }else{
                    if(isOn){
                        set(i,j,true);
                    }
                }
            }
        }

    }
}
