package com.example.khoavin.nativemusic.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.khoavin.nativemusic.R;
import com.example.khoavin.nativemusic.ToolsFactory.RoundImage;

import org.w3c.dom.Text;

/**
 * Created by KhoaVin on 17/12/2016.
 */

public class GridViewAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mWeb;
    private int[] imageId;
    public GridViewAdapter(Context c,String[] webs,int[] images){
        mContext = c;
        mWeb = webs;
        imageId = images;
    }
    @Override
    public int getCount() {
        return mWeb.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        grid = convertView;
        ViewHolder holder = null;

        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            grid = inflater.inflate(R.layout.single_grid,null);

            holder = new ViewHolder();
            holder.textView = (TextView)grid.findViewById(R.id.grid_text);
            holder.imageView = (ImageView)grid.findViewById(R.id.grid_image);

            grid.setTag(holder);
        }
        else{
            holder = (ViewHolder)grid.getTag();
        }

        holder.textView.setText(mWeb[position]);
        //System.out.println(imageId[position]+" - - "+R.drawable.nhac_dan_ca);
//            Bitmap bitmap = BitmapFactory.decodeResource(grid.getResources(),imageId[position]);
//            RoundImage roundImage = new RoundImage(bitmap);
//            imageView.setImageDrawable(roundImage);
        holder.imageView.setImageResource(imageId[position]);

        return grid;
    }

    private class ViewHolder
    {
        public TextView textView;
        public ImageView imageView;
    }
}
