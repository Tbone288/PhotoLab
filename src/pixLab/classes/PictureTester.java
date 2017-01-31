package pixLab.classes;
/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Tyler Odom
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  public static void testMirrorVerticalRightToLeft()
  {
	  Picture bike = new Picture("blueMotorcycle.jpg");
	  bike.explore();
	  bike.mirrorVerticalRightToLeft();
	  bike.explore();
	  
  }
  
  public static void testMirrorHorizontal()
  {
	  Picture arch = new Picture("arch.jpg");
	  arch.explore();
	  arch.mirrorHorizontal();
	  arch.explore();
  }
  
  public static void testMirrorDiagonal()
  {
	  Picture gorge = new Picture("gorge.jpg");
	  gorge.explore();
	  //gorge.mirrorDiagonal();
	  gorge.mirrorDiagonalUphill();
	  gorge.explore();

  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
    
    
  }
  
  public static void testMirrorGull()
  {
	  Picture seagull = new Picture("seagull.jpg");
	    seagull.mirrorGull();
	    seagull.explore();
  }
  
  public static void testMirrorArms()
  {
	  Picture snowman = new Picture("snowman.jpg");
	  snowman.mirrorArms();
	  snowman.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(20);
    swan.explore();
  }
  
  public static void testEdgeDetectionJr()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetectionJr(20);
    swan.explore();
  }
  
  public static void testFilters()
  {
	  Picture temple = new Picture("temple.jpg");
	  temple.fullRandomGreen();	  
	  temple.fullRandomRed();
	  temple.mirrorDiagonal();
	  temple.mirrorVertical();
	  temple.mirrorDiagonalUphill();
	  temple.explore();
  }
  
  public static void testCopy()
  {
	  Picture water = new Picture("water.jpg");
	  water.copy(water, 100, 100, 300, 300);
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    // testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorVerticalRightToLeft();
    //testMirrorHorizontal();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    testCopy();
    //testEdgeDetection();
	//testEdgeDetectionJr();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
	//testFilters();
  }
}