package com.example.stas.wearmessage;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

public class GetMessageService extends WearableListenerService {

    private static final String MESSAGE_RECEIVED = "/message1";


    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        showToast(messageEvent.getPath());

        if (messageEvent.getPath().equals(MESSAGE_RECEIVED)) {



            Intent startIntent = new Intent(this, NavigationActivity.class);
            startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(startIntent);
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

}