/*
 * Copyright 2018-2020 KunMinX
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.jetpack_java.sample_01_lifecycles.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.jetpack_java.R;
import com.example.jetpack_java.common_data.APIs;
import com.example.jetpack_java.common_data.Configs;
import com.kunminx.architecture.ui.BaseActivity;

/**
 * Create by KunMinX at 19/10/16
 */

public class EditorActivity_Lifecycle extends BaseActivity {

    private TextView mTvLocation;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_editor_lifecycle);

        mTvLocation = findViewById(R.id.tv_locate);
        mImageView = findViewById(R.id.iv);

        Glide.with(this).load(APIs.PIC_URL).into(mImageView);

        mTvLocation.setOnClickListener(v -> {
            Intent intent = new Intent(this, LocationActivity_Lifecycle.class);
            startActivityForResult(intent, Configs.REQUEST_LOCATION_INFO);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Configs.REQUEST_LOCATION_INFO:
                String location = data.getStringExtra(Configs.LOCATION_RESULT);
                mTvLocation.setText(location);
                break;
        }
    }
}