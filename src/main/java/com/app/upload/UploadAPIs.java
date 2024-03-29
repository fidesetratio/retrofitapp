package com.app.upload;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UploadAPIs {
	
		@Multipart
	    @POST("/upload/upload/upload")
	    Call<ResponseBody> upload(@Part MultipartBody.Part file);

}
