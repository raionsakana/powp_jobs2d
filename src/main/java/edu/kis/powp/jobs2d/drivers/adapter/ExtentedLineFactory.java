package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.shape.LineFactory;

public class ExtentedLineFactory extends LineFactory {

    static public SelectionableLineAdapter getSelectionableLineAdapter(){
        return new SelectionableLineAdapter();
    }

}
