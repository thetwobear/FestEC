package com.x.x_core.net;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by 熊猿猿 on 2017/8/9/009.
 */

public interface RestService {

    @GET
    Call<String> get(@Url String url, @QueryMap Map<String, Object> params);

    @FormUrlEncoded
    @POST
    Call<String> post(@Url String url, @FieldMap Map<String, Object> params);

    @POST
    Call<String> postRaw(@Url String url, @Body RequestBody body);

    @FormUrlEncoded
    @PUT
    Call<String> put(@Url String url, @FieldMap Map<String, Object> params);

    @PUT
    Call<String> putRaw(@Url String url, @Body RequestBody body);

    @DELETE
    Call<String> delete(@Url String url, @QueryMap Map<String, Object> params);

    @Streaming//边下载边写入，防止内存溢出
    @GET
    Call<ResponseBody> download(@Url String url, @QueryMap Map<String, Object> params);

    @Multipart
    @POST
    Call<String> upload(@Url String url, @Part MultipartBody.Part file);


    //RxJava api

    @GET
    Observable<Response<String>> rxGet(@Url String url, @QueryMap Map<String, Object> params);

    @FormUrlEncoded
    @POST
    Observable<Response<String>> rxPost(@Url String url, @FieldMap Map<String, Object> params);

    @POST
    Observable<Response<String>> rxPostRaw(@Url String url, @Body RequestBody body);

    @FormUrlEncoded
    @PUT
    Observable<Response<String>> rxPut(@Url String url, @FieldMap Map<String, Object> params);

    @PUT
    Observable<Response<String>> rxPutRaw(@Url String url, @Body RequestBody body);

    @DELETE
    Observable<Response<String>> rxDelete(@Url String url, @QueryMap Map<String, Object> params);

    @Streaming//边下载边写入，防止内存溢出
    @GET
    Observable<Response<ResponseBody>> rxDownload(@Url String url, @QueryMap Map<String, Object> params);

    @Multipart
    @POST
    Observable<Response<String>> rxUpload(@Url String url, @Part MultipartBody.Part file);
}
