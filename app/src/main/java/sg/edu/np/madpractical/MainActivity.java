package sg.edu.np.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Serializable {
    private final static String TAG = "Main Activity";
    private TextView header;
    private TextView desc;
    private Button followBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent data = getIntent();
        int position = data.getIntExtra("position",0);
        User user = ListActivity.userList.get(position);
        header = findViewById(R.id.txtName);
        desc = findViewById(R.id.txtDescription);
        header.setText(user.getName());
        desc.setText(user.getDescription());
        followBtn = findViewById(R.id.btnFollow);
        //User user  = new User("Random","Description",true);
        if (user.getFollowed() == true){
            followBtn.setText("UNFOLLOW");
        }
        else{
            followBtn.setText("FOLLOW");
        }
        followBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getFollowed() == false){
                    user.setFollowed(true);
                    followBtn.setText("UNFOLLOW");
                    Toast.makeText(getApplicationContext(),"Followed",Toast.LENGTH_SHORT).show();
                }
                else{
                    user.setFollowed(false);
                    followBtn.setText("FOLLOW");
                    Toast.makeText(getApplicationContext(),"Unfollowed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    
}