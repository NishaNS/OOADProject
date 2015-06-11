package jpa;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import view.ThemeView;
import controller.MainDisplayController;

public class ScoreTableController implements ListSelectionListener, TableModelListener {

	private ScoreListGUI scoreTableView;
	private ScoreTableModel scoreTableModel;
	
	public ScoreTableController(MainDisplayController mController){
		this.scoreTableView = new ScoreListGUI(this);
		scoreTableModel = new ScoreTableModel();
		scoreTableModel.addTableModelListener(this);
	}
	
	/*public ScoreTableController(ScoreListGUI scoreTableView){
		//this.scoreTableView = scoreTableView;
		// create the tableModel using the data in the cachedRowSet
		
	}*/

	public TableModel getTableModel() {
		return scoreTableModel;
	}
	
	public ScoreListGUI getView(){
		return scoreTableView;
	}
	
	public ScoreTableController getController(){
		return this;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
		//return first selected index
		int firstIndex = selectModel.getMinSelectionIndex();      //%%%%%%%%%%%%%%%%%%%%% ???????

		//read data in each field
		scoreTableView.setGameID((String) scoreTableModel.getValueAt(firstIndex, 0) );
		scoreTableView.setFirstName((String) scoreTableModel.getValueAt(firstIndex, 1) );		
		scoreTableView.setLastName((String) scoreTableModel.getValueAt(firstIndex, 2) );
		scoreTableView.setGameTheme((String) scoreTableModel.getValueAt(firstIndex, 3));
		scoreTableView.setGameLevel((String) scoreTableModel.getValueAt(firstIndex, 4));
		scoreTableView.setGameScore((String) scoreTableModel.getValueAt(firstIndex, 5));
		scoreTableView.setGameTime((String) scoreTableModel.getValueAt(firstIndex, 6));
	}

	public void addRow(String[] data_array) {
		scoreTableModel.addRow(data_array);
	}

	public void deleteRow(String gameID) {
		scoreTableModel.deleteRow(gameID);
	}

	public void updateRow(String[] data_array) {
		scoreTableModel.updateRow(data_array);
	}



	@Override
	public void tableChanged(TableModelEvent e) {

		try{
			//get index of inserted row
			int firstIndex = e.getFirstRow();

			//create a new table model with new data
			scoreTableModel = new ScoreTableModel(scoreTableModel.getList(), scoreTableModel.getEntityManager());
			scoreTableModel.addTableModelListener(this);
			//update the JTable with  new data
			scoreTableView.updateTable();

			// read the data in each column using getValueAt and display it on corresponding textfield
			scoreTableView.setGameID((String) scoreTableModel.getValueAt(firstIndex, 0) );
			scoreTableView.setFirstName((String) scoreTableModel.getValueAt(firstIndex, 1));		
			scoreTableView.setLastName((String) scoreTableModel.getValueAt(firstIndex, 2));
			scoreTableView.setGameTheme((String) scoreTableModel.getValueAt(firstIndex, 3));
			scoreTableView.setGameLevel((String) scoreTableModel.getValueAt(firstIndex, 4));
			scoreTableView.setGameScore((String) scoreTableModel.getValueAt(firstIndex, 5));
			scoreTableView.setGameTime((String) scoreTableModel.getValueAt(firstIndex, 6));
			scoreTableView.setGameTime((String) scoreTableModel.getValueAt(firstIndex, 7));

		} catch(Exception exp) {
			exp.getMessage();
			exp.printStackTrace();
		}


	}





}
