package com.example.administrator.mycontacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ContactsMessageActivity extends AppCompatActivity {
    // 声明界面控件属性
    private TextView nameEditText;
    private TextView mobileEditText;
    private TextView qqEditText;
    private TextView danweiEditText;
    private TextView addressEditText;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_message);
        setTitle("联系人信息");
        // 获取界面控件实例
        nameEditText = (TextView) findViewById(R.id.name);
        mobileEditText = (TextView) findViewById(R.id.mobile);
        danweiEditText = (TextView) findViewById(R.id.danwei);
        addressEditText = (TextView) findViewById(R.id.address);
        qqEditText = (TextView) findViewById(R.id.qq);
        // 获得Activity传来的数据
        Bundle localBundle = getIntent().getExtras();
        // id表示用户单击需要修改的记录值的主键
        int id = localBundle.getInt("user_ID");
        ContactsTable ct = new ContactsTable(this);
        // getUserByID()以主键id作为查询条件,调用SQL语句查询出符合条件的联系人数据
        user = ct.getUserByID(id);
        // 将要修改的联系人数据复制到用户界面进行显示
        nameEditText.setText("姓名:"+user.getName());
        mobileEditText.setText("电话:"+user.getMobile());
        danweiEditText.setText("单位:"+user.getDanwei());
        addressEditText.setText("地址:"+user.getAddress());
        qqEditText.setText("QQ:"+user.getQq());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"返回");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
