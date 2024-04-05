package markup;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements ListItemEl{
    List<ParagraphEl> paragraphEl;

    public Paragraph(List<ParagraphEl> listEl) {
        paragraphEl = new ArrayList<>(listEl);
    }

    public void toMarkdown(StringBuilder markupString) {
        for (ParagraphEl markupEl : paragraphEl) {
            markupEl.toMarkdown(markupString);
        }
    }

    @Override
    public void toTex(StringBuilder texString) {
        for (ParagraphEl markupEl : paragraphEl) {
            markupEl.toTex(texString);
        }
    }
}
