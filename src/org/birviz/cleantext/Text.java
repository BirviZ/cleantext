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

    public void replaceAllContent(String data) {
        this.text = data;
    }

    private String clean(String data) {

        String[][] splitter = {{"/", "\n"}, {"  ", " "}, {"\r", "\n"}, {" \n", "\n"}, {"\n\n", "\n"}, {"\n ", "\n"}};

        for(String s[]: splitter) {
            while (data.contains(s[0])) {
                data = data.replaceAll(s[0], s[1]);
            }
        }

        data = data.trim();

        return data;
    }

    @Override
    public String toString() {
        return clean(this.text);
    }
}
