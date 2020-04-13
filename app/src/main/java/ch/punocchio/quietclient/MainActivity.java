package ch.punocchio.quietclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import org.quietmodem.Quiet.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // CUSTOM CODE BELOW
        Log.d("MainActivity", "Hello, World!");
        FrameReceiverConfig receiverConfig = null;
        FrameTransmitterConfig transmitterConfig = null;

        try {
            transmitterConfig = new FrameTransmitterConfig(
                    this,
                    "audible-7k-channel-0");
            receiverConfig = new FrameReceiverConfig(
                    this,
                    "audible-7k-channel-0");
        } catch (IOException e) {
            Log.d("MainActivity", "ERROR IN SETUP, PLEASE CHECK");
            e.printStackTrace();
        }

        FrameReceiver receiver = null;
        FrameTransmitter transmitter = null;

        try {
            receiver = new FrameReceiver(receiverConfig);
        } catch (ModemException e) {
            Log.d("MainActivity", "ERROR IN SETUP OF RECEIVER, PLEASE CHECK!");
            e.printStackTrace();
            Log.d("MainActivity", "END OF ERROR STACK TRACE OF RECEIVER!");
        }

        try {
            transmitter = new FrameTransmitter(transmitterConfig);
        } catch (ModemException e) {
            Log.d("MainActivity", "ERROR IN SETUP OF TRANSMITTER, PLEASE CHECK");
            e.printStackTrace();
        }

        //customReceive(receiver);
        //customTransmit(transmitter);
    }

    private void customReceive(FrameReceiver receiver) {
        receiver.setBlocking(0, 0);

        byte[] buf = new byte[1024];
        long recvLen = 0;
        try {
            Log.d("MainActivity", "TRY RECEIVING");
            recvLen = receiver.receive(buf);
        } catch (IOException e) {
            Log.d("MainActivity", "TIMEOUT ERROR");
            e.printStackTrace();
        }
        Log.d("MainActivity", "FINISHED TRY RECEIVING");
        Log.d("MainActivity", "LENGTH: " + recvLen);
        Log.d("MainActivity", "RECEIVED: " + buf);
    }

    private void customTransmit(FrameTransmitter transmitter) {
        Log.d("MainActivity", "START customTransmit");
        String payload = "Hello, World and Renato!";
        try {
            transmitter.send(payload.getBytes());
        } catch (IOException e) {
            Log.d("MainActivity", "ERROR IN customTransmit");
            e.printStackTrace();
        }
    }
}
