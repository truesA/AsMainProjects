package com.achers.tinkermain.Tinker;

import android.content.Context;

import com.achers.tinkermain.Utils.MD5Utils;
import com.tencent.tinker.lib.listener.DefaultPatchListener;
import com.tencent.tinker.loader.shareutil.ShareConstants;

public class CustomPatchListener extends DefaultPatchListener {

    private String currentMD5;

    public void setCurrentMD5(String md5Value) {
        this.currentMD5 = md5Value;
    }

    public CustomPatchListener(Context context) {
        super(context);
    }

    /**
     * patch的检测
     *
     * @param path
     * @return
     *  //MD5校验的工具可以网上查找
    //这里要求我们在初始化Tinker的时候加上MD5的参数
    //增加patch文件的md5较验
     */

    @Override
    protected int patchCheck(String path, String patchMd5) {
        if (!MD5Utils.isFileMD5Matched(path, patchMd5)) {
            return ShareConstants.ERROR_PATCH_DISABLE;
        }
        return super.patchCheck(path, patchMd5);
    }
//    @Override
//    protected int patchCheck(String path) {
//        //增加patch文件的md5较验
//        if (!MD5Utils.isFileMD5Matched(path, currentMD5)) {
//            return ShareConstants.ERROR_PATCH_DISABLE;
//        }
//        return super.patchCheck(path);
//    }


}
