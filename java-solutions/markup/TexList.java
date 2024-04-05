package markup;

import java.util.ArrayList;
import java.util.List;

public class TexList implements ListItemEl{ // NOTE abstract
    List<ListItem> listEl;

    TexList(List<ListItem> listEl) {
        this.listEl = new ArrayList<>(listEl);
    }

    @Override
    public void toTex(StringBuilder texString) {
        for (ListItem markupEl : listEl) {
            markupEl.toTex(texString);
        }
    }
}
