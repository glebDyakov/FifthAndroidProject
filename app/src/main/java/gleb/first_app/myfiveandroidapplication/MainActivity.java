package gleb.first_app.myfiveandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private EditText editText;
    private FloatingActionButton btn_float;
    private List<ChatModel> list_chat=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.list_of_mest);
        editText=findViewById(R.id.user_input);
        btn_float=findViewById(R.id.floatBtn);
        btn_float.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onCLick(ew view){
                String text = editText.getText().toString();
                editText.setText("");
                ChatModel model= new ChatModel(text, true);
                list_chat.add(model);
                new BotAPI().execute(list_chat);
            }
        })
    }

    private class BotAPI extends AsyncTask<List<CatModel>,Void,String> {
        String stream = null;
        List<ChatModel> models;
        String text =editText.getText().toString();
        @Override
        public String (List<ChatModel>... lists){
            String url=String.format("//sandbox.api.simsimi.com/request.p?key=%s&lc=en&ft=1.0&text=%s"getString(R.string.bot_key),text);
            models=lists[0];
            HttpDataHandler httpDataHandler=new HttpDataHandler();
            stream = httpDataHandler.getHttp_Response(url);
            return stream;
        }
        @Override
        protected void onPostExecute(Strings s){
            Gson gson = new Gson();
            BotModel result = gson.fromJson(s, BotModel.class);
            ChatModel chatModel = new ChatModel();
            models.add(chatModel);
            CustomList listShow= new CustomList(models, getApplicationContext());
            listView.setAdapter(listShow);
        }
    }
}