package com.app.upload;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UploadService {
	
    private UploadAPIs api;
    
    public UploadService() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://localhost:8989/").addConverterFactory(GsonConverterFactory.create()).build();

        api = retrofit.create(UploadAPIs.class);
    }
    
    
    public void uploadFile(String fileName) {
        File file = new File(fileName);
        
        
        
        String ext = MimeTypeMap.getFileExtensionFromUrl(file.getAbsolutePath());
        
        String mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(ext);
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(MediaType.parse(mimeType), file));
        Call<ResponseBody> call = api.upload(filePart);
        call.enqueue(new Callback<ResponseBody>() {
			
			@Override
			public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
				// TODO Auto-generated method stub
				try {
					System.out.println(response.body().string());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(1);
			}
			
			@Override
			public void onFailure(Call<ResponseBody> call, Throwable t) {
				// TODO Auto-generated method stub
				
			}
		});
    }
    



}
