package org.birviz.cleantext;

/**
 * Text object
 */
public class Text {
    private String text;

    public Text() {
        this.text = "";
    }

    public Text(String data) {
        this.text = data;
    }

    public void append(String data) {
        this.text = this.text.concat(data);
    }

    private String clean(String data) {
        String text = data;

        return text;
    }

    @Override
    public String toString() {
        return clean(this.text);
    }
}
