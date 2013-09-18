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

import org.apache.http.message.BasicNameValuePair;

import com.Akruti.Android.NurseryRhymes.R;
import com.fedorvlasov.lazylist.LazyAdapter;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends ActionBarActivity {
	private List<BasicNameValuePair> itemData = new ArrayList<BasicNameValuePair>();
	//BasicNameValuePair pairs = new BasicNameValuePair("","");
	
	
    private boolean mAlternateTitle = false;
    LazyAdapter adapter;
    ListView list;
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        


        itemData.add(new BasicNameValuePair("K3YQsmznd4c", "A B C D E F G"));
        itemData.add(new BasicNameValuePair("gBEHFFnV3RY", "Baa Baa Black Sheep"));
        itemData.add(new BasicNameValuePair("Bhz2ycHGITw", "Diddle, Diddle, Dumpling, My Son John"));
        itemData.add(new BasicNameValuePair("iqn7Qm3h1u0", "Doctor Foster went to Gloucester"));
        itemData.add(new BasicNameValuePair("yyl8n-dzIk8", "Eeny, Meeny, Miny, Moe"));
        itemData.add(new BasicNameValuePair("SVPmtaHmL4g", "Five Little Speckeled Frog"));
        itemData.add(new BasicNameValuePair("_RQDTNrC6lQ", "Hey Diddle Diddle"));
        itemData.add(new BasicNameValuePair("UneYkq0FzKA", "Humpty Dumpty"));
        itemData.add(new BasicNameValuePair("oODul5hgIl4", "Hot Cross Buns"));
        itemData.add(new BasicNameValuePair("icUSwG83ES8", "It's Raining, It's Pouring"));
        itemData.add(new BasicNameValuePair("MBxeKG7_Hq4", "Incy Wincy Spider"));
        itemData.add(new BasicNameValuePair("lsbFIYSK26E", "Jack And Jill, Went Up The Hill"));
        itemData.add(new BasicNameValuePair("OHIbdUmeQwk", "Little Bo Peep"));
        itemData.add(new BasicNameValuePair("bneJKq-ksjM", "Little Miss Muffet"));
        itemData.add(new BasicNameValuePair("vTvNwAT29Lo", "London Bridge Is Falling Down"));
        itemData.add(new BasicNameValuePair("u_K9hFxSvDM", "Mary Had A Little Lamb"));
        itemData.add(new BasicNameValuePair("F3cedGb7lIo", "One, Two, Three, Four, Five"));
        itemData.add(new BasicNameValuePair("Wlc6Mho-PxE", "Pat-a-cake, Pat-a-cake"));
        itemData.add(new BasicNameValuePair("eh2Ud9KReWY", "Polly Put The Kettle On"));
        itemData.add(new BasicNameValuePair("fv4kp4ZnSuE", "Pop goes the Weasel"));
        itemData.add(new BasicNameValuePair("Izq1E6b4WlQ", "Rain Rain Go Away"));
        itemData.add(new BasicNameValuePair("Tbf0cDiqr-U", "Ring a RIng o' Roses"));
        itemData.add(new BasicNameValuePair("e66wIEbiMro", "Row, Row, Row Your Boat"));
        itemData.add(new BasicNameValuePair("-ORqKcPJYDg", "Solomon Grundy"));
        itemData.add(new BasicNameValuePair("tU85Kd-7bjM", "Star Light, Star Bright"));
        itemData.add(new BasicNameValuePair("yCjJyiqpAuU", "Twinkle Twinkle Little Star"));
        itemData.add(new BasicNameValuePair("-Xui9N1xjUM", "The Muffin Man"));
        
        list = (ListView)findViewById(R.id.listRhymes);
        adapter = new LazyAdapter(this, itemData);
        //adapter = new LazyAdapter(this, mStrings);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new OnItemClickListener(){
        	public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {
        		//String videoName = ((TextView) myView.findViewById(R.id.itemText)).getText().toString();
        		//Toast.makeText(getApplicationContext(), "item selected... : "+ videoId, Toast.LENGTH_SHORT).show();
        		String videoId = ((ImageView) myView.findViewById(R.id.itemImage)).getTag().toString();
        		Toast.makeText(getApplicationContext(), "item selected... : "+ videoId, Toast.LENGTH_SHORT).show();
        	}
        	
        });
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
}
