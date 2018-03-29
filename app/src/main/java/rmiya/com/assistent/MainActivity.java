package rmiya.com.assistent;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bvapp.arcmenulibrary.ArcMenu;
import com.bvapp.arcmenulibrary.widget.FloatingActionButton;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private static final int RECONOCEDOR_VOZ = 7;
    private TextView escuchando;

//    private ProgressBar progressBar;
//    private SpeechRecognizer speech = null;
//    private Intent recognizerIntent;
//    static final int REQUEST_PERMISSION_KEY = 1;

    String arrayName[] = {
            "Facebook",
            "Twitter",
            "Youtube",
            "Windows",
            "Drive"
    };
    CircleMenu circleMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        //CAMBIAR FONT FAMILY
        String fuente1 = "font/Anurati-Regular.otf";
        Typeface anutari = Typeface.createFromAsset(getAssets(), fuente1);

        TextView text_alexa = (TextView) findViewById(R.id.ale);
        text_alexa.setTypeface(anutari);


        //OBTIENDO VALORES

        inicializar();

        //CIRCLE MENU
        circleMenu = (CircleMenu) findViewById(R.id.circle_menu);
        circleMenu.setMainMenu(Color.parseColor("#00FFFFFF"), R.drawable.soundw, R.drawable.icon_cancel)
                .addSubMenu(Color.parseColor("#258CFF"), R.drawable.headphones)
                .addSubMenu(Color.parseColor("#30A400"), R.drawable.icon_search)
                .addSubMenu(Color.parseColor("#FF4B32"), R.drawable.icon_notify)
                .addSubMenu(Color.parseColor("#8A39FF"), R.drawable.icon_setting)
                .addSubMenu(Color.parseColor("#FF6A00"), R.drawable.icon_gps)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {

                    @Override
                    public void onMenuSelected(int index) {
                        switch (index) {
                            case 0:

                                Toast.makeText(MainActivity.this, "ingreso", Toast.LENGTH_SHORT).show();
                                Intent hablar = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                                hablar.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "es-MX");
                                startActivityForResult(hablar, RECONOCEDOR_VOZ);


                                break;
                            case 1:

                        }
                    }

                });

    }

    public void inicializar(){
        escuchando = findViewById(R.id.textView1);
    }

    @Override
    public void onInit(int status) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK && requestCode == RECONOCEDOR_VOZ){
            ArrayList<String> reconocido = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String escuchado = reconocido.get(0);
            escuchando.setText(escuchado);
        }
    }

//    PROXIMAMENTE
//    public ArrayList<Respuestas> proveerDatos(){
//        ArrayList<Respuestas> respuestas = new ArrayList<>();
//        respuestas.add(new Respuestas("defecto", "¡Aun no estoy programada para responder eso, lo siento!"));
//        respuestas.add(new Respuestas("hola", "hola que tal"));
//        respuestas.add(new Respuestas("chiste", "¿Sabes que mi hermano anda en bicicleta desde los 4 años? Mmm, ya debe estar lejos"));
//        respuestas.add(new Respuestas("adios", "que descanses"));
//        respuestas.add(new Respuestas("como estas", "esperando serte de ayuda"));
//        respuestas.add(new Respuestas("nombre", "mis amigos me llaman Mina"));
//        return respuestas;
//    }


}


//FAIL


//        progressBar = (ProgressBar) findViewById(R.id.progressBar1);

//        String[] PERMISSIONS = {Manifest.permission.RECORD_AUDIO};
//        if(!Function.hasPermissions(this, PERMISSIONS)){
//            ActivityCompat.requestPermissions(this, PERMISSIONS, REQUEST_PERMISSION_KEY);
//        }

//        progressBar.setVisibility(View.INVISIBLE);
//        speech = SpeechRecognizer.createSpeechRecognizer(this);
//        speech.setRecognitionListener(this);
//        recognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
//        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE,
//                "en");
//        recognizerIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,
//                this.getPackageName());
//        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
//                RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
//        recognizerIntent.putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true);

        /*
        Minimum time to listen in millis. Here 5 seconds
         */
//        recognizerIntent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_MINIMUM_LENGTH_MILLIS, 5000);
//        recognizerIntent.putExtra("android.speech.extra.DICTATION_MODE", true);






//    @Override
//    public void onResume() {
//        super.onResume();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        if (speech != null) {
//            speech.destroy();
//            Log.d("Log", "destroy");
//        }
//
//    }
//
//    @Override
//    public void onBeginningOfSpeech() {
//        Log.d("Log", "onBeginningOfSpeech");
//        progressBar.setVisibility(View.VISIBLE);
//    }
//
//    @Override
//    public void onBufferReceived(byte[] buffer) {
//        Log.d("Log", "onBufferReceived: " + buffer);
//    }
//
//    @Override
//    public void onEndOfSpeech() {
//        Log.d("Log", "onEndOfSpeech");
//        progressBar.setVisibility(View.INVISIBLE);
//        circleMenu.setEnabled(true);
//    }
//
//    @Override
//    public void onError(int errorCode) {
//        String errorMessage = getErrorText(errorCode);
//        Log.d("Log", "FAILED " + errorMessage);
//        progressBar.setVisibility(View.INVISIBLE);
//        returnedText.setText(errorMessage);
//        circleMenu.setEnabled(true);
//    }
//
//    @Override
//    public void onEvent(int arg0, Bundle arg1) {
//        Log.d("Log", "onEvent");
//    }
//
//    @Override
//    public void onPartialResults(Bundle arg0) {
//        Log.d("Log", "onPartialResults");
//
//        ArrayList<String> matches = arg0.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
//        String text = "";
//        /* To get all close matchs
//        for (String result : matches)
//        {
//            text += result + "\n";
//        }
//        */
//        text = matches.get(0); //  Remove this line while uncommenting above codes
//        returnedText.setText(text);
//    }
//
//    @Override
//    public void onReadyForSpeech(Bundle arg0) {
//        Log.d("Log", "onReadyForSpeech");
//    }
//
//    @Override
//    public void onResults(Bundle results) {
//        Log.d("Log", "onResults");
//
//    }
//
//    @Override
//    public void onRmsChanged(float rmsdB) {
//        Log.d("Log", "onRmsChanged: " + rmsdB);
//        progressBar.setProgress((int) rmsdB);
//
//    }
//
//    public static String getErrorText(int errorCode) {
//        String message;
//        switch (errorCode) {
//            case SpeechRecognizer.ERROR_AUDIO:
//                message = "Audio recording error";
//                break;
//            case SpeechRecognizer.ERROR_CLIENT:
//                message = "Client side error";
//                break;
//            case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
//                message = "Insufficient permissions";
//                break;
//            case SpeechRecognizer.ERROR_NETWORK:
//                message = "Network error";
//                break;
//            case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
//                message = "Network timeout";
//                break;
//            case SpeechRecognizer.ERROR_NO_MATCH:
//                message = "No match";
//                break;
//            case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
//                message = "RecognitionService busy";
//                break;
//            case SpeechRecognizer.ERROR_SERVER:
//                message = "error from server";
//                break;
//            case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
//                message = "No speech input";
//                break;
//            default:
//                message = "Didn't understand, please try again.";
//                break;
//        }
//        return message;
//    }
//
//}
//
