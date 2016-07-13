package com.appbootup.smspooler.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import java.net.URLEncoder;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SMSReceiver extends BroadcastReceiver {
    public static final String SMS_EXTRA_NAME = "pdus";
    public static final byte[] PASSWORD = new byte[]{0x20, 0x32, 0x34, 0x47,
            (byte) 0x84, 0x33, 0x58};
    private static final String DEFAULT_SMS_DESTINATION = "9741155365";
    private static final String DEFAULT_CHANNEL_DESTINATION = "@summerishere";
    private static final String DEFAULT_BOT = "bot225799024:AAEul4xvfHamRNRW8HzTzqimHbWIol-Jex8";
    private String telegramBaseURL = "https://api.telegram.org/";

    private static final String TAG = "SMSReceiver";
    final OkHttpClient client = new OkHttpClient();

    public void onReceive(Context context, Intent intent) {
        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(context);

        String forwardToNumber = SP.getString("forward_to_number", DEFAULT_SMS_DESTINATION);
        String forwardToChannel = SP.getString("forward_to_channel", DEFAULT_CHANNEL_DESTINATION);
        String forwardBot = SP.getString("forward_bot", DEFAULT_BOT);
        Boolean smsSwitch = SP.getBoolean("sms_switch", false);
        Boolean telegramSwitch = SP.getBoolean("telegram_switch", false);

        Bundle extras = intent.getExtras();

        String message = "";

        if (extras != null) {
            Object[] smsExtra = (Object[]) extras.get(SMS_EXTRA_NAME);

            for (int i = 0; i < smsExtra.length; ++i) {
                SmsMessage sms = SmsMessage.createFromPdu((byte[]) smsExtra[i]);

                String body = sms.getMessageBody().toString();
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
                    sendTelegram(context, message, forwardBot, forwardToChannel);
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

    public void sendTelegram(final Context context, final String message, final String forwardBot, final String forwardToChannel) {
        // the request
        new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... params) {
                String msg = "";
                try {
                    String url = telegramBaseURL + forwardBot + "/sendMessage?chat_id=" + forwardToChannel + "&text=" + URLEncoder.encode(message, "UTF-8");
                    final Request request = new Request.Builder()
                            .url(url)
                            .build();

                    Response response = client.newCall(request).execute();
                    msg = response.body().string();
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
                return msg;
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                Log.e("Response - ", "" + result);
                if (result.contains("ok")) {
                    Toast.makeText(context, message, Toast.LENGTH_SHORT)
                            .show();
                }
            }
        }.execute();

    }
}