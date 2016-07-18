package com.appbootup.smspooler.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.crashlytics.android.Crashlytics;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import okhttp3.OkHttpClient;

public class SMSReceiver extends BroadcastReceiver {
    public static final String SMS_EXTRA_NAME = "pdus";
    public static final String DEFAULT_SMS_DESTINATION = "9741155365";
    public static final String DEFAULT_CHANNEL_DESTINATION = "@summerishere";
    public static final String DEFAULT_BOT = "bot225799024:AAEul4xvfHamRNRW8HzTzqimHbWIol-Jex8";
    public static final String DEFAULT_ID_DESTINATION = "160437079";
    public static final String telegramBaseURL = "https://api.telegram.org/";
    public final Gson gson = gson();


    private static Gson gson() {
        return new Gson();
    }

    private static final String TAG = "SMSReceiver";
    final OkHttpClient client = new OkHttpClient();

    public void onReceive(Context context, Intent intent) {
        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(context);

        String forwardToNumber = SP.getString("forward_to_number", DEFAULT_SMS_DESTINATION);
        String forwardToChannel = SP.getString("forward_to_channel", "");
        String forwardToID1 = SP.getString("forward_to_id1", "");
        String forwardToID2 = SP.getString("forward_to_id2", "");
        String forwardBot = SP.getString("forward_bot", DEFAULT_BOT);
        Boolean smsSwitch = SP.getBoolean("sms_switch", false);
        Boolean telegramSwitch = SP.getBoolean("telegram_switch", false);

        Bundle extras = intent.getExtras();

        String message = "";

        if (extras != null) {
            Object[] smsExtra = (Object[]) extras.get(SMS_EXTRA_NAME);

            for (int i = 0; i < smsExtra.length; ++i) {
                SmsMessage sms = SmsMessage.createFromPdu((byte[]) smsExtra[i]);

                String body = sms.getMessageBody();
                String address = sms.getOriginatingAddress();
                message += "[SMS from " + address + "] \n";
                message += body + "\n";

                if (BankingSMSRegexConstants.smsBankingAddressCodes
                        .contains(address)) {
                    if (smsSwitch) {
                        sendSMS(context, message, forwardToNumber);
                    }
                }
                if (telegramSwitch) {
                    if(!"".equals(forwardToChannel)) {
                        sendTelegram(context, message, forwardBot, forwardToChannel);
                    }
                    if(!"".equals(forwardToID1)) {
                        sendTelegram(context, message, forwardBot, forwardToID1);
                    }
                    if(!"".equals(forwardToID2)) {
                        sendTelegram(context, message, forwardBot, forwardToID2);
                    }
                }
            }
        }
    }

    public void sendSMS(final Context context, String message, String number) {
        SmsManager sm = SmsManager.getDefault();
        sm.sendTextMessage(number, null, message, null, null);
        Toast.makeText(context, message, Toast.LENGTH_SHORT)
                .show();
    }

    public void sendTelegram(final Context context, final String message, final String forwardBot, final String forwardTo) {
        RequestQueue queue = Volley.newRequestQueue(context);
        try {
            String encodedMessage = URLEncoder.encode(message, "UTF-8");
            final String url = telegramBaseURL + forwardBot + "/sendMessage?chat_id=" + forwardTo + "&text=" + encodedMessage;

            JsonObjectRequest jsonObjRequest = new JsonObjectRequest(Request.Method.GET, url, null, new com.android.volley.Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Toast.makeText(context, message, Toast.LENGTH_SHORT)
                            .show();
                }
            }, new ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    String message = new String(error.networkResponse.data);
                    if (message.contains("error_code")) {
                        Log.e(TAG, message);
                        Crashlytics.logException(new Throwable(message));
                    }
                    if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                        Log.e(TAG, error.toString());
                        Log.e(TAG, Log.getStackTraceString(error));
                        //Toast.makeText(context, context.getString(R.string.error_network_timeout), Toast.LENGTH_LONG).show();
                        Crashlytics.logException(new RuntimeException(error));
                    } else if (error instanceof AuthFailureError || error instanceof ServerError || error instanceof NetworkError || error instanceof ParseError) {
                        Log.e(TAG, error.toString());
                        Log.e(TAG, Log.getStackTraceString(error));
                        Crashlytics.logException(new RuntimeException(error));
                    }
                }
            });
            jsonObjRequest.setRetryPolicy(new DefaultRetryPolicy(1000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            queue.add(jsonObjRequest);
        } catch (UnsupportedEncodingException e) {
            Crashlytics.logException(new RuntimeException(e));
            Log.e(TAG, e.getMessage());
            Log.e(TAG, Log.getStackTraceString(e));
        }
    }
}