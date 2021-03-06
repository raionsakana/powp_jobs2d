package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.adapter.CurrentDriverAdapter;
import edu.kis.powp.jobs2d.factories.RhombusComplexCommandFactory;
import edu.kis.powp.jobs2d.factories.TriangleComplexCommandFactory;
import edu.kis.powp.jobs2d.figures.FigureCommand;
import edu.kis.powp.jobs2d.magicpresets.FiguresJane;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private FigureType figureType;

	public SelectTestFigureOptionListener(DriverManager driverManager, FigureType figureType) {
		this.driverManager = driverManager;
		this.figureType = figureType;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.figureType.equals(FigureType.FIGURE_JOE_1)) {
			FiguresJoe.figureScript1(driverManager.getCurrentDriver());
		} else if (this.figureType.equals(FigureType.FIGURE_JOE_2)) {
			FiguresJoe.figureScript2(driverManager.getCurrentDriver());
		} else if (this.figureType.equals(FigureType.JANE)) {
			FiguresJane.figureScript(new CurrentDriverAdapter(driverManager.getCurrentDriver()));
		} else if (this.figureType.equals(FigureType.FIGURE_COMMAND)) {
			FigureCommand.figureScript(new CurrentDriverAdapter(driverManager.getCurrentDriver()));
		} else if (this.figureType.equals(FigureType.FIGURE_COMPLEX)) {
			FigureCommand.figureScriptCommand(new CurrentDriverAdapter(driverManager.getCurrentDriver()));
		} else if (this.figureType.equals(FigureType.FIGURE_COMPLEX_FACTORY_1)) {
			RhombusComplexCommandFactory rhombusComplexCommandFactory = new RhombusComplexCommandFactory();
			rhombusComplexCommandFactory.getComplexCommand(new CurrentDriverAdapter(driverManager.getCurrentDriver())).execute();
		} else if (this.figureType.equals(FigureType.FIGURE_COMPLEX_FACTORY_2)) {
			TriangleComplexCommandFactory triangleComplexCommandFactory = new TriangleComplexCommandFactory();
			triangleComplexCommandFactory.getComplexCommand(new CurrentDriverAdapter(driverManager.getCurrentDriver())).execute();
		}
	}
}
