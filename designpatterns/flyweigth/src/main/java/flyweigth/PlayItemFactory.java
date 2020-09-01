package flyweigth;

import java.util.HashMap;
import java.util.Map;

public class PlayItemFactory {

    private static final Map<String, PlayItem> PLAY_ITEM_MAP = new HashMap<>();
    public static boolean ENABLE_FLYWEIGHT = true;
    private static Long idSequence = 0L;

    public static PlayItem createPlayItem(String songName) {

        if (ENABLE_FLYWEIGHT && PLAY_ITEM_MAP.containsKey(songName)) {
            return PLAY_ITEM_MAP.get(songName);
        }
        PlayItem playItem = new PlayItem(++idSequence, songName);
        PLAY_ITEM_MAP.put(songName, playItem);
        return playItem;
    }
}
