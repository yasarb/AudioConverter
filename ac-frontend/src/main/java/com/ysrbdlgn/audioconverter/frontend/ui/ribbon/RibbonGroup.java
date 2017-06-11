package com.ysrbdlgn.audioconverter.frontend.ui.ribbon;

import com.ysrbdlgn.audioconverter.frontend.ui.ribbon.skin.RibbonGroupSkin;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Labeled;
import javafx.scene.control.Skin;

public class RibbonGroup extends Labeled {
    public final static String DEFAULT_STYLE_CLASS = "ribbon-group";

    private ObservableList<Node> nodes;
    private SimpleStringProperty title;
    private SimpleBooleanProperty seperator;

    public RibbonGroup() {
        nodes = FXCollections.observableArrayList();
        title = new SimpleStringProperty("");
        seperator = new SimpleBooleanProperty(true);

        getStyleClass().setAll(DEFAULT_STYLE_CLASS);
    }

    public ObservableList<Node> getNodes() {
        return nodes;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public boolean isSeperator() {
        return seperator.get();
    }

    public SimpleBooleanProperty seperatorProperty() {
        return seperator;
    }

    public void setSeperator(boolean seperator) {
        this.seperator.set(seperator);
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new RibbonGroupSkin(this, seperator.get());
    }
}
