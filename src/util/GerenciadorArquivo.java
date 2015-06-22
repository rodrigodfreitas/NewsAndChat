package util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class GerenciadorArquivo {

	// public boolean writerImage(byte[] bytes, String name){
	// try {
	//
	// FileOutputStream outputStream = new FileOutputStream(name);
	// BufferedOutputStream stream = new BufferedOutputStream(outputStream);
	// stream.flush();
	// stream.write(bytes, 0, bytes.length);
	// stream.flush();
	// stream.close();
	// outputStream.close();
	//
	// return true;
	//
	// } catch (FileNotFoundException e) {
	// e.printStackTrace();
	// return false;
	// } catch (IOException e) {
	// e.printStackTrace();
	// return false;
	// }
	// }

	public static Bitmap readImage(byte[] bytes) {
		return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
	}

	// public boolean delete(String name){
	// File file = new File(name);
	// if( file.exists() ){
	// file.delete();
	// return true;
	// }
	// return false;
	// }

	public static Map<String, String> getFilePropertiesConnection(Context context) {

		try {

			AssetManager assetManager = context.getResources().getAssets();
					
			Map<String, String> mapa = new HashMap<String, String>();
			
			Properties properties = new Properties();
			properties.load( assetManager.open("configConnection.properties") );
			mapa.put("", properties.getProperty("host"));
			mapa.put("", properties.getProperty("port"));
			
			return mapa;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	//update the file properties with the configurations of connection
	public void updateFilePropertiesConnction(String host, String port, Context context) {
		try {
			
			AssetManager assetManager = context.getResources().getAssets();
			Properties properties = new Properties();
			properties.load(assetManager.open("configConnection.properties"));
			properties.put("host", host);
			properties.put("port", port);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
