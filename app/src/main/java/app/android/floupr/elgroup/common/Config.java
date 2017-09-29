package app.android.floupr.elgroup.common;


import android.content.Context;
import android.graphics.Typeface;

public class Config {


    public class Boolean {

    }

    public class URLS {
        public static final String baseUrl ="http://104.154.75.199/";
        public static final String getCart ="http://104.154.75.199/get_cart";
        public static final String addToCart ="http://104.154.75.199/order";
        public static final String signIn = "http://104.154.75.199/users/sign_in";
        public static final String signOut = "http://104.154.75.199/users/sign_out";
        public static final String signUp = "http://104.154.75.199/users";
        public static final String authentication = "http://104.154.75.199/users/";
        public static final String updateProfile = "http://104.154.75.199/users/profile";
        public static final String deals = "http://104.154.75.199/deals";
        public static final String supplierDeals = "http://104.154.75.199/supplier_deals";

        public static final String history = "http://104.154.75.199/history/";
        public static final String favourites = "http://104.154.75.199/favorites";
        public static final String profile = "http://104.154.75.199/profile/";

        // supplier side
        public static final String orderList = "http://104.154.75.199/supplier/orders";
        public static final String orderSearchByKeyword = "http://104.154.75.199/orders/search?query=";
        public static final String orderSearchByCategory = "http://104.154.75.199/orders/search";
        public static final String setShippingCost = "http://104.154.75.199/set_shipping_cost";
        public static final String getOrderDetails = "http://104.154.75.199/orders/";
        public static final String createBid = "http://104.154.75.199/bids";   // POST
        public static final String updateBid = "http://104.154.75.199/bids";  // PUT
        public static final String getBids = "http://104.154.75.199/bids"; // GET
        public static final String getBidHistory = "http://104.154.75.199/history/bids?status="; // POST
        public static final String getSingleBid = "http://104.154.75.199/bids/";  // GET
        public static final String getCountryList = "http://104.154.75.199/supplier/countries";
        public static final String getPreference = "http://104.154.75.199/preferences/";  // post Method





        public static final String confirmation = "";


    }

    public class Keys {
        public static final String ERRMSG = "ERRMSG";
        public static final String LOGFILE = "LOGFILE";
        public static final String message = "message";
    }
    public class KeyName{
        public static final String FB_USERID = "user_fbid";
        public static final String FB_TOKEN = "fb_token";
        public static final String ISFB_LOGIN ="fb_login";
        public static final String ISFIRSTLOGIN="first_login";
        public static final String USER_AUTHTOKEN = "auth_token";
        public static final String USER_NAME = "user_name";
        public static final String USER_COUNTRY = "country";
        public static final String USER_COUNTRYId = "countryId";
        public static final String AUCTIONDATE = "auction_date";
        public static final String VAT = "vat_id";
        public static final String USER_ABOUT = "about";
        public static final String USER_ADD = "address";
        public static final String USER_LOGGEDIN = "logged_id";
        public static final String USER_ROLE ="user_role";
        public static final String USER_ID = "user_id";
        public static final String USER_MOBILE = "user_phone";
        public static final String USER_PROFILE ="profile_image";
        public static final String USER_EMAIL = "user_email";
        public static final String USER_DEVICE_TOKEN = "user_device_token";
        public static final String DEVICEID = "device_id";


    }

    public class RequestResponseKeys {
        public static final String users = "users";
        public static final String name = "name";
        public static final String email = "email";
        public static final String uid = "uid";
        public static final String provider = "provider";
        public static final String password = "password";
        public static final String otp = "token";
        public static final String username = "username";
        public static final String remote_profile_picture_url = "remote_profile_picture_url";
        public static final String country = "country";
        public static final String city = "city";
        public static final String phone_number = "phone_number";
        public static final String profile_picture_url = "profile_picture_url";
        public static final String role = "role";
        public static final String open_at = "open_at";
        public static final String close_at = "close_at";
        public static final String total_seats = "total_seats";
        public static final String opening_days = "opening_days";
        public static final String profile_picture = "profile_picture";
        public static final String auth_key = "auth_key";
        public static final String device_token = "device_token";
        public static final String device_type = "device_type";
        public static final String auth_token = "auth_token";
        public static final String auth_token_for_header = "auth-token";
        public static final String address = "address";
        public static final String restaurant_detail_attributes = "restaurant_detail_attributes";
        public static final String user_detail_attributes = "user_detail_attributes";
        public static final String current_password = "current_password";
        public static final String new_password = "new_password";
        public static final String dishName = "dish_name";
        public static final String ingredientsArray = "ingredients";
        public static final String ndbno = "ndbno";
        public static final String ingredientName = "name";
        public static final String quantity = "quantity";
        public static final String createNewDish = "CREATENEWDISH";
        public static final String id = "id";
        public static final String bar_code = "bar_code";
        public static final String dish = "dish";
        public static final String image = "image";
        public static final String latitude = "latitude";
        public static final String longitude = "longitude";
    }

    public class StringConstants {
        public static final String isLogin = "isLogin";
        public static final String consumerRole = "consumer";
        public static final String facebookProvider = "facebook";
        public static final String restaurantRole = "restaurant";
        public static final String deviceType = "Android";
        ///this will replace once we get device id
        public static final String deviceToken = "123456789";
        //re Type
        public static final String get = "GET";
        public static final String post = "POST";
        // public static final String put = "PUT";
        public static final String delete = "DELETE";
    }


    public class StringActivityName {
        public static final String mainActivity = "HomePage";
        public static final String splashScreenActivity ="SplashActivity";
        public static final String loginActivity = "LoginScreenActivity";
        public static final String ChangePasswordActivity = "ChangePassword";
        public static final String forgetPasswordActivity = "ForgotPassword";
        public static final String registerActivity = "RegisterActivity";
        public static final String editProfileActivity = "EditProfile";
        public static final String orderActivity = "OrderFragment";
        public static final String orderConfirmationActivity = "OrderConfirmationActivity";
        public static final String productDescriptionActivity = "ProductDescription";
        public static final String productDetailActivity = "ProductDetails";
        public static final String resendConfirmationActivity = "ResendConfirmationLink";
        public static final String setProductPriceActivity = "SetProductPrice";
        public static final String shoppingCartActivity = "ShoppingCart";
    }



    public class IntegerConstants {
        public static final long tenMb = 10485760;
        public static final int cameraConstant = 1;
        public static final int galleryConstant = 2;
        public static final int passwordLength = 8;

    }

    public enum LogType {
        VERBOSE_LOG,
        ERROR_LOG
    }

    public static Typeface getTypeFace(Context context, String fontName){

        return Typeface.createFromAsset(context.getAssets(), "fonts/"+fontName);
    }

    public static String capitalizeString(String string) {
        char[] chars = string.toLowerCase().toCharArray();
        boolean found = false;
        for (int i = 0; i < chars.length; i++) {
            if (!found && Character.isLetter(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
                found = true;
            } else if (Character.isWhitespace(chars[i]) || chars[i]=='.' || chars[i]=='\'') { // You can add other chars here
                found = false;
            }
        }
        return String.valueOf(chars);
    }



}
