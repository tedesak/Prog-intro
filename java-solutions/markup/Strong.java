package markup;

import java.util.List;

public class Strong extends AbstractParagraphEl {
    public Strong(List<ParagraphEl> listEl) {
        super(listEl);
    }

    @Override
    public void toMarkdown(StringBuilder markupString) {
        markupString.append("__");
        super.toMarkdown(markupString);
        markupString.append("__");
    }

    @Override
    public void toTex(StringBuilder texString) { // NOTE коипаста
        texString.append("\\textbf{");
        super.toTex(texString);
        texString.append('}');
    }
}
