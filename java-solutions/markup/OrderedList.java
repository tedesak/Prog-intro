package markup;

import java.util.ArrayList;
import java.util.List;

public class OrderedList extends TexList{
    public OrderedList(List<ListItem> listEl) {
        super(listEl);
    }

    @Override
    public void toTex(StringBuilder texString) {
        texString.append("\\begin{enumerate}");
        super.toTex(texString);
        texString.append("\\end{enumerate}");
    }
}
