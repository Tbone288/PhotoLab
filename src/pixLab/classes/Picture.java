package pixLab.classes;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorVerticalRightToLeft()
  {
	  //same setup for LtR
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  int width = pixels[0].length;
	  
	  for (int row = pixels.length -1; row >= 0; row--)
	  {
		  for (int col = width / 2 -1; col >= 0; col--)
		  {
			  leftPixel = pixels[row][col];
			  rightPixel = pixels[row][width - col - 1];
			  leftPixel.setColor(rightPixel.getColor());
		  }
	  }
  }
  
  public void mirrorHorizontal()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel bottomPixel = null;
	  Pixel topPixel = null;
	  int height = pixels[0].length;
	  
	  for (int col = pixels[0].length - 1; col >= 0; col--)
	  {
		  for (int row = 0; row < height / 2 - 1; row++)
		  {
			  topPixel = pixels[row][col];
			  bottomPixel = pixels[height - row - 1][col];
			  topPixel.setColor(bottomPixel.getColor());
		  }
	  }
  }
  
  public void mirrorDiagonal()
  {
	  Pixel[][] pictureMatrix = this.getPixels2D();
	  Pixel topRight = null;
	  Pixel bottomLeft = null;
	  
	  for (int row = 0; row < pictureMatrix.length; row++)
	  {
		  for (int col = 0; col < pictureMatrix[0].length; col++)
		  {
			  if (row != col && row < pictureMatrix.length && col < pictureMatrix.length)
			  {
				  topRight = pictureMatrix[row][col];
				  bottomLeft = pictureMatrix[col][row];
				  
				  topRight.setColor(bottomLeft.getColor());
			  }
			 
		  }
	  }
  }
  
  public void mirrorDiagonalUphill()
  {
	  Pixel topLeft = null;
	  Pixel bottomRight = null;
	  Pixel[][] pictureMatrix = this.getPixels2D();
	  int shortest = Math.min(pictureMatrix.length, pictureMatrix[0].length);
	  
	  for (int row = 0; row < shortest; row++)
	  {
		  for (int col = 0; col < shortest; col++)
		  {
			if (row + col != shortest-1)
			  {
				  topLeft = pictureMatrix[row][col];
				  bottomRight = pictureMatrix[shortest-col-1][shortest-row];
				  topLeft.setColor(bottomRight.getColor());
			  }
		  }
	  }
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  public void mirrorGull()
  {
	  int mirrorPoint = 400;
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  int count = 0;
	  Pixel[][] pixels = this.getPixels2D();
	  
	  for (int row = 220; row < 340; row ++)
	  {
		  for (int col = 225; col < 350; col++)
		  {
			  leftPixel = pixels[row][col];      
		        rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
		        rightPixel.setColor(leftPixel.getColor());
		  }
	  }
  }
  
  public void mirrorArms()
  {
	 
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  Pixel[][] pixels = this.getPixels2D();
	  
	  for (int row = 165; row < 214; row ++)
	  {
		  for (int col = 95; col < 300; col++)
		  {
			  leftPixel = pixels[row][col];      
		        rightPixel = pixels[row+50][col];
		        rightPixel.setColor(leftPixel.getColor());
		  }
	  }
  }
  
  public void fullRandom()
  {
	  Pixel [][] currentPicture = this.getPixels2D();
	  for(Pixel [] row : currentPicture)
	  {
		  for(Pixel currentPixel : row)
		  {
			  int red = (int) (Math.random() * 256);
			  int green = (int) (Math.random() * 256);
			  int blue = (int) (Math.random() * 256);
			  
			  currentPixel.setColor(new Color(red, green, blue));
		  }
	  }
  }
  
  public void fullRandomGreen()
  {
	  Pixel [][] currentPicture = this.getPixels2D();
	  for(Pixel [] row : currentPicture)
	  {
		  for(Pixel currentPixel : row)
		  {
			  int green = (int) (Math.random() * 256);
			  
			  currentPixel.setColor(new Color(currentPixel.getRed(), green, currentPixel.getBlue()));
		  }
	  }
  }
  
  public void fullRandomRed()
  {
	  Pixel [][] currentPicture = this.getPixels2D();
	  for(Pixel [] row : currentPicture)
	  {
		  for(Pixel currentPixel : row)
		  {
			  int red = (int) (Math.random() * 256);
			  
			  currentPixel.setColor(new Color(currentPixel.getGreen(), red, currentPixel.getBlue()));
		  }
	  }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    
   for(int fromRow = 0, toRow = startRow;fromRow < fromPixels.length && toRow < toPixels.length; fromRow++, toRow++)
   {
	   for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length && toCol < toPixels[0].length; fromCol++, toCol++)
	   {
		   fromPixel = fromPixels[fromRow][fromCol];
		   toPixel = toPixels[toRow][toCol];
		   toPixel.setColor(fromPixel.getColor());
	   }
   }
    
     
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
 /*   this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
  */  this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  public void valentinesMeme()
  {
	  Picture valentinesMeme = new Picture("ValentinesMeme.png");
	  addMessage("Try...", 63, 98);
	  addMessage("Catch", 63, 440);
	  write("/Users/todo3858/ValentinesMeme.jpg");
	 

	  
  }
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  public void edgeDetectionJr(int edgeDist)
  {
	  Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    Pixel anotherPixel = null;
	    Pixel[][] pixels = this.getPixels2D();
	    Color rightColor = null;
	    Color anotherColor = null;
	    for (int row = 0; row < pixels.length; row++)
	    {
	      for (int col = 0; col < pixels[0].length-2; col++)
	      {
	        leftPixel = pixels[row][col];
	        rightPixel = pixels[row][col+1];
	        anotherPixel = pixels[row][col+2];
	        rightColor = rightPixel.getColor();
	        anotherColor = anotherPixel.getColor();
	        if (leftPixel.colorDistance(rightColor) > edgeDist || leftPixel.colorDistance(anotherColor) > edgeDist)
	        {
	          leftPixel.setColor(Color.BLACK);
	        }
	        else
	        {
	          leftPixel.setColor(Color.WHITE);
	        }

      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture snowman = new Picture("snowman.jpg");
    
    snowman.explore();
   
  }
  
} // this } is the end of class Picture, put all new methods before this
