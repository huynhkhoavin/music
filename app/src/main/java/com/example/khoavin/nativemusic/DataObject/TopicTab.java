package com.example.khoavin.nativemusic.DataObject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.khoavin.nativemusic.Adapter.ListVideoAdapter;
import com.example.khoavin.nativemusic.Adapter.TopicAdapter;
import com.example.khoavin.nativemusic.DataObject.Topic;
import com.example.khoavin.nativemusic.DataObject.Video;
import com.example.khoavin.nativemusic.R;
import com.example.khoavin.nativemusic.VideoPlayerActivity;

import static com.example.khoavin.nativemusic.ToolsFactory.CommonTools.TopicCollectionSource;
import static com.example.khoavin.nativemusic.ToolsFactory.CommonTools.VideoCollectionSource;

/**
 * Created by KhoaVin on 13/12/2016.
 */

public class TopicTab extends Fragment {
    ListView listView;

    Topic[] topicSource;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.topic_fragment,container,false);

        listView = (ListView) view.findViewById(R.id.topic_listview);

        topicSource = TopicCollectionSource;
        TopicAdapter adapter = new TopicAdapter(getActivity().getBaseContext(), topicSource);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Topic item = (Topic) parent.getItemAtPosition(position);

                if(item != null)
                {
//                    Intent intent = new Intent(getActivity(), VideoPlayerActivity.class);
//                    intent.putExtra("TOPIC_NAME", item.getName());
//                    intent.putExtra("TOPIC_IMAGE", item.getImage());
//                    startActivity(intent);

                    Toast.makeText(getContext(), "item found!", Toast.LENGTH_LONG);
                }
                else
                {
                    Toast.makeText(getContext(), "No item found!", Toast.LENGTH_LONG);
                }
            }
        });

        return view;
    }

}