package markup;

import java.util.ArrayList;
import java.util.List;

public class ListItem{
    List<ListItemEl> listItemEl;

    public ListItem(List<ListItemEl> listEl) {
        listItemEl = new ArrayList<>(listEl);
    }

    public void toTex(StringBuilder texString) {
        texString.append("\\item ");
        for (ListItemEl markupEl : listItemEl) {
            markupEl.toTex(texString);
        }
    }
}

