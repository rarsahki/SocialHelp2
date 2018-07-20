package com.example.android.socialhelp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by User on 19-07-2018.
 */
public interface fetchData {
    @GET("/b/{name}/6")
    Call<Help> getTitle(@Path("name") String name);
}
