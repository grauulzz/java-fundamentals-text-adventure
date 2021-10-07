package main.com.adventure.world.objects;

import main.com.adventure.world.objects.keys.Key;

public class HoleContent {
    private Key content;
    private boolean isCovered;

    /**
     * @param key - gather content from key.
     */
    public HoleContent(Key key) {
        this.content = key;
        this.isCovered = true;
    }

    /**
     * setCovered - toggles the hole content.
     */
    public void setCovered() {
        isCovered = !isCovered;
    }

    /**
     * @return - gets value of isCovered.
     */
    public boolean isCovered() {
        return isCovered;
    }

    /**
     * @return - hole content if applicable.
     */
    public Key getKey() {
        return this.content;
    }

}
