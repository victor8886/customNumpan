package com.zhen.victor.mynumkey;

import android.content.Context;
import android.content.res.TypedArray;
import android.renderscript.ScriptGroup;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by victor on 17-7-28.
 */

public class MyNumPan extends LinearLayout implements View.OnClickListener {
    Button btn_0;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_00;
    Button btn_dot;
    Button btn_complete;
    Button btn_del;
    Button btn_clear;
    private EditText editText;

    public MyNumPan(Context context) {
        this(context, null);
    }

    public void bindEditText(EditText editText) {
        this.editText = editText;
        editText.setGravity(Gravity.END);
        editText.setInputType(InputType.TYPE_NULL);
    }

    private void initView(Context context, AttributeSet attrs) {
        View view = LayoutInflater.from(context).inflate(R.layout.num_key_layout, this, true);
        btn_0 = (Button) view.findViewById(R.id.button_0);
        btn_1 = (Button) view.findViewById(R.id.button_1);
        btn_2 = (Button) view.findViewById(R.id.button_2);
        btn_3 = (Button) view.findViewById(R.id.button_3);
        btn_4 = (Button) view.findViewById(R.id.button_4);
        btn_5 = (Button) view.findViewById(R.id.button_5);
        btn_6 = (Button) view.findViewById(R.id.button_6);
        btn_7 = (Button) view.findViewById(R.id.button_7);
        btn_8 = (Button) view.findViewById(R.id.button_8);
        btn_9 = (Button) view.findViewById(R.id.button_9);
        btn_00 = (Button) view.findViewById(R.id.button_00);
        btn_dot = (Button) view.findViewById(R.id.button_dot);
        btn_del = (Button) view.findViewById(R.id.button_del);
        btn_clear = (Button) view.findViewById(R.id.button_clear);
        btn_complete = (Button) view.findViewById(R.id.button_complete);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MyNumPan);
        if (array != null) {
            String string = array.getString(R.styleable.MyNumPan_button_name);
            if (!TextUtils.isEmpty(string)) {
                btn_complete.setText(string);
            } else {
                btn_complete.setText("完成");
            }
        }
        array.recycle();
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_00.setOnClickListener(this);
        btn_dot.setOnClickListener(this);

        btn_del.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_complete.setOnClickListener(this);
    }

    View.OnClickListener completeListener;

    public void setOnCompleteListener(View.OnClickListener completeListener) {
        this.completeListener = completeListener;
    }

    public MyNumPan(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyNumPan(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    @Override
    public void onClick(View v) {
        if (editText == null) {
            return;
        }
        String s = editText.getText().toString();
        switch (v.getId()) {
            case R.id.button_0:
                if(s.contains(".")&& s.length()-s.indexOf(".")>2){
                    return;
                }
                editText.append("0");
                break;
            case R.id.button_1:
                if(s.contains(".")&& s.length()-s.indexOf(".")>2){
                    return;
                }
                editText.append("1");
                break;
            case R.id.button_2:
                if(s.contains(".")&& s.length()-s.indexOf(".")>2){
                    return;
                }
                editText.append("2");
                break;
            case R.id.button_3:
                if(s.contains(".")&& s.length()-s.indexOf(".")>2){
                    return;
                }
                editText.append("3");
                break;
            case R.id.button_4:
                if(s.contains(".")&& s.length()-s.indexOf(".")>2){
                    return;
                }
                editText.append("4");
                break;
            case R.id.button_5:
                if(s.contains(".")&& s.length()-s.indexOf(".")>2){
                    return;
                }
                editText.append("5");
                break;
            case R.id.button_6:
                if(s.contains(".")&& s.length()-s.indexOf(".")>2){
                    return;
                }
                editText.append("6");
                break;
            case R.id.button_7:
                if(s.contains(".")&& s.length()-s.indexOf(".")>2){
                    return;
                }
                editText.append("7");
                break;
            case R.id.button_8:
                if(s.contains(".")&& s.length()-s.indexOf(".")>2){
                    return;
                }
                editText.append("8");
                break;
            case R.id.button_9:
                if(s.contains(".")&& s.length()-s.indexOf(".")>2){
                    return;
                }
                editText.append("9");
                break;
            case R.id.button_00:
                if (TextUtils.isEmpty(s)) {
                    editText.append("0");
                    break;
                }
                if(s.contains(".")&& s.length()-s.indexOf(".")>2){
                    break;
                }
                editText.append("00");
                break;
            case R.id.button_del:
                int loacation = editText.getSelectionEnd();
                Editable text = editText.getText();
                if (text.length()>0)
                    text.delete(loacation-1, loacation);
                break;
            case R.id.button_dot:
                String content = editText.getText().toString();

                if (TextUtils.isEmpty(content)) {
                    editText.append("0.");
                    break;
                }else if (content.contains(".")) {
                    break;
                } else {
                    editText.append(".");
                }
                break;
            case R.id.button_clear:
                editText.setText("");
                break;
            case R.id.button_complete:
                if (completeListener != null) {
                   completeListener.onClick(v);
                }
                break;
        }
    }
}
