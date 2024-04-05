package markup;

import java.util.List;

public class Strikeout extends AbstractParagraphEl {
    public Strikeout(List<ParagraphEl> listEl) {
        super(listEl);
    }

    @Override
    public void toMarkdown(StringBuilder markupString) {
        markupString.append('~');
        super.toMarkdown(markupString);
        markupString.append('~');
    }

    @Override
    public void toTex(StringBuilder texString) {
        texString.append("\\textst{");
        super.toTex(texString);
        texString.append('}');
    }
}
