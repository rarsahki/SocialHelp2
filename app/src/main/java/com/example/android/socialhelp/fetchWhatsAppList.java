package com.example.android.socialhelp;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by User on 20-07-2018.
 */

public interface fetchWhatsAppList {
    @GET("/b/5b50e1b8a5a2f34ea6b835bb/9")
    Call<Appmodel> getWhList();
}
