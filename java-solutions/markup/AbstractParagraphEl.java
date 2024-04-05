package markup;

import java.util.ArrayList;
import java.util.List;

public class AbstractParagraphEl implements ParagraphEl {
    List<ParagraphEl> elements; // Note модифкатор доступа

    AbstractParagraphEl(List<ParagraphEl> listEl) {
        elements = new ArrayList<>(listEl);
    }

    @Override
    public void toMarkdown(StringBuilder markupString) {
        for (ParagraphEl markupEl : elements) {
            markupEl.toMarkdown(markupString);
        }
    }

    @Override
    public void toTex(StringBuilder texString) {
        for (ParagraphEl markupEl : elements) {
            markupEl.toTex(texString);
        }
    }
}
