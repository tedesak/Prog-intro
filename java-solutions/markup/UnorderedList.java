package markup;

import java.util.ArrayList;
import java.util.List;

public class UnorderedList extends TexList{
    public UnorderedList(List<ListItem> listEl) {
        super(listEl);
    }

    @Override
    public void toTex(StringBuilder texString) {
        texString.append("\\begin{itemize}");
        super.toTex(texString);
        texString.append("\\end{itemize}");
    }
}
