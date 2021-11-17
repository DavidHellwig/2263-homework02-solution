package edu.isu.cs.cs2263.hw02.views;

import edu.isu.cs.cs2263.hw02.App;
import javafx.scene.Node;
import lombok.AccessLevel;
import lombok.Getter;

@Getter
public abstract class AppView implements IAppView {

    protected Node view;
    @Getter(AccessLevel.NONE)
    protected App parent;

    public AppView(App parent) {
        this.parent = parent;
        initView();
    }

    /*public Node getView() {
        return view;
    }*/
}
