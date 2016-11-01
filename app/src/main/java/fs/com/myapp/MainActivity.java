package fs.com.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //默认初始化
        Bmob.initialize(this,"a77a390f56b020415c05eec3d9f7d28d");

        //设置Bmob的config
        BmobConfig config=new BmobConfig.Builder(this)
                .setApplicationId("a77a390f56b020415c05eec3d9f7d28d")
                .setConnectTimeout(30)
                .setUploadBlockSize(1024*1024)
                .setFileExpiration(2500)
                .build();
        Bmob.initialize(config);

    }


    public void add(View view) {

        Person person=new Person();
        person.setName("张三");
        person.setDesc("领导");
        person.setAge(40);
        person.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if ( e==null){
                    Toast.makeText(MainActivity.this,"添加成功了",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this,e.toString(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void query(View view) {
        BmobQuery<Person> bmobQuery =new BmobQuery<>();
        bmobQuery.getObject("5e592529dd", new QueryListener<Person>() {
            @Override
            public void done(Person person, BmobException e) {
                if (e==null){
                    Toast.makeText(MainActivity.this,"查询成功了",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this,e.toString(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void delete(View view) {
        Person person=new Person();
        person.delete("6bad152aed",new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e==null){
                    Toast.makeText(MainActivity.this,"删除成功了",Toast.LENGTH_LONG).show();
                }else {
                    Log.i("single",e.toString());
                    Toast.makeText(MainActivity.this,e.toString(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void update(View view) {
        Person person=new Person();
        person.setAge(18);
        person.setName("小明");
        person.setDesc("学生");
        person.update("f3137aa694", new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e==null){
                    Toast.makeText(MainActivity.this,"替换成功了",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this,e.toString(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
