package gleb.first_app.myfiveandroidapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class CustomList extends BaseAdapter {
    private List<ChatModel> list_chat_mess;
    private Context context;
    private LayoutInflater layout;

    public CustomList(List<ChatModel> list_chat_mess, Context context, LayoutInflater layout) {
        this.list_chat_mess = list_chat_mess;
        this.context = context;
        this.layout = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list_chat_mess.size();
    }

    @Override
    public Object getItem(int i) {
        return list_chat_mess.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            if(list_chat_mess.get(i).isSend){
                view=layout.inflate(R.layout.list_mess_send,null);
            }else(list_chat_mess.get(i).isSend){
                view=layout.inflate(R.layout.list_mess_receive,null);
            }
            BubbleTextView txt_mess = ()view.findViewById(R.id.text_mess);
            txt_mess.setText(list_chat_mess.get(i).message);
        }
        return view;
    }
}
