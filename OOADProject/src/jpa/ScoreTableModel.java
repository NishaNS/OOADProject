package jpa;


import java.sql.Time;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.table.AbstractTableModel;

public class ScoreTableModel extends AbstractTableModel {

	List<StudentScoreDetails> scoreResultList;
	private static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit";  // Used in persistence.xml
	private static EntityManagerFactory factory;  // JPA  
	private EntityManager manager;		      // JPA 
	private EntityTransaction userTransaction;
	private StudentScoreDetails studentScoreDetails;	
	private ScoreListService scoreListService;	//field contains info about results
	private int numcols, numrows;

	public ScoreTableModel() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		manager = factory.createEntityManager();
		studentScoreDetails = new StudentScoreDetails();
		scoreListService = new ScoreListService(manager);
		//read all results from scorelist
		scoreResultList = scoreListService.readAll();
		//update rows and cols in the model
		numrows = scoreResultList.size();
		numcols = studentScoreDetails.getNumberOfColumns();		 
	}

	public ScoreTableModel(List<StudentScoreDetails> list, EntityManager em)  {
		scoreResultList = list;
		numrows = scoreResultList.size();
		studentScoreDetails = new StudentScoreDetails();
		numcols = studentScoreDetails.getNumberOfColumns();     
		manager = em;  
		scoreListService = new ScoreListService(manager);
	}

	@Override
	public int getColumnCount() {

		return numcols;
	}

	@Override
	public int getRowCount() {

		return numrows;
	}

	@Override
	public Object getValueAt(int row, int col) {
		try{
			return scoreResultList.get(row).getColumnData(col);
		}catch(Exception e) {
			e.getMessage();
			return null;
		}

	}

	// table cells are not editable
	public boolean isCellEditable(int rowIndex, int colIndex) {
		return false;
	}

	public Class<?> getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	}

	// returns the name of the column
	public String getColumnName(int col) {
		try {
			return studentScoreDetails.getColumnName(col);
		} catch (Exception err) {
			return err.toString();
		}             
	}


	// update the data in the given row and column to aValue
	public void setValueAt(Object aValue, int row, int col) {
		//data[rowIndex][columnIndex] = (String) aValue;
		try {
			StudentScoreDetails element = scoreResultList.get(row);
			element.setColumnData(col, aValue); 
			fireTableCellUpdated(row, col);
			
		} catch(Exception err) {
			err.toString();
		}	
	}

	public List<StudentScoreDetails> getList() {
		return scoreResultList;
	}

	public EntityManager getEntityManager() {
		return manager;
	}

	public void addRow(String[] data_array) {
		//update database only - table model not updated
		EntityTransaction userTransaction = manager.getTransaction();
		userTransaction.begin();
		StudentScoreDetails newRecord = scoreListService.createCourse((String)data_array[0], (String)data_array[1], (String)data_array[2], 
																		(String)data_array[3], (String)data_array[4], Integer.parseInt(data_array[5]), 
																		data_array[6], (String)data_array[7]);
		userTransaction.commit();
		System.out.println("add transaction commited");
		
		 // set the current row to rowIndex
		scoreResultList.add(newRecord);
		int row = scoreResultList.size();
		int col = 0;
		// update the data in the model to the entries in array
		for (String data : data_array) {
			 setValueAt((String) data, row-1, col++);
		 }
		 numrows++;
	}
	
	public void addEndResult(String[] data_array) {
		//update database only - table model not updated
		EntityTransaction userTransaction = manager.getTransaction();
		userTransaction.begin();
		StudentScoreDetails newRecord = scoreListService.createCourse((String)data_array[0], (String)data_array[1], (String)data_array[2], 
																		(String)data_array[3], (String)data_array[4], Integer.parseInt(data_array[5]), 
																		data_array[6], (String)data_array[7]);
		userTransaction.commit();
		System.out.println("end of game result commited");
		
		 
	}

	public void addTableModelListener(ScoreTableController scoreTableController) {
		// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%        NOT THERE!!!

	}

	public void deleteRow(String gameID) {
		//update database
		EntityTransaction userTransaction = manager.getTransaction();
		userTransaction.begin();
		scoreListService.deleteScore(gameID);
		userTransaction.commit();
		System.out.println("delete transaction commited");

		// add code to update JTable%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% 

	}

	public void updateRow(String[] data_array) {
		//update database
		EntityTransaction userTransaction = manager.getTransaction();
		userTransaction.begin();
		StudentScoreDetails updateRecord = scoreListService.updateScore(Integer.parseInt(data_array[0]), (String)data_array[1], 
				(String)data_array[2], (String)data_array[3], 
				(String)data_array[4], Integer.parseInt(data_array[5]),
				(String)data_array[6]);

		userTransaction.commit();
		System.out.println("update transaction commited");


		// add code to update JTable%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	}




}
