package markup;

import java.util.ArrayList;

import java.util.List;

public class Text implements ParagraphEl {
    String data;
    public Text(String newString) {
        data = newString;
    }

    @Override
    public void toMarkdown(StringBuilder markupString) {
        markupString.append(data);
    }

    @Override
    public void toTex(StringBuilder texString) {
        texString.append(data);
    }
}
