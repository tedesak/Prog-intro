package markup;

import java.util.List;

public class Emphasis extends AbstractParagraphEl {
    public Emphasis(List<ParagraphEl> listEl) {
        super(listEl);
    }
    @Override
    public void toMarkdown(StringBuilder markupString) {
        markupString.append('*');
        super.toMarkdown(markupString);
        markupString.append('*');
    }

    @Override
    public void toTex(StringBuilder texString) {
        texString.append("\\emph{");
        super.toTex(texString);
        texString.append('}');
    }
}
