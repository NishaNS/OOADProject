package model;

import java.awt.Image;
import java.util.HashMap;

import java.util.Random;

import javax.swing.ImageIcon;

import commonutil.MazeAlphabets;
import commonutil.MazeAnimals;


public class Maze {

	private final int[][] arrMaze1 = {
			 	{0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
	            {2, 0, 0, 0, 3, 0, 0, 0, 0, 0},
	            {2, 0, 1, 1, 3, 1, 1, 0 ,0, 0},
	            {2, 0, 1, 1, 3, 1, 1, 0 ,0, 0},
	            {2, 0, 0, 0, 3, 0, 0, 0 ,0, 0},
	            {2, 0, 0, 0, 0, 0, 0, 0 ,0, 0}
    };
	
	private final int[][] arrMaze2 = {
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0 ,0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0 ,0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0 ,0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0 ,0, 0}
};

	private HashMap<Integer,String> map  = new HashMap<Integer,String>();
	private Image path;
	private Image block;
	private int theme;
	private int level;
	private int noOfElements;
	private static String FILE_PATH = "image/";
	private static String IMG_T1_PATH = "grass.png";
	private static String IMG_T1_BLOCK = "tree.png";
	private static String IMG_T2_PATH = "";
	private static String IMG_T2_BLOCK = "";
	private static int COUNT_LEVEL1_MAZEELEMENTS = 5;
	private static int COUNT_LEVEL2_MAZEELEMENTS = 10;
	private MazeAnimals enumAnimal;
	private MazeAlphabets enumAlphabets;
	private MazeElements[] mazeObjects;

	public Maze(int theme, int level){
		this.theme = theme;
		this.level = level;
		if(this.level == 1) 
			noOfElements = COUNT_LEVEL1_MAZEELEMENTS;
		else 
			noOfElements = COUNT_LEVEL2_MAZEELEMENTS;
		loadMazeLayout();
		initializeMazeElement(theme);
		Display();

	}
	
	public int getLevel(){
		return this.level;
	}
	
	public int getTheme(){
		return this.theme;
	}
	
	public Image getPath(){
		return path;
	}

	public Image getBlock(){
		return block;
	}

	public int[][] getMazeLayout() {
		/*y corresponds to row of map; 
		within that gets a particular col; 
		then decide what tile to put down*/

		return arrMaze1;		
	}

	private void loadMazeLayout(){
		int[] mazeElementPosition;
		if(level==1)
			mazeElementPosition = getMazeElementPosition(arrMaze1);
		else
			mazeElementPosition = getMazeElementPosition(arrMaze2);
		if(theme == 1){
				createKeyValuePair(mazeElementPosition,enumAnimal);
				createMazeObjects();
			}
		else if(theme == 2){
				createKeyValuePair(mazeElementPosition,enumAlphabets);
				createMazeObjects();
			}
		}
		
	private void createKeyValuePair(int[] elementPosition,MazeAnimals enumAnimal){
		int temp = 0;
		int mazeElement = 0;
		Random rand = new Random();
		while(temp<noOfElements){
			mazeElement = rand.nextInt(enumAnimal.values().length);
			if(!map.containsValue(enumAnimal.values()[mazeElement].name())){
                map.put(elementPosition[temp],enumAnimal.values()[mazeElement].name());
                temp++;
            }
        }
	}
	
	private void createKeyValuePair(int[] elementPosition,MazeAlphabets enumAlphabet){
		int temp = 0;
		while(temp<noOfElements){
			map.put(elementPosition[temp],enumAlphabet.values()[temp].name());
            temp++;
          }
		}
	
	private int[] getMazeElementPosition(int[][] arrMaze){
		int[] arrayElementPosition = new int[noOfElements];
		int k = 0;
		 for(int i = 0 ; i< arrMaze.length; i++){
             for(int j = 0 ; j<arrMaze[0].length;j++){
                 if(arrMaze[i][j] == 2) {
                     arrayElementPosition[k++] = (i * arrMaze[0].length) + j;
                 }
             }
         }
		 return arrayElementPosition;
	}
	
	private void initializeMazeElement(int theme){
		if(theme == 1){ 
			ImageIcon img = new ImageIcon(FILE_PATH+IMG_T1_BLOCK);
			block = img.getImage();

			img = new ImageIcon(FILE_PATH+IMG_T1_PATH);
			path = img.getImage();
		}

		if(theme == 2){
			ImageIcon img = new ImageIcon(FILE_PATH+IMG_T2_BLOCK);
			block = img.getImage();

			img = new ImageIcon(FILE_PATH+IMG_T2_PATH);
			path = img.getImage();
		}
	}

	private void createMazeObjects(){
//		if(this.theme == 1)
//			this.mazeObjects = new Animal[noOfElements];
//		else if(theme == 2)
//			this.mazeObjects = new Alphabet[noOfElements];
//		int i = 0;
//		for (HashMap.Entry<Integer, String> entry : map.entrySet()) {
//			 mazeObjects[i] = new Animal();
//			 Integer key = entry.getKey();
//			 String  value = entry.getValue().toString();
//			 if((key % arrMaze1[0].length)>0)
//	            {
//				 this.mazeObjects[i].setPositionX(key/arrMaze1[0].length);
//				 this.mazeObjects[i].setPositionY(key%arrMaze1[0].length);
//	            }else
//	            {
//	            	this.mazeObjects[i].setPositionX(key/arrMaze1[0].length);
//	            	 this.mazeObjects[i].setPositionY(0);
//	            }
//			 this.mazeObjects[i].setName(value);
//			 this.mazeObjects[i].setImage(value);
//			 this.mazeObjects[i].setisFound(false);
//			 i++;
//		}
		this.mazeObjects = new MazeElements[noOfElements];
		int i = 0;
		for (HashMap.Entry<Integer, String> entry : map.entrySet()) {
			 mazeObjects[i] = new MazeElements();
			 Integer key = entry.getKey();
			 String  value = entry.getValue().toString();
			 if((key % arrMaze1[0].length)>0)
	            {
				 this.mazeObjects[i].setPositionX(key/arrMaze1[0].length);
				 this.mazeObjects[i].setPositionY(key%arrMaze1[0].length);
	            }else
	            {
	            	this.mazeObjects[i].setPositionX(key/arrMaze1[0].length);
	            	 this.mazeObjects[i].setPositionY(0);
	            }
			 this.mazeObjects[i].setName(value);
			 this.mazeObjects[i].setImage(value);
			 this.mazeObjects[i].setisFound(false);
			 i++;
		}
	
	}

	public MazeElements getMazeElement(int x , int y){
		MazeElements objTemp=null;
		for (MazeElements obj : mazeObjects) {
			if(obj.getPositionX() == x && obj.getPositionY() == y)
				objTemp = obj;
		}
		return objTemp;
	}
	
	public void Display(){
		for (MazeElements obj : mazeObjects) {
			System.out.println("Name:" + obj.getName() + " " + "X:" + obj.getPositionX() + " " + "Y:" + obj.getPositionY());
		}
	}

}
