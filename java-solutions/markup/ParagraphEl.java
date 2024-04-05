package markup;

public interface ParagraphEl {
    void toMarkdown(StringBuilder markupString);
    void toTex(StringBuilder markupString);
}