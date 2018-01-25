package com.achers.tinkermain;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.achers.tinkermain.Tinker.TinkerManager;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private String mPath;
    private ImageView iv;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView) findViewById(R.id.iv);

        mPath = getExternalCacheDir().getAbsolutePath() + File.separatorChar;
    }

    /**
     * 加载Tinker补丁
     *
     * @param view
     */
    public void Fix(View view) {
        File patchFile = new File(mPath, "patch_signed.apk");
        if (patchFile.exists()) {
            TinkerManager.addPatch(patchFile.getAbsolutePath());
            Toast.makeText(this, "File Exists,Please wait a moment ", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "File No Exists", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 新增的按钮点击事件
     *
     * @param view
     */
    public void Load(View view) {
        iv.setImageResource(R.drawable.ic_launcher_background);
    }
}
