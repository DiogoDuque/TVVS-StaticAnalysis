package utils;

public class MenuItem {
    public interface OnItemSelect {
        public void onSelect();
    }

    private String text;
    private OnItemSelect handler;

    public MenuItem(String text, OnItemSelect handler) {
        this.text = text;
        this.handler = handler;
    }

    public void execute() {
        handler.onSelect();
    }

    @Override
    public String toString() {
        return text;
    }
}
