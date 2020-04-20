package ch.punocchio.quietclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;

import java.io.IOException;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

import org.quietmodem.Quiet.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
        /*
        // Use PCAB for log (and feed). We don't have anything to do with that.
        // Use CBOR for log entries. We use them in our interface:
        //  transmit(CBOR) -> void
        //  receive() -> CBOR



        // TCP SETUP

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
            // could not build configs
        }

        NetworkInterfaceConfig conf = new NetworkInterfaceConfig(
                receiverConfig,
                transmitterConfig);

        NetworkInterface intf = null;
        try {
            intf = new NetworkInterface(conf);
        } catch (ModemException e) {
            // network interface failure
            Log.d("MainActivity", "NETWORK INTERFACE FAILURE");
            e.printStackTrace();
        }

        // TCP SETUP END


        DatagramSocket s = null;
        DatagramSocket sSend = null;
        DatagramSocket sRecv = null;
        try {
            Log.d("MainActivity", "1");
            sSend = new DatagramSocket(new InetSocketAddress("0.0.0.0", 3333));
            Log.d("MainActivity", "2");
            sRecv = new DatagramSocket(new InetSocketAddress("0.0.0.0", 3334));
            Log.d("MainActivity", "3");

            sRecv.setSoTimeout(10000);
            Log.d("MainActivity", "4");
            sSend.setBroadcast(true);
            Log.d("MainActivity", "SOCKET SETUP OK!");
        } catch (SocketException e) {
            Log.d("MainActivity", "ERROR WHEN SETTING UP SOCKET.");
            e.printStackTrace();
        }

        byte[] send = "MARCO".getBytes(StandardCharsets.UTF_8);
        byte[] recv = new byte[1024];
        InetSocketAddress peer = null;

        while (true) {
            DatagramPacket p = new DatagramPacket(send, send.length,
                    new InetSocketAddress("169.254.255.255", 3334));

            // SEND
            if (sSend == null)
                Log.d("MainActivity", "sSend IS NULL!");
            else
                Log.d("MainActivity", "sSend IS NOT NULL!");

            try {
                sSend.send(p);
            } catch (IOException e) {
                Log.d("MainActivity", "ERROR WHILE SENDING!");
            }

            // RECV
            DatagramPacket pRecv = new DatagramPacket(recv, recv.length);
            boolean received = false;
            try {
                sRecv.receive(pRecv);

                received = true;
                peer = (InetSocketAddress) pRecv.getSocketAddress();

                // respond so that the other peer knows we're here
                p.setData("POLO".getBytes(StandardCharsets.UTF_8));
                p.setSocketAddress(peer);
                sSend.send(p);
            } catch (IOException e) {
                Log.d("MainActivity", "ERROR WHILE SENDING RESPONSE!");
                e.printStackTrace();
            }

            if (received) {
                Log.d("MainActivity", "RECEIVED !!");
                break;
            }
        }
    }
    */









        /*
        // CUSTOM CODE BELOW (for tcp I guess)
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

        customReceive(receiver);
        //customTransmit(transmitter);
    }

    public void customReceive(FrameReceiver receiver) {
        if (receiver == null) {
            Log.d("MainActivity", "RECEIVER IS NULL!");
        } else {
            Log.d("MainActivity", "RECEIVER IS NOT NULL!");
        }

        receiver.setBlocking(5, 0);

        while (true) {
            Log.d("MainActivity", "BLABLABLA");
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
    }

    public void customTransmit(FrameTransmitter transmitter) {
        Log.d("MainActivity", "START customTransmit");
        String payload = "Hello, World and Renato!";
        while (true) {
            Log.d("MainActivity", "Start transmitting.");
            try {
                transmitter.send(payload.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                Log.d("MainActivity", "ERROR IN customTransmit");
                e.printStackTrace();
            }
            Log.d("MainActivity", "End transmitting, start sleep...");
            SystemClock.sleep(3000);
            Log.d("MainActivity", "Finished sleeping.");
        }
    }
    */

