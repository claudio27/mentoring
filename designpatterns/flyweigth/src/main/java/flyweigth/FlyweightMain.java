package flyweigth;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlyweightMain {

    private static final String[] songNames = new String[1000];
    private static final String[] playListNames = new String[174];
    private static final List<PlayList> playLists = new ArrayList<>();

    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        System.out.println("MaxMemory > " + (runtime.maxMemory() / 1_000_000));

        PlayItemFactory.ENABLE_FLYWEIGHT = false;
        initArrays();
        createRandomPlayList();

        System.out.println("total playlist > " + playLists.size());

        long memoryUsed = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory Used > " + (memoryUsed / 1_000_000));
    }

    private static void createRandomPlayList() {
        Random random = new Random();
        int p = 0;
        for (int c = 0; c < playListNames.length; c++) {
            PlayList playList = new PlayList(playListNames[c]);
            for (int i = 0; i < 10; i++) {
                int song = random.nextInt(songNames.length);
                playList.addPlayItem(songNames[song]);
            }
            playLists.add(playList);
            //System.out.println("Completado "+c+" unidades " + (c%playListNames.length));
            if (c != 0 && (c + 1) % (playListNames.length / 10) == 0) {
                p += 10;
                System.out.println("Completado " + p + "%");
                System.out.println("Listas creadas " + playLists.size());
            }
        }

    }

    private static void initArrays() {
        for (int c = 0; c < songNames.length; c++) {
            songNames[c] = "Song " + (c + 1);
        }
        for (int c = 0; c < playListNames.length; c++) {
            playListNames[c] = "PlayList " + (c + 1);
        }
    }
}
