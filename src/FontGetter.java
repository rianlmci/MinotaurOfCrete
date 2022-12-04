import java.awt.*;
import java.io.InputStream;

/**
 * Helper class for getting fonts from the resources' folder of this game.
 * Import font code from resources from
 * <a href="http://www.java2s.com/Code/Java/2D-Graphics-GUI/Loadfontfromttffile.htm">
 * "Load font from TTF File" @ java2s.com
 * </a>
 * Import font code from resources from <a href=
 * "http://www.java2s.com/Code/Java/2D-Graphics-GUI/Loadfontfromttffile.htm">
 * "Load font from TTF File" @ java2s.com </a>
 *
 * @author Rianna McIntyre (additional tweaking)
 */
public class FontGetter {
	/**
	 * Gets a font by its file name and extension.
	 *
	 * @param fontFileName full file name, ex: "Cinzel-Black.ttf"
	 * @return font
	 */
	public Font getFontByName(String fontFileName) {
		Font font;
		String completeFilePath = "/resources/fonts/" + fontFileName;

		try {
			InputStream inputStream = FontGetter.class.getResourceAsStream(completeFilePath);
			font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(fontFileName + "was not found. Using default serif font instead...");
			font = new Font("serif", Font.PLAIN, 24);
		}
		return font;
	}

}
