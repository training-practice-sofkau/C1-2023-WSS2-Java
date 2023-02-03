package co.com.chartsofka.music.controller;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String id) {
        super("Could not find the item " + id);
    }
}
