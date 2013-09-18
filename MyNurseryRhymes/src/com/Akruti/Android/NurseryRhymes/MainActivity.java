/*
 * Copyright 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.Akruti.Android.NurseryRhymes;

import java.util.*;
import com.Akruti.Android.NurseryRhymes.R;
import com.fedorvlasov.lazylist.LazyAdapter;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

public class MainActivity extends ActionBarActivity {
    private boolean mAlternateTitle = false;
    LazyAdapter adapter;
    ListView list;
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        list = (ListView)findViewById(R.id.listRhymes);
        adapter = new LazyAdapter(this, mStrings);
        list.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);

        // Calling super after populating the menu is necessary here to ensure that the
        // action bar helpers have a chance to handle this event.
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(this, "Tapped home", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_refresh:
                Toast.makeText(this, "Fake refreshing...", Toast.LENGTH_SHORT).show();
                getActionBarHelper().setRefreshActionItemState(true);
                getWindow().getDecorView().postDelayed(
                        new Runnable() {
                            @Override
                            public void run() {
                                getActionBarHelper().setRefreshActionItemState(false);
                            }
                        }, 1000);
                break;

            case R.id.menu_search:
                Toast.makeText(this, "Tapped search", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_share:
                Toast.makeText(this, "Tapped share", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    public void onDestroy()
    {
        adapter.imageLoader.stopThread();
        list.setAdapter(null);
        super.onDestroy();
    }
    
    
    private String[] mStrings={
            "http://img.youtube.com/vi/K3YQsmznd4c/default.jpg",
            "http://img.youtube.com/vi/gBEHFFnV3RY/default.jpg",
            "http://img.youtube.com/vi/Bhz2ycHGITw/default.jpg",
            "http://img.youtube.com/vi/iqn7Qm3h1u0/default.jpg",
            "http://img.youtube.com/vi/yyl8n-dzIk8/default.jpg",
            "http://img.youtube.com/vi/SVPmtaHmL4g/default.jpg",
            "http://img.youtube.com/vi/_RQDTNrC6lQ/default.jpg",
            "http://img.youtube.com/vi/UneYkq0FzKA/default.jpg",
            "http://img.youtube.com/vi/oODul5hgIl4/default.jpg",
            "http://img.youtube.com/vi/icUSwG83ES8/default.jpg",
            "http://img.youtube.com/vi/MBxeKG7_Hq4/default.jpg",
            "http://img.youtube.com/vi/lsbFIYSK26E/default.jpg",
            "http://img.youtube.com/vi/OHIbdUmeQwk/default.jpg",
            "http://img.youtube.com/vi/bneJKq-ksjM/default.jpg",
            "http://img.youtube.com/vi/vTvNwAT29Lo/default.jpg",
            "http://img.youtube.com/vi/u_K9hFxSvDM/default.jpg",
            "http://img.youtube.com/vi/F3cedGb7lIo/default.jpg",
            "http://img.youtube.com/vi/Wlc6Mho-PxE/default.jpg",
            "http://img.youtube.com/vi/eh2Ud9KReWY/default.jpg",
            "http://img.youtube.com/vi/fv4kp4ZnSuE/default.jpg",
            "http://img.youtube.com/vi/Izq1E6b4WlQ/default.jpg",
            "http://img.youtube.com/vi/Tbf0cDiqr-U/default.jpg",
            "http://img.youtube.com/vi/e66wIEbiMro/default.jpg",
            "http://img.youtube.com/vi/-ORqKcPJYDg/default.jpg",
            "http://img.youtube.com/vi/tU85Kd-7bjM/default.jpg",
            "http://img.youtube.com/vi/LrM62pv56o0/default.jpg",
            "http://img.youtube.com/vi/yCjJyiqpAuU/default.jpg",
            "http://img.youtube.com/vi/-Xui9N1xjUM/default.jpg"
    };
}
