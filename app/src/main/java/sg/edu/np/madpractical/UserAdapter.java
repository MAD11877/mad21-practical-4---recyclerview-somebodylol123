package sg.edu.np.madpractical;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    public final static String TAG = "UserAdapter";
    ArrayList<User> data;
    Activity context;

    public UserAdapter(ArrayList<User> input, Activity activity) {
        data = input;
        context = activity;
    };

    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item;
        if (viewType == 0){
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.userrecyclerview2,parent,false);
        }
        else {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.userrecyclerview,parent,false);
        }
        return new UserViewHolder(item);
    }

    public void onBindViewHolder(UserViewHolder holder, int position){
        User userobj = data.get(position);
        holder.txt.setText(userobj.getName() + "\n" + "Description "+ userobj.getDescription());
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userQuery(userobj);
            }
        });
        
    }

    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position){
        User userobj = data.get(position);
        Log.v(TAG, "" + userobj.getName().charAt(userobj.getName().length() - 1));
        if (userobj.getName().charAt(userobj.getName().length() - 1) == '7'){
            return 0;
        }
        else {
            return 1;
        }
    }


    private void userQuery(User user){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(user.getName());
        builder.setTitle("Profile");
        builder.setCancelable(true);
        builder.setNegativeButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                context.finish();
            }
        });
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("User", user);
                context.startActivity(intent);
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }


}
