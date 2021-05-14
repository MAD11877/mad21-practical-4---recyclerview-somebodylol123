package sg.edu.np.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.nfc.Tag;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    ArrayList<User> userList = new ArrayList<>();
    private ImageView imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (int i = 0; i < 20; i ++){
            User user = new User("Name" + rng(), String.valueOf(rng()), rngBool());
            userList.add(user);
        }
        setContentView(R.layout.activity_list);
        /*imageButton = findViewById(R.id.imageView);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userQuery();
            }
        });*/

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        UserAdapter userAdapter = new UserAdapter(userList,ListActivity.this);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(userAdapter);
    }

//    private void userQuery(){
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setMessage("I AM GOING MAD. THIS IS ACTUALLY MADness!");
//        builder.setTitle("Profile");
//        builder.setCancelable(false);
//        builder.setNegativeButton("close", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                finish();
//            }
//        });
//        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                int ranVal = rng();
//                Intent intent = new Intent(ListActivity.this, MainActivity.class);
//                intent.putExtra("ranVal",ranVal);
//                startActivity(intent);
//            }
//        });
//        AlertDialog alert = builder.create();
//        alert.show();
//    }

    private int rng(){
        Random ran = new Random();
        int ranVal = ran.nextInt();
        return ranVal;
    }

    private boolean rngBool(){
        Random ran = new Random();
        int ranVal = ran.nextInt(2);
        if (ranVal == 1){
            return true;
        }
        else{
            return false;
        }
    }
}