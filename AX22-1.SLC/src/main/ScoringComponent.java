package main;

import java.util.Vector;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import lib.ValidInRange;
import utils.CustPrompt;
import utils.FileOperator;	

public class ScoringComponent {
    private String title;
    private Vector<Integer> score;
    private Vector<String> section;
    private Vector<String> notes;
    private Vector<Component> components;
    private CustPrompt in;
    private XSSFWorkbook workbook;

    public ScoringComponent(String title) {
        this.title = title;
        this.score = new Vector<Integer>();
        this.section = new Vector<String>();
        this.notes = new Vector<String>();
        this.components = new Vector<Component>();
        this.in = new CustPrompt();
        
        this.workbook = new XSSFWorkbook();
    }
    
    public void correction(FileOperator op) {
    	XSSFSheet spreadsheet = workbook.createSheet("Marking " + title);
    	int rowid = 0;
    	int cellid = 0;
    	Cell cell;
    	XSSFRow row;
    	
    	row = spreadsheet.createRow(rowid++);
    	cell = row.createCell(cellid++);
    	cell.setCellValue(title);
    	
    	for (Component comp : components) {
			op.searchFunction(comp.getTitle());
			comp.setScore(in.getInt("Input score for " + title + " [0..2]: ", new ValidInRange(0, 2)));
			if(comp.getScore() == 1) {
				comp.setNote(in.getString("Input note for " + title + ": ", str -> true));
			}
			
			row = spreadsheet.createRow(rowid++);
	    	cell = row.createCell(cellid++);
	    	cell.setCellValue(comp.getTitle());
	    	row = spreadsheet.createRow(rowid++);
	    	cell = row.createCell(cellid++);
	    	cell.setCellValue(comp.getScore());
	    	row = spreadsheet.createRow(rowid++);
	    	cell = row.createCell(cellid++);
	    	cell.setCellValue(comp.getNote());
		}
    }
    
    public void addComponent(Component comp) {
    	this.components.add(comp);
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Vector<Integer> getScore() {
		return score;
	}

	public void addScore(int score) {
		this.score.add(score);
	}
	
	public void addSection(String str) {
		this.section.add(str);
	}

	public Vector<String> getNotes() {
		return notes;
	}

	public void addNote(String str) {
		this.notes.add(str);
	}
}
