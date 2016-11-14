package com.example.administrator.mycontacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class AddContactsActivity extends AppCompatActivity {
    // 声明界面控件属性
    private EditText nameEditText;
    private EditText mobileEditText;
    private EditText qqEditText;
    private EditText danweiEditText;
    private EditText addressEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        setTitle("添加联系人");
        // 获取界面控件实例
        nameEditText = (EditText) findViewById(R.id.name);
        mobileEditText = (EditText) findViewById(R.id.mobile);
        danweiEditText = (EditText) findViewById(R.id.danwei);
        addressEditText = (EditText) findViewById(R.id.address);
        qqEditText = (EditText) findViewById(R.id.qq);
    }

    // 创建选项菜单
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
                    // 创建User对象
                    User user = new User();
                    // user对象赋值
                    user.setName(nameEditText.getText().toString());
                    user.setMobile(mobileEditText.getText().toString());
                    user.setQq(qqEditText.getText().toString());
                    user.setDanwei(danweiEditText.getText().toString());
                    user.setAddress(addressEditText.getText().toString());
                    // 创建数据表对象
                    ContactsTable contactsTable = new ContactsTable(AddContactsActivity.this);
                    // 数据表增加数据
                    if(contactsTable.addData(user)){
                        Toast.makeText(this,"添加成功", Toast.LENGTH_LONG).show();

                        finish();
                    }else{
                        Toast.makeText(this,"添加失败",Toast.LENGTH_LONG).show();
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
    //选项菜单点击事件
}
