package com.fedorvlasov.lazylist;

//import android.R;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
import com.Akruti.Android.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LazyAdapter extends BaseAdapter {
    
	private String youtubeSampleUrl = "http://img.youtube.com/vi/{0}/default.jpg";
	
    private Activity activity;
    //private String[] data;
    private List<BasicNameValuePair> data;
    private static LayoutInflater inflater=null;
    public ImageLoader imageLoader; 
    
    //List<Map<String, String>>
    //public LazyAdapter(Activity a, String[] d) {
    public LazyAdapter(Activity a, List<BasicNameValuePair> d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader=new ImageLoader(activity.getApplicationContext());
    }

    public int getCount() {
        //return data.length;
    	return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(com.Akruti.Android.R.layout.item, null);

        BasicNameValuePair itemMap = (BasicNameValuePair)data.get(position);
        String sampleUrl = youtubeSampleUrl;
        String imageUrl = sampleUrl.replace("{0}", itemMap.getName()) ;
        
        TextView text=(TextView)vi.findViewById(com.Akruti.Android.R.id.itemText);;
        text.setText(itemMap.getValue());
        
        ImageView image=(ImageView)vi.findViewById(com.Akruti.Android.R.id.itemImage);
        image.setTag(itemMap.getName());
        imageLoader.DisplayImage(imageUrl, activity, image);

        return vi;
    }
}