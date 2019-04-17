package com.app.upload;

import java.util.regex.Pattern;

/**
 * 
 * @author Patar Timotius
 * 
 * Using simple mimeTypeMap for anya upload in retrofit
 * 
 *
 */

public class MimeTypeMap {
	
	 private static final MimeTypeMap sMimeTypeMap= new MimeTypeMap();

	    private MimeTypeMap(){}

	    
	    public static String getFileExtensionFromUrl(String url){
	        if(url != null && url.length() > 0){
	            int fragment= url.lastIndexOf('#');
	            if(fragment > 0){
	                url= url.substring(0, fragment);
	            }

	            int query= url.lastIndexOf('?');
	            if(query > 0){
	                url= url.substring(0, query);
	            }

	            int filenamePos= url.lastIndexOf('/');
	            String filename= 0 <= filenamePos ? url.substring(filenamePos + 1) : url;

	            // if the filename contains special characters, we don't
	            // consider it valid for our matching purposes:
	            if(!filename.isEmpty() &&
	                    Pattern.matches("[a-zA-Z_0-9\\.\\-\\(\\)\\%]+", filename)){
	                int dotPos= filename.lastIndexOf('.');
	                if(0 <= dotPos){
	                    return filename.substring(dotPos + 1);
	                }
	            }
	        }

	        return "";
	    }

	    public boolean hasMimeType(String mimeType){
	        return MimeUtils.hasMimeType(mimeType);
	    }

	    public String getMimeTypeFromExtension(String extension){
	        return MimeUtils.guessMimeTypeFromExtension(extension);
	    }

	    public boolean hasExtension(String extension){
	        return MimeUtils.hasExtension(extension);
	    }
	    public String getExtensionFromMimeType(String mimeType){
	        return MimeUtils.guessExtensionFromMimeType(mimeType);
	    }

	    public static MimeTypeMap getSingleton(){
	        return sMimeTypeMap;
	}

}
