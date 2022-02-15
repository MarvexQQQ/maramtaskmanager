package Mydata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.maramtaskmanager.R;

public class MyTaskAdapter extends ArrayAdapter<MyTask> {
    public MyTaskAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
      //View view=View.inflate(getContext(), R.layout.task_item_layout,parent);
      View v= LayoutInflater.from(getContext()).inflate(R.layout.task_item_layout,parent,false);
       MyTask item = getItem(position);
        TextView title=v.findViewById(R.id.itemTaskTitle);
        TextView subj=v.findViewById(R.id.itemTaskSugject);
        ImageButton delete=v.findViewById(R.id.itembtndel);
        ImageButton pencil=v.findViewById(R.id.itembtnpen);
        ImageButton phone=v.findViewById(R.id.itembtncall);
        RatingBar bar=v.findViewById(R.id.itemstar);
        ImageView img=v.findViewById(R.id.itemimg);


        title.setText(item.getTitle());
        subj.setText(item.getSubject());
        bar.setRating(5*(item.getImportant()/(float)10));
       // if (item.getImage()==null||) {

            return v;
        }

    }

