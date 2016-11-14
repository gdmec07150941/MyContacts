package com.example.administrator.mycontacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateContactsActivity extends AppCompatActivity {
    // 声明界面控件属性
    private EditText nameEditText;
    private EditText mobileEditText;
    private EditText qqEditText;
    private EditText danweiEditText;
    private EditText addressEditText;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        // 获取界面控件实例
        nameEditText = (EditText) findViewById(R.id.name);
        mobileEditText = (EditText) findViewById(R.id.mobile);
        danweiEditText = (EditText) findViewById(R.id.danwei);
        addressEditText = (EditText) findViewById(R.id.address);
        qqEditText = (EditText) findViewById(R.id.qq);
        // 获得Activity传来的数据
        Bundle localBundle = getIntent().getExtras();
        // id表示用户单击需要修改的记录值的主键
        int id = localBundle.getInt("user_ID");
        ContactsTable ct = new ContactsTable(this);
        // getUserByID()以主键id作为查询条件,调用SQL语句查询出符合条件的联系人数据
        user = ct.getUserByID(id);
        // 将要修改的联系人数据复制到用户界面进行显示
        nameEditText.setText(user.getName());
        mobileEditText.setText(user.getMobile());
        danweiEditText.setText(user.getDanwei());
        addressEditText.setText(user.getAddress());
        qqEditText.setText(user.getQq());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"保存");
        menu.add(0,2,0,"返回");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                if(!nameEditText.getText().toString().trim().equals("")){
                    user.setName(nameEditText.getText().toString());
                    user.setMobile(mobileEditText.getText().toString());
                    user.setQq(qqEditText.getText().toString());
                    user.setDanwei(danweiEditText.getText().toString());
                    user.setAddress(addressEditText.getText().toString());
                    ContactsTable contactsTable = new ContactsTable(this);
                    if(contactsTable.updateUser(user)) {
                        Toast.makeText(this, "修改成功", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(this,"修改失败",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(this,"数据不能为空",Toast.LENGTH_LONG).show();
                }
                break;
            case 2:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
