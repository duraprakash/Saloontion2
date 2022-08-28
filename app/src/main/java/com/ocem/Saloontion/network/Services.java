package com.ocem.Saloontion.network;


import com.ocem.Saloontion.model.BookingResponse;
import com.ocem.Saloontion.model.Datum;
import com.ocem.Saloontion.model.ForgetResponse;
import com.ocem.Saloontion.model.HistoryResponse;
import com.ocem.Saloontion.model.HomeServiceResponse;
import com.ocem.Saloontion.model.LoginResponse;
import com.ocem.Saloontion.model.RegisterResponse;
import com.ocem.Saloontion.model.ResetResponse;
import com.ocem.Saloontion.model.SaloonListResponse;
import com.ocem.Saloontion.model.ServicesResponse;
import com.ocem.Saloontion.model.VerifyResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;


    public interface Services {


        @POST("resetpassword")
        Call<ResetResponse> resetRequest(@Query("otp_code") String otp_code, @Query("email") String email, @Query("password") String password, @Query("confirm_password") String confirm_password);


        @POST("forgetpassword")
        Call<ForgetResponse> forgetRequest(@Query("email") String email);

        @GET("saloonservices")
        Call<List<ServicesResponse>> getSaloonService();

        @GET("getserviceslist")
        Call<List<HomeServiceResponse>> getSaloonListService();

        @GET("getsaloonlist")
        Call<List<SaloonListResponse>> getSaloonList();

        @GET("history")
        Call<HistoryResponse> getHistoryList(@Header("Authorization") String token);

        @POST("booking")
        Call<BookingResponse> bookingRequest(@Header( "Authorization" ) String token, @Query( "name" ) String name, @Query( "email" ) String email, @Query( "service_id" ) String service_id,@Query( "saloon_id" ) String saloon_id, @Query( "date")String date, @Query( "time" ) String time);

    @POST("login")
    Call<LoginResponse> logInRequest(@Query("email") String email, @Query("password") String password);
//    {
//        "user": {
//            "id": 35,
//            "name": "Aliza Adhikari",
//            "email": "adhikarialza@gmail.com",
//            "email_verified_at": null,
//            "created_at": "2022-05-30T03:14:58.000000Z",
//            "updated_at": "2022-05-30T03:14:58.000000Z",
//            "otp_code": 672491,
//            "is_verified": 0,
//            "image": null
//        },
//        "token": "171|skZ8wKyIIyetrdjIUNOzhspX3ks6NIIVdLRMnxQ0"
//    }

    @POST("register")
    Call<RegisterResponse> signUpRequest(@Query("sname") String sname, @Query("email") String email, @Query("password") String password);
//    {
//        "message": "user Created, Please Check your email to verify your email.",
//        "user": "test1@gmail.com" // password: test01
//    }

    @POST("verifyotp")
    Call<VerifyResponse> verifyRequest(@Query( "user" ) String email,@Query( "otp_code" ) String otp_code );

 
}
