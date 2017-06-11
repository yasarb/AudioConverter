package com.ysrbdlgn.audioconverter.frontend.ui.ribbon;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;

import java.util.List;

public class RibbonTab extends Tab {
//    public static final int CONTENT_HEIGHT = 70;
    public static final String DEFAULT_STYLE_CLASS = "ribbon-tab";

    HBox content;

    ObservableList<RibbonGroup> ribbonGroups;

    private String contextualColor;

    public RibbonTab()
    {
        init();
    }

    public RibbonTab(String title)
    {
        super(title);
        init();
    }

    private void init() {
        ribbonGroups = FXCollections.observableArrayList();
        content = new HBox();
//        content.setMinHeight(CONTENT_HEIGHT);
        this.setContent(content);

        setClosable(false);

        ribbonGroups.addListener(new ListChangeListener<RibbonGroup>() {
            @Override
            public void onChanged(Change<? extends RibbonGroup> changed) {
                groupsChanged(changed);
            }
        });
        content.getStyleClass().setAll(DEFAULT_STYLE_CLASS, "tab");
        getStyleClass().addListener(new ListChangeListener<String>() {
            @Override
            public void onChanged(Change<? extends String> c) {
                while(c.next())
                {
                    if (c.wasAdded())
                    {
                        for (String style : c.getAddedSubList())
                        {
                            content.getStyleClass().add(style);
                        }
                    }
                }
            }
        });

    }

    public void setContextualColor(String color)
    {
        contextualColor = color;
        getStyleClass().add(color);
    }

    public String getContextualColor()
    {
        return contextualColor;
    }

    private void groupsChanged(ListChangeListener.Change<? extends RibbonGroup> changed) {
        while(changed.next())
        {
            if (changed.wasAdded())
            {
                updateAddedGroups(changed.getAddedSubList());
            }
            if(changed.wasRemoved())
            {
                for (RibbonGroup group : changed.getRemoved())
                {
                    int groupIndex = content.getChildren().indexOf(group);
                    if (groupIndex != 0)
                        content.getChildren().remove(groupIndex - 1); // Remove separator
                    content.getChildren().remove(group);

                }

            }
        }
    }

    private void updateAddedGroups(List<? extends RibbonGroup> addedSubList) {
        for (RibbonGroup group : addedSubList)
        {
            content.getChildren().add(group);
        }
    }


    public ObservableList<RibbonGroup> getRibbonGroups()
    {
        return ribbonGroups;
    }
}
